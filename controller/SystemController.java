package com.guigu.crm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.crm.controller.validation.ValidGroup1;
import com.guigu.crm.controller.validation.ValidGroup2;
import com.guigu.crm.controller.validation.ValidGroup3;
import com.guigu.crm.model.CrmLogin;
import com.guigu.crm.model.CrmRightCustom;
import com.guigu.crm.model.CrmRoleCustom;
import com.guigu.crm.model.CrmUserCustom;
import com.guigu.crm.model.CrmUserRoleCustomVo;
import com.guigu.crm.model.UserFlag;
import com.guigu.crm.service.SystemControllerService;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.controller.SystemController  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-5 ����2:08:40    
 * �޸ı�ע��  
 * @version  jdk1.6                                            
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
@Controller
@RequestMapping("/SystemController")
public class SystemController {
	
	 @Autowired
	private SystemControllerService systemControllerService;
	 
	//��¼
    @RequestMapping("/login")
    public String login(HttpServletRequest request,HttpServletResponse response,
    		@Validated(value={ValidGroup3.class}) CrmUserCustom crmUserCustom,BindingResult bindingResult,Model model) throws Exception {
    	//�Ե�¼���û���Ϣ����У��
    	if(bindingResult.hasErrors())
        {
            model.addAttribute("userErrors", bindingResult.getAllErrors());
            return "home/login";
        }
    	
    	//-------------������¼
    	
    	CrmUserCustom crmUserCustom0 = systemControllerService.login(crmUserCustom);
    	
    	//-------------������Ȩ�޵�¼
    	
//    	CrmUserCustom crmUserCustom0 = systemControllerService.loginAll(crmUserCustom);
    	
        if(crmUserCustom0!=null){
        	if(crmUserCustom0.getUserflag()!=null &&crmUserCustom0.getUserflag()==0){
        		model.addAttribute("loginerror", "���û��ѱ����ã�");
                return "home/login";
        	}
        	if(crmUserCustom0.getRoleflag()!=null&&crmUserCustom0.getRoleflag()==0){
        		model.addAttribute("loginerror", "�˽�ɫ�ѱ����ã�");
                return "home/login";
        	}
        	String yzm0 = (String) request.getSession().getAttribute("yzm");
        	String yzm = yzm0.toUpperCase();//�����ִ�Сд 
        	if(!yzm.equals(crmUserCustom.getYzm().toUpperCase())){
        		model.addAttribute("loginerror", "��֤�����");
                return "home/login";
        	}
        	//��״̬��¼
            loginNote(request,crmUserCustom0.getUserid());
            
        	request.getSession().setAttribute("parentCode", crmUserCustom0.getParentCode());
            request.getSession().setAttribute("username", crmUserCustom0.getUsername());
            request.getSession().setAttribute("userid", crmUserCustom0.getUserid());
            request.getSession().setAttribute("password", crmUserCustom0.getPassword());
            request.getSession().setAttribute("userflag", crmUserCustom0.getUserflag()); //���ڼ����û�״̬
            request.getSession().setAttribute("roleflag", crmUserCustom0.getRoleflag());//���ڼ������ý�ɫ
           
            /*UserFlag userFlag = new UserFlag();
            userFlag.setUserid(crmUserCustom0.getUserid());
            userFlag.setUserflag(crmUserCustom0.getUserflag());
            request.getSession().setAttribute("userFlag", userFlag);*/
            
            return "redirect:home.action";
        }
        model.addAttribute("loginerror", "�û������������");
        return "home/login";
    }
    
    //��¼2
    @RequestMapping("/login0")
    public String login0() throws Exception{
    	return "home/login";
    }
    
