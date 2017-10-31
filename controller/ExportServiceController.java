package com.guigu.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.crm.model.CrmService;
import com.guigu.crm.service.ExportToExcelService;
import com.guigu.crm.utils.ExportExcel;


@Controller
public class ExportServiceController {
	
	private static int count=0;

	@Autowired
	private ExportToExcelService exportToExcelService;
	
	@RequestMapping(value="findAllServiceForExport")
	public String findAllServiceForExport(Model model,HttpSession session)throws Exception{
		List<CrmService> serviceList=this.exportToExcelService.findAllService();
		if(serviceList!=null && serviceList.size()>0)
		{
			model.addAttribute("serviceList", serviceList);
			session.setAttribute("serviceList", serviceList);//�洢��session�����Ա㵼��ʱ��ȡ
		}
		return "exportServiceToExcel_ymh/exportService";
	}
	
	
	
	@RequestMapping(value="exportServiceToExcel")
	public void exportServiceToExcel(HttpSession session,HttpServletResponse response)throws Exception{
		List<CrmService> serviceList=(List<CrmService>) session.getAttribute("serviceList");
		if(serviceList==null) return;
		
		String title="�ͻ�������Ϣ����Excel";
		String[] headers={"������","��������","�����Ҫ","�ͻ����","�ͻ�����","����״̬","��������","�����˱��",
                "����������","��������","�ͻ�������","�ͻ���������","����ʱ��","������","�����˱��","����������","��������","������","�����"};
		//���õ���excel���������  ������Ҫ����
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=customer"+count+".xls"); 
		
        try {
			ExportExcel<CrmService> exportExcel=new ExportExcel<CrmService>();
			exportExcel.exportExcel(title, headers, serviceList, response.getOutputStream(), "yyyy-MM-dd");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
