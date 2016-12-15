package junit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.dao.ISysUserGroupDao;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.service.ISysUserGroupService;

public class TestSysUserGroupDao {

	//测试保存的方法
	public void testSave(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ISysUserGroupDao sysUserGroupDao = (ISysUserGroupDao) ctx.getBean(ISysUserGroupDao.service_name);
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setName("销售部");
		sysUserGroup.setPrincipal("xxx");
		sysUserGroup.setIncumbent("ttt");
		sysUserGroupDao.save(sysUserGroup);
	}
	//测试保存的方法
	public void testupdate(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ISysUserGroupDao sysUserGroupDao = (ISysUserGroupDao) ctx.getBean(ISysUserGroupDao.service_name);
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setId(31);
		sysUserGroup.setName("技术部");
		sysUserGroup.setPrincipal("xxx");
		sysUserGroup.setIncumbent("ttt");
		sysUserGroupDao.update(sysUserGroup);
	}
	//通过Id查找
	public void find(){
		ISysUserGroupDao sys = (ISysUserGroupDao) ServiceProvinder.getService(ISysUserGroupDao.service_name);
		Serializable id=20;
		SysUserGroup s= sys.findObjectById(id);
		System.out.println(s.getName());
		
	}
	//删除
	public void deleteById(){
		ISysUserGroupDao dao = (ISysUserGroupDao) ServiceProvinder.getService(ISysUserGroupDao.service_name);
		
		//利用数组来删除当前的多个信息
		Serializable[] ids={30,31,32};
		System.out.println(ids);
		 dao.deleteById(ids);
		
	}
	/**
	 * 删除集合
	 * @param args
	 */
	public void deleteCollections(){
		ISysUserGroupDao sysUserGroupDao =(ISysUserGroupDao)ServiceProvinder.getService(ISysUserGroupDao.service_name);
		SysUserGroup s1 = new SysUserGroup();
		System.out.println(s1);
		s1.setId(5);
		s1.setName("销售部01");
		SysUserGroup s2 = new SysUserGroup();
		s2.setId(6);
		s2.setName("销售部01");
		java.util.List<SysUserGroup> list = new ArrayList<SysUserGroup>();
		list.add(s1);
		list.add(s2);
		
	    sysUserGroupDao.deleteAllObjects(list);
	}
	public void findObjectByConditonWithNoPage(){
		ISysUserGroupService sysUserGroupService=(ISysUserGroupService) ServiceProvinder.getService(ISysUserGroupDao.service_name);
		//获取部门名称
		String name="销售部";
		//获取部门负责人
		String principal="xxx";
		/***
		 * select语句;
		 * select * from sys_user_group o where o.name like '%销售%' and o.principal='tom'
		 * hql语句：
		 * select * from SysUserGroup o where o.name like '%销售%' and o.principal='tom' order by o.id;
		 */ 
		SysUserGroup s = new SysUserGroup();
		s.setName("销售部");
		List<SysUserGroup> list=sysUserGroupService.findSysUserGroups(s);
		System.out.println(list.size());
	}
	public static void main(String[] args) {
		TestSysUserGroupDao t = new TestSysUserGroupDao();
		t.deleteCollections();
	}
}
