import com.solomon.springcrm.Creater.SessionFactoryCreater;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

public class SessionFactoryTest {

  @Test
  public void connectionSessionFactoryTest() {

    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext.xml");

    SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);

    Session session;

    boolean isValid;

    try {
      try {
        session = sessionFactory.getCurrentSession();
      } catch (HibernateException e) {
        session = sessionFactory.openSession();
      }
      session.beginTransaction();

      isValid = (session.isOpen() && session.isConnected());

      session.close();

    } finally {
      sessionFactory.close();
    }

    assertTrue(isValid);
  }

  @Test
  public void connectionSessionFactoryTest2() {

    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext.xml");

    SessionFactoryCreater sessionFactoryCreater =
        context.getBean("sessionFactoryCreater", SessionFactoryCreater.class);

    boolean isValid = false;

    SessionFactory sessionFactory = sessionFactoryCreater.getSessionFactory();

    Session session = sessionFactory.getCurrentSession();

    session.beginTransaction();

    if (session.isConnected() && session.isOpen()) {
      isValid = true;
    }

    assertTrue(isValid);
  }
}
