package com.solomon.springcrm.Creater;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sessionFactoryCreater")
@Scope("singleton")
public class SessionFactoryCreater {

  private SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    if (this.sessionFactory == null) {
      this.sessionFactory =
          new Configuration()
              .configure("hibernate.cfg.xml")
              .addPackage("com.solomon.testdb")
              .buildSessionFactory();
    }
    return this.sessionFactory;
  }

}
