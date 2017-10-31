package com.guigu.crm.model;

public class UserFlag {
	
	private Integer userid;
	
	private Integer userflag;
	
	//判断是否是同一个用户
	
   /* public boolean equalsUser(Object obj) {
		if(obj==null || (obj instanceof UserFlag)){
			return false;
		}
		UserFlag other =  (UserFlag) obj;
		return userid.equals(other.getUserid());
	}*/

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getUserflag() {
		return userflag;
	}

	public void setUserflag(Integer userflag) {
		this.userflag = userflag;
	}
	
	



}
