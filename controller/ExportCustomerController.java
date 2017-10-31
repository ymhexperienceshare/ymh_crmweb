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
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.controller.ExportCustomerController  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-7 上午9:11:11    
 * 修改备注：  
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
    
    /*===============导出客户信息相关==========================*/
    
    //查询所有客户信息
    @RequestMapping(value="findAllCustomersForExport")
    public String findAllCustomersForExport(Model model,HttpSession session)throws Exception{
        List<CrmCustomer> customerList=this.crCustomerService.findAllCustomers();
        if(customerList!=null && customerList.size()>0)
        {
            model.addAttribute("customerList", customerList);
            session.setAttribute("customerList", customerList); //存储到session域中
        }
        return "exportCustomerToExcel_ymh/exportCustomer";
    }
    
    //执行导出成excel操作
    @RequestMapping(value="exportToExcel")
    public void exportToExcel(HttpServletRequest request,HttpServletResponse response)throws Exception{
        
        count++;
        //从session域中获取集合，这是关键
        List<CrmCustomer> customerList= (List<CrmCustomer>) request.getSession().getAttribute("customerList");
        String title="客户统计信息导出Excel";
        //这些字段名是写死的，弊端：只能导出客户信息，做不到通用性
        String[] headers={"客户编号","客户名称","地区","客户经理编号","客户等级","客户等级描述","满意度","信用度",
                            "地址","邮政编码","电话","传真","网址","营业执照注册号","法人","注册资金","营业额","开户银行","银行账号",
                            "地税登记号","国税登记号","客户状态"};
        //设置导出excel的相关配置  超级重要！！
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
        
        //执行条件查询
        List<CrmCustomer> customerList=this.crCustomerService.findCustomerByCondition(customerQueryVo);
        if(customerList!=null && customerList.size()>0)
        {
            model.addAttribute("customerList", customerList);
            session.setAttribute("customerList", customerList);//存储到session域中
        }
        else
        {
            session.setAttribute("customerList", null); //明智，不存在满足条件记录时，移除session域中数据
        }
        return "exportCustomerToExcel_ymh/exportCustomer";
    }
    
    /*===============导出客户贡献相关==========================*/
    @RequestMapping(value="findCustomerAndOrderDetail")
    public String findCustomerAndOrderDetail(Model model)throws Exception{
        
        List<CustomerOrderOrderDetail> detailList=this.exportToExcelService.findOrderDetailOfCustomer();
        if(detailList!=null && detailList.size()>0)
        {
            model.addAttribute("detailList", detailList);
        }
        
        return "exportCustomerToExcel_ymh/exportOrderDetail";
    }
    
    
    //执行导出
    @RequestMapping(value="exportDetailToExcel")
    public void exportDetailToExcel(HttpServletResponse response)throws Exception{
    	  count++;
    	
    	//用户存放结果集
    	List<CustomerDetail> customerDetailList=new ArrayList<CustomerDetail>();
    	
    	//1、查询客户数据表，得到客户集合
    	List<CrmCustomer> customerList=this.customerService.findAllCustomers();
    	//2、迭代客户，根据客户查询出该客户的订单集合
    	for (CrmCustomer customer : customerList) {
			List<CrmOrders> orderList=this.orderService.findOrdersByCustno(customer.getNo());
			Double totalAmount=calculateAmount(orderList); //这里有BUG
			//结果集POJO
			CustomerDetail customerDetail=new CustomerDetail();
			customerDetail.setCustomerNo(customer.getNo()); //客户编号
			customerDetail.setCustomerName(customer.getName()); //客户名称
			customerDetail.setCustomerLevel(customer.getLevelLable()); //客户等级
			customerDetail.setOrderCount(orderList.size());//订单总数
			customerDetail.setTotalAmount(totalAmount); //总金额
			//结果POJO添加到集合中
			customerDetailList.add(customerDetail);
		}
    	//以下是导出excel操作
    	String title="客户贡献信息导出Excel";
        //这些字段名是写死的，弊端：只能导出客户信息，做不到通用性
        String[] headers={"客户编号","客户名称","客户等级","订单总数量","历史总金额"};
        //设置导出excel的相关配置  超级重要！！
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=customer"+count+".xls"); 
    	
        try {
            ExportExcel<CustomerDetail> exproExcel=new ExportExcel<CustomerDetail>();
            exproExcel.exportExcel(title, headers, customerDetailList, response.getOutputStream(), "yyyy-MM-dd");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    //传入订单集合，查询每个订单的订单明细，累加金额
    public Double calculateAmount(List<CrmOrders> orderList)throws Exception{
    	
    	if(orderList==null || orderList.size()==0){
    		return 0.0;
    	}
    	double totalAmount=0;
    	for (CrmOrders orders : orderList) {
			//根据订单查询订单明细   一个订单对应一个订单明细！
    		CrmOrdersLine ordersLine=this.exportToExcelService.queryOrderDetailByOrderId(orders.getId());
    		if(ordersLine!=null)
    		{
    			double temp=0; //一笔订单的总金额
    			temp=ordersLine.getCount()*ordersLine.getPrice();	
        		totalAmount+=temp;
    		}
		}
    	return totalAmount;
    }
 
}


