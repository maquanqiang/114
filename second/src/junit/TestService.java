package junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.dao.ISysUserGroupDao;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.service.ISysUserGroupService;

public class TestService {
	public void testSave() {
		ISysUserGroupService sysUserGroupService= (ISysUserGroupService) ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setName("销售部");
		sysUserGroup.setPrincipal("xxx");
		sysUserGroup.setIncumbent("ttt");
		sysUserGroupService.saveSysUserGroup(sysUserGroup);
	}
	public void findObjectByConditionWithNoPage(){
		ISysUserGroupService service  = (ISysUserGroupService) ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
		String name = "销售部";
		// 获取部门负责人
		String principal = "xxx";
		SysUserGroup s= new SysUserGroup();
		s.setName("销售部");
		List<SysUserGroup> list = service.findSysUserGroups(s);
		System.out.println(list.size());
		
	}
	public static void main(String[] args) {
		TestService t= new TestService();
		t.findObjectByConditionWithNoPage();
		
	}
	
	
}
