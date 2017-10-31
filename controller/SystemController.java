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
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.controller.SystemController  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-5 下午2:08:40    
 * 修改备注：  
 * @version  jdk1.6                                            
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
@Controller
@RequestMapping("/SystemController")
public class SystemController {
	
	 @Autowired
	private SystemControllerService systemControllerService;
	 
	//登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request,HttpServletResponse response,
    		@Validated(value={ValidGroup3.class}) CrmUserCustom crmUserCustom,BindingResult bindingResult,Model model) throws Exception {
    	//对登录的用户信息进行校验
    	if(bindingResult.hasErrors())
        {
            model.addAttribute("userErrors", bindingResult.getAllErrors());
            return "home/login";
        }
    	
    	//-------------正常登录
    	
    	CrmUserCustom crmUserCustom0 = systemControllerService.login(crmUserCustom);
    	
    	//-------------不考虑权限登录
    	
//    	CrmUserCustom crmUserCustom0 = systemControllerService.loginAll(crmUserCustom);
    	
        if(crmUserCustom0!=null){
        	if(crmUserCustom0.getUserflag()!=null &&crmUserCustom0.getUserflag()==0){
        		model.addAttribute("loginerror", "此用户已被禁用！");
                return "home/login";
        	}
        	if(crmUserCustom0.getRoleflag()!=null&&crmUserCustom0.getRoleflag()==0){
        		model.addAttribute("loginerror", "此角色已被禁用！");
                return "home/login";
        	}
        	String yzm0 = (String) request.getSession().getAttribute("yzm");
        	String yzm = yzm0.toUpperCase();//不区分大小写 
        	if(!yzm.equals(crmUserCustom.getYzm().toUpperCase())){
        		model.addAttribute("loginerror", "验证码错误！");
                return "home/login";
        	}
        	//单状态登录
            loginNote(request,crmUserCustom0.getUserid());
            
        	request.getSession().setAttribute("parentCode", crmUserCustom0.getParentCode());
            request.getSession().setAttribute("username", crmUserCustom0.getUsername());
            request.getSession().setAttribute("userid", crmUserCustom0.getUserid());
            request.getSession().setAttribute("password", crmUserCustom0.getPassword());
            request.getSession().setAttribute("userflag", crmUserCustom0.getUserflag()); //用于监听用户状态
            request.getSession().setAttribute("roleflag", crmUserCustom0.getRoleflag());//用于监听禁用角色
           
            /*UserFlag userFlag = new UserFlag();
            userFlag.setUserid(crmUserCustom0.getUserid());
            userFlag.setUserflag(crmUserCustom0.getUserflag());
            request.getSession().setAttribute("userFlag", userFlag);*/
            
            return "redirect:home.action";
        }
        model.addAttribute("loginerror", "用户名或密码错误！");
        return "home/login";
    }
    
    //登录2
    @RequestMapping("/login0")
    public String login0() throws Exception{
    	return "home/login";
    }
    
    //用于记录登录的IP地址和时间（单状态登录）
    public void loginNote(HttpServletRequest request,Integer userid){
    	CrmLogin crmLogin = new CrmLogin();
    	crmLogin.setUserId(userid);
    	CrmLogin crmLogin0 = new CrmLogin();
    	crmLogin0 = systemControllerService.findLogin(crmLogin);//根据id先查询上次登录信息
    	/*if(crmLogin0==null){
    		crmLogin0.setUserId(userid);//防止由于第一次登录，查询结果为空，重新填入id//**********************第一次登录空指针异常（未解决）
    	}*/
    	crmLogin.setLoginIp(request.getRemoteAddr());
    	crmLogin.setLoginDate(new Date());
    	systemControllerService.addLogin(crmLogin);//记录本次登录信息
    	request.getSession().setAttribute("loginip", crmLogin.getLoginIp());
    	request.getSession().setAttribute("crmlogin", crmLogin0);//把上次登录信息放入session中
    }
    
    //主页
    @RequestMapping("/home")
    public String home(){
    	return "home/home";
    }
    
    //退出界面
    @RequestMapping("/exitJsp")
    public void exitJsp(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	request.setAttribute("message", "exit");
    	request.getRequestDispatcher("/home/main.jsp").forward(request, response);
    }
    
    //退出
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request,HttpServletResponse response)throws Exception{
        request.getSession().invalidate();
        return "redirect:login0.action";
    }
    
    //系统管理---权限管理(模糊查询)
    @RequestMapping("/jurisdictionList")
    public String jurisdictionList(HttpServletRequest request,CrmUserRoleCustomVo crmUserRoleCustomVo){
        List<CrmUserCustom> crmUserRoleCustomList = systemControllerService.userRoleList(crmUserRoleCustomVo);
        List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleAllList();
        request.setAttribute("crmUserRoleCustomList", crmUserRoleCustomList);
        request.setAttribute("crmRoleCustomList", crmRoleCustomList);
        return "systemadmin/jurisdiction_admin";
    }
    
    //删除用户
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer userid){
    	systemControllerService.deleteUser(userid);
    	return "redirect:jurisdictionList.action";
    }
    
    //禁用用户
    @RequestMapping("/disableUser")
    public String disableUser(Integer userid, Integer userflag,HttpServletRequest request){
    	CrmUserCustom crmUserCustom = new CrmUserCustom();
    	crmUserCustom.setUserid(userid);
    	crmUserCustom.setUserflag(userflag);
    	systemControllerService.disableUser(crmUserCustom);
    	//用于监听禁用用户
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
    
    //添加用户界面
    @RequestMapping("/addUserJsp")
    public String addUserJsp(HttpServletRequest request){
    	List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleList();
    	request.setAttribute("crmRoleCustomList", crmRoleCustomList);
    	return "systemadmin/useradd";
    }
    
    //添加用户
    @RequestMapping("/addUser")
    public String addUser(@Validated(value={ValidGroup1.class}) CrmUserCustom crmUserCustom,
            BindingResult bindingResult,Model model,HttpServletRequest request){
        //对添加的用户信息进行校验
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
    
    //编辑用户界面
    @RequestMapping("/editUserJsp")
    public String editUserJsp(HttpServletRequest request,Integer userid){
    	List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleList();
    	request.setAttribute("crmRoleCustomList", crmRoleCustomList);
    	CrmUserCustom crmUserCustom = systemControllerService.findUserById(userid);
    	request.setAttribute("crmUserCustom", crmUserCustom);
    	request.getSession().setAttribute("userid", userid);
    	return "systemadmin/useredit";
    }
    
    //编辑用户界面(标签)
    @RequestMapping("/editUserJsp0")
    public String editUserJsp0(HttpServletRequest request){
        Integer userid=(Integer) request.getSession().getAttribute("userid");
        List<CrmRoleCustom> crmRoleCustomList  = systemControllerService.roleList();
        request.setAttribute("crmRoleCustomList", crmRoleCustomList);
        CrmUserCustom crmUserCustom = systemControllerService.findUserById(userid);
        request.setAttribute("crmUserCustom", crmUserCustom);
        return "systemadmin/useredit";
    }
    
    //更新用户信息
    @RequestMapping("/updateUser")
    public String updateUser(@Validated(value={ValidGroup1.class}) CrmUserCustom crmUserCustom,
            BindingResult bindingResult,Model model,HttpServletRequest request){
        //对修改的用户信息进行校验
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
    
    //权限角色查询
    @RequestMapping("/rightList")
    public String rightList(HttpServletRequest request){
        List<CrmRightCustom> crmRightRoleCustomList = systemControllerService.rightRoleList();
        request.setAttribute("crmRightRoleCustomList", crmRightRoleCustomList);
        return "systemadmin/rightlist";
    }
    
  //禁用角色
    @RequestMapping("/disableRole")
    public String disableRole(Integer roleid, Integer roleflag,HttpServletRequest request){
        CrmRightCustom crmRightCustom = new CrmRightCustom();
        crmRightCustom.setRoleid(roleid);
        crmRightCustom.setRoleflag(roleflag);
        systemControllerService.disableRole(crmRightCustom);
        //用于监听禁用角色
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
    
    //密码修改界面
    @RequestMapping("/pwdeditJsp")
    public String pwdeditJsp(){
        return "systemadmin/pwdedit";
    }
    
    //修改密码
    @RequestMapping("/updatepwd")
    public String updatepwd(@Validated(value={ValidGroup2.class}) CrmUserCustom crmUserCustom,
            BindingResult bindingResult,Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
      //对修改的用户信息进行校验
        if(bindingResult.hasErrors())
        {
            model.addAttribute("userErrors", bindingResult.getAllErrors());
            return "systemadmin/pwdedit";
        }
        String pwd = (String) request.getSession().getAttribute("password");
        if(!(crmUserCustom.getOldpassword().equals(pwd))){
            model.addAttribute("oldpwderror", "旧密码错误！");
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



