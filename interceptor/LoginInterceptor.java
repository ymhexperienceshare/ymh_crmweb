package com.guigu.crm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object object) throws Exception {
		
		//��õ�¼��·��
		String url = request.getRequestURI();
		//����ǵ�¼����
		if(url.indexOf("login.action")>=0){
			return true;
		}
		if(url.indexOf("login0.action")>=0){
			return true;
		}
		
		//���ǵ�¼���ж�����Ƿ����
		String username = (String) request.getSession().getAttribute("username");
		if(username!=null){
			return true;
		}
		
		//�û�δ��¼����ֹ���ʣ���ת����¼����
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return false;
	}
	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}
