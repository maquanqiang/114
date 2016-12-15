package cn.itcast.crm.domain;

import java.io.Serializable;

/**
 * po对象，这里的值和要和数据库对象一直
 * @author Administrator
 *
 */
public class SysUserGroup implements Serializable{
		private Integer id;//
		private String remark;//备注
		private String name;//部门名车
		private String principal;//部门负责人
		private String  incumbent;//部门职能
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
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
		
}
