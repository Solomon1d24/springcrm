import com.solomon.springcrm.Creater.SessionFactoryCreater;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

public class SessionFactoryTest {

  @Test
  public void connectionSessionFactoryTest() {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    SessionFactoryCreater sessionFactoryCreater = context.getBean("sessionFactoryCreater",SessionFactoryCreater.class);

    boolean isValid = false;

    SessionFactory sessionFactory = sessionFactoryCreater.getSessionFactory();

    Session session = sessionFactory.getCurrentSession();

    session.beginTransaction();

    if(session.isConnected() && session.isOpen()){
      isValid = true;
    }

    assertTrue(isValid);


  }
}
