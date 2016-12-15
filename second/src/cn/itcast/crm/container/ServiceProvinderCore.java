package cn.itcast.crm.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 该类的主要作用是加载beanx.xml文件
 * @author Administrator
 *
 */
public class ServiceProvinderCore {
	protected ApplicationContext context;
	public void load(String fileanme){
		/**
		 * @param filename beans.xml
		 */
		 context = new ClassPathXmlApplicationContext(fileanme);
		
	}
}
