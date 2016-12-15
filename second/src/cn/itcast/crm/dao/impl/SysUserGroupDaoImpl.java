package cn.itcast.crm.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ICommonDao;
import cn.itcast.crm.dao.ISysUserGroupDao;
import cn.itcast.crm.domain.SysUserGroup;

@Repository(ISysUserGroupDao.service_name)
public class SysUserGroupDaoImpl<T> extends CommonDaoImpl<SysUserGroup> implements ISysUserGroupDao{
	
	
	
}
