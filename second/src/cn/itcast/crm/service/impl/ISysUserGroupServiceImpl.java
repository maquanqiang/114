package cn.itcast.crm.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.ISysUserGroupDao;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.service.ISysUserGroupService;

//读取事务
@Transactional(readOnly=true)
@Service(ISysUserGroupService.SERVICE_NAME)
public class ISysUserGroupServiceImpl implements ISysUserGroupService {

	@Resource(name = ISysUserGroupDao.service_name)
	private ISysUserGroupDao iSysUserGroupDao;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveSysUserGroup(SysUserGroup sysUserGroup) {
		iSysUserGroupDao.save(sysUserGroup);
	}

	
	@SuppressWarnings("unchecked")
	public List<SysUserGroup> findSysUserGroups(String name,String precipal) {
		
		//封装的是查询条件
        String hql="select * from SysUserGroup o where 1=1";
        //封装的是查询条件需要的数据
        List paramList = new ArrayList();
        if(StringUtils.isNotBlank(name)){
        	hql+=" and o.name like ?";
        	paramList.add("%"+name+"%");
        	
        }
        if(StringUtils.isNotBlank(precipal)){
        	hql+=" o.principal = ?";
        	paramList.add(precipal);
        	
        }
        
        @SuppressWarnings("unused")
		Object[] params=paramList.toArray();
        LinkedHashMap<String, String> orderby= new LinkedHashMap<String, String>();
        orderby.put("o.id","asc");
       
        List<SysUserGroup> list= iSysUserGroupDao.findObjectsByConditionWithNoPage(hql,params,orderby);
		//组织排序
      
       return list;
	}


	@Override
	public List<SysUserGroup> findSysUserGroups(SysUserGroup sysUserGroupSearch) {
		if(sysUserGroupSearch==null){
			throw new RuntimeException("传递给业务层部门查询条件的对象为空");
		}
		
		//组织查询条件
		String whereHql="";
		
		//定义封装查询条件的List
		List paramList=new ArrayList();
		
		if(StringUtils.isNotBlank(sysUserGroupSearch.getName())){
			whereHql=" and o.name like ?";
			paramList.add("%"+sysUserGroupSearch.getName().trim()+"%");
		}
		
		Object[] params=paramList.toArray();
		
		//排序
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("o.id", "asc");
		
		return iSysUserGroupDao.findObjectsByConditionWithNoPage(whereHql, params, orderby);
	}


	@Override
	public SysUserGroup findSysUserGroupById(Integer id) {
		return null;
	}


	@Override
	public void updateSysUserGroup(SysUserGroup sysUserGroup) {
		
	}


	@Override
	public void deleteSysUserGroupsByIds(Integer... ids) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<SysUserGroup> findAllSysUserGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
