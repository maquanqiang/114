package cn.itcast.crm.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import antlr.StringUtils;

/**
 * 该类的主要作用是加载beanx.xml文件
 * @author Administrator
 *
 */
public class ServiceProvinder {
	private static ServiceProvinderCore sc;
	static{
		sc= new ServiceProvinderCore();
		sc.load("beans.xml");
	}
	//得到服务
	public  static Object getService(String beanName){
		//如果是空的话那么就是true
		if(org.apache.commons.lang.StringUtils.isBlank(beanName)){
			throw new RuntimeException("您要访问的服务名不能为空");
		}
		Object bean=null;
		//如果spring容器中包含beanName
		if(sc.context.containsBean(beanName)){
			bean=sc.context.getBean(beanName);
			
		}
		//如果spring容器中不包含beanName
		if(bean==null){
			throw new RuntimeException("您要访问的服务名称["+beanName+"]不存在");
			
		}
		return bean;
	}
}
