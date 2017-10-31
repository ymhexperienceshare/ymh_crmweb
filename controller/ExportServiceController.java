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
			session.setAttribute("serviceList", serviceList);//存储到session域中以便导出时获取
		}
		return "exportServiceToExcel_ymh/exportService";
	}
	
	
	
	@RequestMapping(value="exportServiceToExcel")
	public void exportServiceToExcel(HttpSession session,HttpServletResponse response)throws Exception{
		List<CrmService> serviceList=(List<CrmService>) session.getAttribute("serviceList");
		if(serviceList==null) return;
		
		String title="客户服务信息导出Excel";
		String[] headers={"服务编号","服务类型","服务概要","客户编号","客户名称","服务状态","服务请求","创建人编号",
                "创建人名称","创建日期","客户经理编号","客户经理名称","分配时间","服务处理","处理人编号","处理人名称","处理日期","处理结果","满意度"};
		//设置导出excel的相关配置  超级重要！！
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
