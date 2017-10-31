package com.guigu.crm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.crm.model.CrmCustomer;
import com.guigu.crm.model.CrmOrders;
import com.guigu.crm.model.CrmOrdersLine;
import com.guigu.crm.model.CustomerDetail;
import com.guigu.crm.model.CustomerOrderOrderDetail;
import com.guigu.crm.model.CustomerQueryVo;
import com.guigu.crm.service.CustomerService;
import com.guigu.crm.service.ExportToExcelService;
import com.guigu.crm.service.OrderService;
import com.guigu.crm.utils.ExportExcel;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.controller.ExportCustomerController  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-7 ����9:11:11    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
@Controller
public class ExportCustomerController {

    @Autowired
    private CustomerService crCustomerService;
    
    @Autowired
    private ExportToExcelService exportToExcelService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private OrderService orderService;
    
    private static int count;
    
    /*===============�����ͻ���Ϣ���==========================*/
    
    //��ѯ���пͻ���Ϣ
    @RequestMapping(value="findAllCustomersForExport")
    public String findAllCustomersForExport(Model model,HttpSession session)throws Exception{
        List<CrmCustomer> customerList=this.crCustomerService.findAllCustomers();
        if(customerList!=null && customerList.size()>0)
        {
            model.addAttribute("customerList", customerList);
            session.setAttribute("customerList", customerList); //�洢��session����
        }
        return "exportCustomerToExcel_ymh/exportCustomer";
    }
    
    //ִ�е�����excel����
    @RequestMapping(value="exportToExcel")
    public void exportToExcel(HttpServletRequest request,HttpServletResponse response)throws Exception{
        
        count++;
        //��session���л�ȡ���ϣ����ǹؼ�
        List<CrmCustomer> customerList= (List<CrmCustomer>) request.getSession().getAttribute("customerList");
        String title="�ͻ�ͳ����Ϣ����Excel";
        //��Щ�ֶ�����д���ģ��׶ˣ�ֻ�ܵ����ͻ���Ϣ��������ͨ����
        String[] headers={"�ͻ����","�ͻ�����","����","�ͻ�������","�ͻ��ȼ�","�ͻ��ȼ�����","�����","���ö�",
                            "��ַ","��������","�绰","����","��ַ","Ӫҵִ��ע���","����","ע���ʽ�","Ӫҵ��","��������","�����˺�",
                            "��˰�ǼǺ�","��˰�ǼǺ�","�ͻ�״̬"};
        //���õ���excel���������  ������Ҫ����
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=customer"+count+".xls"); 
        
        try {
            ExportExcel<CrmCustomer> exproExcel=new ExportExcel<CrmCustomer>();
            exproExcel.exportExcel(title, headers, customerList, response.getOutputStream(), "yyyy-MM-dd");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping(value="findCustomerCondition")
    public String findCustomerCondition(CustomerQueryVo customerQueryVo,Model model,HttpSession session)throws Exception{
        
        //ִ��������ѯ
        List<CrmCustomer> customerList=this.crCustomerService.findCustomerByCondition(customerQueryVo);
        if(customerList!=null && customerList.size()>0)
        {
            model.addAttribute("customerList", customerList);
            session.setAttribute("customerList", customerList);//�洢��session����
        }
        else
        {
            session.setAttribute("customerList", null); //���ǣ�����������������¼ʱ���Ƴ�session��������
        }
        return "exportCustomerToExcel_ymh/exportCustomer";
    }
    
    /*===============�����ͻ��������==========================*/
    @RequestMapping(value="findCustomerAndOrderDetail")
    public String findCustomerAndOrderDetail(Model model)throws Exception{
        
        List<CustomerOrderOrderDetail> detailList=this.exportToExcelService.findOrderDetailOfCustomer();
        if(detailList!=null && detailList.size()>0)
        {
            model.addAttribute("detailList", detailList);
        }
        
        return "exportCustomerToExcel_ymh/exportOrderDetail";
    }
    
    
    //ִ�е���
    @RequestMapping(value="exportDetailToExcel")
    public void exportDetailToExcel(HttpServletResponse response)throws Exception{
    	  count++;
    	
    	//�û���Ž����
    	List<CustomerDetail> customerDetailList=new ArrayList<CustomerDetail>();
    	
    	//1����ѯ�ͻ����ݱ��õ��ͻ�����
    	List<CrmCustomer> customerList=this.customerService.findAllCustomers();
    	//2�������ͻ������ݿͻ���ѯ���ÿͻ��Ķ�������
    	for (CrmCustomer customer : customerList) {
			List<CrmOrders> orderList=this.orderService.findOrdersByCustno(customer.getNo());
			Double totalAmount=calculateAmount(orderList); //������BUG
			//�����POJO
			CustomerDetail customerDetail=new CustomerDetail();
			customerDetail.setCustomerNo(customer.getNo()); //�ͻ����
			customerDetail.setCustomerName(customer.getName()); //�ͻ�����
			customerDetail.setCustomerLevel(customer.getLevelLable()); //�ͻ��ȼ�
			customerDetail.setOrderCount(orderList.size());//��������
			customerDetail.setTotalAmount(totalAmount); //�ܽ��
			//���POJO��ӵ�������
			customerDetailList.add(customerDetail);
		}
    	//�����ǵ���excel����
    	String title="�ͻ�������Ϣ����Excel";
        //��Щ�ֶ�����д���ģ��׶ˣ�ֻ�ܵ����ͻ���Ϣ��������ͨ����
        String[] headers={"�ͻ����","�ͻ�����","�ͻ��ȼ�","����������","��ʷ�ܽ��"};
        //���õ���excel���������  ������Ҫ����
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=customer"+count+".xls"); 
    	
        try {
            ExportExcel<CustomerDetail> exproExcel=new ExportExcel<CustomerDetail>();
            exproExcel.exportExcel(title, headers, customerDetailList, response.getOutputStream(), "yyyy-MM-dd");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    //���붩�����ϣ���ѯÿ�������Ķ�����ϸ���ۼӽ��
    public Double calculateAmount(List<CrmOrders> orderList)throws Exception{
    	
    	if(orderList==null || orderList.size()==0){
    		return 0.0;
    	}
    	double totalAmount=0;
    	for (CrmOrders orders : orderList) {
			//���ݶ�����ѯ������ϸ   һ��������Ӧһ��������ϸ��
    		CrmOrdersLine ordersLine=this.exportToExcelService.queryOrderDetailByOrderId(orders.getId());
    		if(ordersLine!=null)
    		{
    			double temp=0; //һ�ʶ������ܽ��
    			temp=ordersLine.getCount()*ordersLine.getPrice();	
        		totalAmount+=temp;
    		}
		}
    	return totalAmount;
    }
 
}


