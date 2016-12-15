package cn.itcast.crm.dao;

import java.util.LinkedHashMap;
import java.util.List;

import cn.itcast.crm.domain.SysUserGroup;

public interface ISysUserGroupDao extends ICommonDao<SysUserGroup> {
	//不可修改的
	public final static String service_name="cn.itcast.crm.dao.impl.SysUserGroupDaoImpl";




}
