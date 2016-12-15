package junit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast.crm.domain.SysUserGroup;

public class TestHibernate {
	@Test
	public void TestHibernate(){
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		SysUserGroup sys= new SysUserGroup();
		sys.setName("销售部");
		sys.setPrincipal("xx");
		sys.setIncumbent("tt");
		s.save(sys);
		t.commit();
		s.close();
		
	}
}
