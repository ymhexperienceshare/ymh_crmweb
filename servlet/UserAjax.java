package com.guigu.crm.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guigu.crm.controller.SystemController;
import com.guigu.crm.model.CrmLogin;
import com.guigu.crm.model.CrmUserCustom;
import com.guigu.crm.model.CrmUserRoleCustomVo;
import com.guigu.crm.model.UserFlag;
import com.guigu.crm.service.SystemControllerService;
import com.guigu.crm.service.impl.SystemControllerServiceImpl;

public class UserAjax extends HttpServlet{
	
	
	/**
	 *  0---用户未退出(正常)
	 *  1---用户已退出
	 *  2---用户在其他设别上登录
	 *  3---用户被禁用
	 *  4---角色被禁用
	 *  
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String olduserid = request.getParameter("userid");
		int nuserid = -1;
		
		try {
			nuserid = (Integer) request.getSession().getAttribute("userid");
		} catch (Exception e) {
			response.getWriter().println("1");
			return;
		}
		
		CrmLogin crmLogin = (CrmLogin) request.getSession().getAttribute("crmlogin");
		if(crmLogin==null){
			    /*Integer oldid = Integer.valueOf(olduserid);
			    String id = (String) request.getSession().getAttribute("disuserid");
			    Integer disuserid = Integer.valueOf(id);
			    if(disuserid.equals(oldid)){
			    	response.getWriter().println("3");
					return;
			    }*/
			response.getWriter().println("2");
			return;
		}
		
		//登录状态时，用户名被禁用
		Integer userflag = (Integer) request.getSession().getAttribute("userflag");
		Integer disuid = (Integer) request.getSession().getAttribute("disuid");
		Integer oldid = Integer.valueOf(olduserid);
        if(userflag==0 && oldid.equals(disuid)){
            response.getWriter().println("3");
            return;
        }
        
        //登录状态时，角色被禁用
        Integer roleflag = (Integer) request.getSession().getAttribute("roleflag");
        if(roleflag==0){
        	System.out.println(oldid+"-------oldid");
			@SuppressWarnings("unchecked")
			List<CrmUserCustom> useridlist = (List<CrmUserCustom>) request.getSession().getAttribute("useridList");
			if(useridlist!=null){
				for(CrmUserCustom idlist : useridlist){
	        		System.out.println("userid------------"+idlist.getUserid());
	        		System.out.println(idlist.getUserid().equals(oldid));
	        		if(idlist.getUserid().equals(oldid)){
	        			System.out.println("ok");
	        			response.getWriter().println("4");
	        		}
	        	}
	        	return;
			}
        }
		
		String newuserid = String.valueOf(nuserid);
		if(olduserid.equals(newuserid)){
			response.getWriter().println("0");
		}/*else{
			response.getWriter().println("1");
			return;
		}*/
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}

}
