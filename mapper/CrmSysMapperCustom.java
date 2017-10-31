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
	
	//��¼
	public CrmUserCustom login(CrmUserCustom crmUserCustom);
	
	//������Ȩ�޵�¼
	public CrmUserCustom loginAll(CrmUserCustom crmUserCustom);
	
	//��ѯ�û��ͽ�ɫ
	public List<CrmUserCustom> userRoleList(CrmUserRoleCustomVo crmUserRoleCustomVo);
	
	//��ѯ��ɫ
	public List<CrmRoleCustom> roleList();
	
	//�����û�
	public void disableUser(CrmUserCustom crmUserCustom);
	
	//����û�
	public void addUser(CrmUserCustom crmUserCustom);
	
	//�޸��û�
	public void updateUser(CrmUserCustom crmUserCustom);
	
	//��ѯȨ�޺ͽ�ɫ
	public List<CrmRightCustom> rightRoleList();
	
	//���ý�ɫ
	public void disableRole(CrmRightCustom crmRightCustom);
	
	//��ѯ�ϴε�¼��Ϣ
	public CrmLogin findLogin(CrmLogin crmLogin);
	
	//����id��ѯ�û��ͽ�ɫ״̬
	public CrmUserCustom findflag(CrmUserCustom crmUserCustom);
	
	//���ݽ�ɫ״̬����ѯ��״̬�����û�
	public List<CrmUserCustom> findAllUserByRoleFlag(CrmUserCustom crmUserCustom);

}
