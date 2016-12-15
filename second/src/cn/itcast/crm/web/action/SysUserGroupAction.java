package cn.itcast.crm.web.action;


import java.lang.reflect.InvocationTargetException;

import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.service.ISysUserGroupService;
import cn.itcat.crm.web.form.SysUserGroupForm;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
//利用模型来实现
public class SysUserGroupAction extends ActionSupport implements ModelDriven<SysUserGroupForm>
{
	//引用模型驱动
	private SysUserGroupForm sysUserGroupForm = new SysUserGroupForm();
	public String save() throws IllegalAccessException,InvocationTargetException{
		
		System.out.println("ffff"+sysUserGroupForm.getName());
		//实现化po对象
		SysUserGroup sysUserGroup = new SysUserGroup();
		
		//赋值vo对象的值到po中
		org.springframework.beans.BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm);
		
		//获取业务层对象(本项目struts2和spring是分离的)
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
		//调用业务层保存
		sysUserGroupService.saveSysUserGroup(sysUserGroup);
		return null;
	}
	@Override
	public SysUserGroupForm getModel() {
		return sysUserGroupForm;
	}
}