    //���ڼ�¼��¼��IP��ַ��ʱ�䣨��״̬��¼��
    public void loginNote(HttpServletRequest request,Integer userid){
    	CrmLogin crmLogin = new CrmLogin();
    	crmLogin.setUserId(userid);
    	CrmLogin crmLogin0 = new CrmLogin();
    	crmLogin0 = systemControllerService.findLogin(crmLogin);//����id�Ȳ�ѯ�ϴε�¼��Ϣ
    	/*if(crmLogin0==null){
    		crmLogin0.setUserId(userid);//��ֹ���ڵ�һ�ε�¼����ѯ���Ϊ�գ���������id//**********************��һ�ε�¼��ָ���쳣��δ�����
    	}*/
    	crmLogin.setLoginIp(request.getRemoteAddr());
    	crmLogin.setLoginDate(new Date());
    	systemControllerService.addLogin(crmLogin);//��¼���ε�¼��Ϣ
    	request.getSession().setAttribute("loginip", crmLogin.getLoginIp());
    	request.getSession().setAttribute("crmlogin", crmLogin0);//���ϴε�¼��Ϣ����session��
    }
    
    //��ҳ
    @RequestMapping("/home")
    public String home(){
    	return "home/home";
    }
    
    //�˳�����
    @RequestMapping("/exitJsp")
    public void exitJsp(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	request.setAttribute("message", "exit");
    	request.getRequestDispatcher("/home/main.jsp").forward(request, response);
    }
    
