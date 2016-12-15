package cn.itcat.crm.web.form;

import java.io.Serializable;
/**
 * VO对象，保存jsp页面的值
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class SysUserGroupForm implements Serializable{
	private String id;
	private String name;
	private String principal;
	private String incumbent;
	private String remark;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getIncumbent() {
		return incumbent;
	}

	public void setIncumbent(String incumbent) {
		this.incumbent = incumbent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
