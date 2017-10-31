package com.guigu.crm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object object) throws Exception {
		
		//获得登录的路径
		String url = request.getRequestURI();
		//如果是登录放行
		if(url.indexOf("login.action")>=0){
			return true;
		}
		if(url.indexOf("login0.action")>=0){
			return true;
		}
		
		//不是登录，判断身份是否存在
		String username = (String) request.getSession().getAttribute("username");
		if(username!=null){
			return true;
		}
		
		//用户未登录，禁止访问，跳转到登录界面
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return false;
	}
	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}