    //�˳�
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request,HttpServletResponse response)throws Exception{
        request.getSession().invalidate();
        return "redirect:login0.action";
    }
    
    //ϵͳ����---Ȩ�޹���(ģ����ѯ)
    @RequestMapping("/jurisdictionList")
    public String jurisdictionList(HttpServletRequest request,CrmUserRoleCustomVo crmUserRoleCustomVo){
        List<CrmUserCustom> crmUserRoleCustomList = systemControllerService.userRoleList(crmUserRoleCustomVo);
        List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleAllList();
        request.setAttribute("crmUserRoleCustomList", crmUserRoleCustomList);
        request.setAttribute("crmRoleCustomList", crmRoleCustomList);
        return "systemadmin/jurisdiction_admin";
    }
    
    //ɾ���û�
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer userid){
    	systemControllerService.deleteUser(userid);
    	return "redirect:jurisdictionList.action";
    }
    
    //�����û�
    @RequestMapping("/disableUser")
    public String disableUser(Integer userid, Integer userflag,HttpServletRequest request){
    	CrmUserCustom crmUserCustom = new CrmUserCustom();
    	crmUserCustom.setUserid(userid);
    	crmUserCustom.setUserflag(userflag);
    	systemControllerService.disableUser(crmUserCustom);
    	//���ڼ��������û�
    	if(userflag==0){userflag=1;}else{userflag=0;}
    	if(userflag==0){
    		/*CrmLogin crmLogin = new CrmLogin();
    		crmLogin.setUserId(userid);
    		request.getSession().setAttribute("disuserid", userid);
    		request.getSession().setAttribute("crmlogin", crmLogin);*/
    		/*UserFlag userFlag = new UserFlag();
            userFlag.setUserid(userid);
            userFlag.setUserflag(userflag);*/
    		request.getSession().setAttribute("disuid", userid);
            request.getSession().setAttribute("userflag", userflag);
    	}
    	
        return "redirect:jurisdictionList.action";
    }
    
    //����û�����
    @RequestMapping("/addUserJsp")
    public String addUserJsp(HttpServletRequest request){
    	List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleList();
    	request.setAttribute("crmRoleCustomList", crmRoleCustomList);
    	return "systemadmin/useradd";
    }
    
    //����û�
    @RequestMapping("/addUser")
    public String addUser(@Validated(value={ValidGroup1.class}) CrmUserCustom crmUserCustom,
            BindingResult bindingResult,Model model,HttpServletRequest request){
        //����ӵ��û���Ϣ����У��
        if(bindingResult.hasErrors())
        {
            model.addAttribute("userErrors", bindingResult.getAllErrors());
            List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleList();
            request.setAttribute("crmRoleCustomList", crmRoleCustomList);
            return "systemadmin/useradd";
        }
    	systemControllerService.addUser(crmUserCustom);
    	return "redirect:jurisdictionList.action";
    }
    
    //�༭�û�����
    @RequestMapping("/editUserJsp")
    public String editUserJsp(HttpServletRequest request,Integer userid){
    	List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleList();
    	request.setAttribute("crmRoleCustomList", crmRoleCustomList);
    	CrmUserCustom crmUserCustom = systemControllerService.findUserById(userid);
    	request.setAttribute("crmUserCustom", crmUserCustom);
    	request.getSession().setAttribute("userid", userid);
    	return "systemadmin/useredit";
    }
    
    //�༭�û�����(��ǩ)
    @RequestMapping("/editUserJsp0")
    public String editUserJsp0(HttpServletRequest request){
        Integer userid=(Integer) request.getSession().getAttribute("userid");
        List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleList();
        request.setAttribute("crmRoleCustomList", crmRoleCustomList);
        CrmUserCustom crmUserCustom = systemControllerService.findUserById(userid);
        request.setAttribute("crmUserCustom", crmUserCustom);
        return "systemadmin/useredit";
    }
    
    //�����û���Ϣ
    @RequestMapping("/updateUser")
    public String updateUser(@Validated(value={ValidGroup1.class}) CrmUserCustom crmUserCustom,
            BindingResult bindingResult,Model model,HttpServletRequest request){
        //���޸ĵ��û���Ϣ����У��
        if(bindingResult.hasErrors())
        {
            model.addAttribute("userErrors", bindingResult.getAllErrors());
            List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleList();
            request.setAttribute("crmRoleCustomList", crmRoleCustomList);
            return "systemadmin/useredit";
        }
        
    	systemControllerService.updateUser(crmUserCustom);
    	return "redirect:jurisdictionList.action";
    }
    
    //Ȩ�޽�ɫ��ѯ
    @RequestMapping("/rightList")
    public String rightList(HttpServletRequest request){
        List<CrmRightCustom> crmRightRoleCustomList = systemControllerService.rightRoleList();
        request.setAttribute("crmRightRoleCustomList", crmRightRoleCustomList);
        return "systemadmin/rightlist";
    }
    
  //���ý�ɫ
    @RequestMapping("/disableRole")
    public String disableRole(Integer roleid, Integer roleflag,HttpServletRequest request){
        CrmRightCustom crmRightCustom = new CrmRightCustom();
        crmRightCustom.setRoleid(roleid);
        crmRightCustom.setRoleflag(roleflag);
        systemControllerService.disableRole(crmRightCustom);
        //���ڼ������ý�ɫ
        if(roleflag==0){roleflag=1;}else{roleflag=0;}
        if(roleflag==0){
        	CrmUserCustom crmUserCustom = new CrmUserCustom();
            crmUserCustom.setRoleflag(roleflag);
            List<CrmUserCustom> useridList = systemControllerService.findAllUserByRoleFlag(crmUserCustom);
            request.getSession().setAttribute("useridList", useridList);
        }
        request.getSession().setAttribute("roleflag", roleflag);
        return "redirect:rightList.action";
    }
    
    //�����޸Ľ���
    @RequestMapping("/pwdeditJsp")
    public String pwdeditJsp(){
        return "systemadmin/pwdedit";
    }
    
    //�޸�����
    @RequestMapping("/updatepwd")
    public String updatepwd(@Validated(value={ValidGroup2.class}) CrmUserCustom crmUserCustom,
            BindingResult bindingResult,Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
      //���޸ĵ��û���Ϣ����У��
        if(bindingResult.hasErrors())
        {
            model.addAttribute("userErrors", bindingResult.getAllErrors());
            return "systemadmin/pwdedit";
        }
        String pwd = (String) request.getSession().getAttribute("password");
        if(!(crmUserCustom.getOldpassword().equals(pwd))){
            model.addAttribute("oldpwderror", "���������");
            return "systemadmin/pwdedit";
        }
        crmUserCustom.setPassword(crmUserCustom.getNewpassword());
        request.getSession().invalidate();
        request.getSession().setAttribute("userid", crmUserCustom.getUserid());
        request.getSession().setAttribute("username", crmUserCustom.getUsername());
        request.getSession().setAttribute("password", crmUserCustom.getPassword());
        systemControllerService.updateUser(crmUserCustom);
        request.setAttribute("message", "updatepwd");
    	request.getRequestDispatcher("/home/main.jsp").forward(request, response);
    	return null;
    }
    
}



