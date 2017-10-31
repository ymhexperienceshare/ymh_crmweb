package com.guigu.crm.mapper;

import java.util.List;

import com.guigu.crm.model.CrmLogin;
import com.guigu.crm.model.CrmRightCustom;
import com.guigu.crm.model.CrmRoleCustom;
import com.guigu.crm.model.CrmUser;
import com.guigu.crm.model.CrmUserCustom;
import com.guigu.crm.model.CrmUserCustomVo;
import com.guigu.crm.model.CrmUserRoleCustomVo;

public interface CrmSysMapperCustom {
	
	//登录
	public CrmUserCustom login(CrmUserCustom crmUserCustom);
	
	//不考虑权限登录
	public CrmUserCustom loginAll(CrmUserCustom crmUserCustom);
	
	//查询用户和角色
	public List<CrmUserCustom> userRoleList(CrmUserRoleCustomVo crmUserRoleCustomVo);
	
	//查询角色
	public List<CrmRoleCustom> roleList();
	
	//禁用用户
	public void disableUser(CrmUserCustom crmUserCustom);
	
	//添加用户
	public void addUser(CrmUserCustom crmUserCustom);
	
	//修改用户
	public void updateUser(CrmUserCustom crmUserCustom);
	
	//查询权限和角色
	public List<CrmRightCustom> rightRoleList();
	
	//禁用角色
	public void disableRole(CrmRightCustom crmRightCustom);
	
	//查询上次登录信息
	public CrmLogin findLogin(CrmLogin crmLogin);
	
	//根据id查询用户和角色状态
	public CrmUserCustom findflag(CrmUserCustom crmUserCustom);
	
	//根据角色状态，查询该状态所有用户
	public List<CrmUserCustom> findAllUserByRoleFlag(CrmUserCustom crmUserCustom);

}
