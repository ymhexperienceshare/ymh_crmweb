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
	
	//Map�д���û���¼����Ϣ��sessionֵ
	Map<Integer, HttpSession> map = new HashMap<Integer, HttpSession>();
	Map<Integer, HttpSession> map1 = new HashMap<Integer, HttpSession>();
	//Map<Integer, HttpSession> map2 = new HashMap<Integer, HttpSession>();

	public void attributeAdded(HttpSessionBindingEvent se) {
		//�õ����ӵ����Եĵ�����
		String name = se.getName();
		//��״̬��¼
		if("crmlogin".equals(name)){
			//�õ����ӵ�valueֵ
			CrmLogin crmLogin = (CrmLogin) se.getValue();
			if(map.get(crmLogin.getUserId())!=null){
				HttpSession session = map.get(crmLogin.getUserId());
				session.removeAttribute("crmlogin");
				//session.setAttribute("relogin", "�����û����������豸�ϵ�¼���������ߣ�");
			}
			map.put(crmLogin.getUserId(), se.getSession());
		}
		
		//�����û�
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
	  //��״̬��¼
		String name = se.getName();
		if("crmlogin".equals(name)){
			//����Ϣ��map���Ƴ�
			CrmLogin crmLogin = (CrmLogin) se.getValue();
			map.remove(crmLogin.getUserId());
		}
		//�����û�
		/*if("userFlag".equals(name)){
			//����Ϣ��map���Ƴ�
			UserFlag userFlag =  (UserFlag) se.getValue();
			map1.remove(userFlag.getUserid());
		}*/
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		String name = se.getName();
		//��״̬��¼
		//û��ע��ֱ�ӵ�¼
		if("crmlogin".equals(name)){
			//�Ƴ�����Ϣ
			CrmLogin oldcrmLogin = (CrmLogin) se.getValue();
			map.remove(oldcrmLogin.getUserId());
			//�õ��µ�¼����Ϣ
			CrmLogin crmLogin = (CrmLogin) se.getSession().getAttribute("crmlogin");
			//����µ�¼���Ƿ��������ط���¼
			if(map.get(crmLogin.getUserId())!=null){
				//map���м�¼
				HttpSession session = map.get(crmLogin.getUserId());
				session.removeAttribute("crmlogin");
				//session.setAttribute("relogin", "�����û����������豸�ϵ�¼���������ߣ�");
			}
			map.put(crmLogin.getUserId(), se.getSession());
		}
		
		//�����û�
		//��¼״̬�½���
		/*if("userFlag".equals(name)){
			//�Ƴ�����Ϣ
			UserFlag olduserFlag =  (UserFlag) se.getValue();
			map1.remove(olduserFlag.getUserid());
			//�õ���״̬����Ϣ
			UserFlag userFlag = (UserFlag) se.getSession().getAttribute("userFlag");
			//����¼״̬ʱ������
			if(map1.get(userFlag.getUserid())!=null && userFlag.getUserflag()==0){
				//map���м�¼
				HttpSession session = map1.get(userFlag.getUserid());
				session.removeAttribute("userFlag");
			}
			map1.put(userFlag.getUserid(), se.getSession());
		}*/
	}

}
