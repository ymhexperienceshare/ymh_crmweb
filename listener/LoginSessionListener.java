package com.guigu.crm.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.guigu.crm.model.CrmLogin;
import com.guigu.crm.model.UserFlag;

public class LoginSessionListener  implements HttpSessionAttributeListener{
	
	//Map中存放用户登录的信息和session值
	Map<Integer, HttpSession> map = new HashMap<Integer, HttpSession>();
	Map<Integer, HttpSession> map1 = new HashMap<Integer, HttpSession>();
	//Map<Integer, HttpSession> map2 = new HashMap<Integer, HttpSession>();

	public void attributeAdded(HttpSessionBindingEvent se) {
		//得到增加的属性的的名字
		String name = se.getName();
		//单状态登录
		if("crmlogin".equals(name)){
			//得到增加的value值
			CrmLogin crmLogin = (CrmLogin) se.getValue();
			if(map.get(crmLogin.getUserId())!=null){
				HttpSession session = map.get(crmLogin.getUserId());
				session.removeAttribute("crmlogin");
				//session.setAttribute("relogin", "您的用户名在其他设备上登录，被迫下线！");
			}
			map.put(crmLogin.getUserId(), se.getSession());
		}
		
		//禁用用户
		/*if("userFlag".equals(name)){
			UserFlag userFlag =  (UserFlag) se.getValue();
			if(map1.get(userFlag.getUserid())!=null&& userFlag.getUserflag()==0){
				HttpSession session = map1.get(userFlag.getUserid());
				session.removeAttribute("userFlag");
			}
			map1.put(userFlag.getUserid(), se.getSession());
			
		}*/
		
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
	  //单状态登录
		String name = se.getName();
		if("crmlogin".equals(name)){
			//将信息从map中移除
			CrmLogin crmLogin = (CrmLogin) se.getValue();
			map.remove(crmLogin.getUserId());
		}
		//禁用用户
		/*if("userFlag".equals(name)){
			//将信息从map中移除
			UserFlag userFlag =  (UserFlag) se.getValue();
			map1.remove(userFlag.getUserid());
		}*/
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		String name = se.getName();
		//单状态登录
		//没有注销直接登录
		if("crmlogin".equals(name)){
			//移除旧信息
			CrmLogin oldcrmLogin = (CrmLogin) se.getValue();
			map.remove(oldcrmLogin.getUserId());
			//得到新登录的信息
			CrmLogin crmLogin = (CrmLogin) se.getSession().getAttribute("crmlogin");
			//检测新登录的是否在其他地方登录
			if(map.get(crmLogin.getUserId())!=null){
				//map中有记录
				HttpSession session = map.get(crmLogin.getUserId());
				session.removeAttribute("crmlogin");
				//session.setAttribute("relogin", "您的用户名在其他设备上登录，被迫下线！");
			}
			map.put(crmLogin.getUserId(), se.getSession());
		}
		
		//禁用用户
		//登录状态下禁用
		/*if("userFlag".equals(name)){
			//移除旧信息
			UserFlag olduserFlag =  (UserFlag) se.getValue();
			map1.remove(olduserFlag.getUserid());
			//得到新状态的信息
			UserFlag userFlag = (UserFlag) se.getSession().getAttribute("userFlag");
			//检测登录状态时被禁用
			if(map1.get(userFlag.getUserid())!=null && userFlag.getUserflag()==0){
				//map中有记录
				HttpSession session = map1.get(userFlag.getUserid());
				session.removeAttribute("userFlag");
			}
			map1.put(userFlag.getUserid(), se.getSession());
		}*/
	}

}
