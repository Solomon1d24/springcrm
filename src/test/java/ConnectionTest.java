import com.solomon.testdb.Model.ConnectionCreater;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionTest {


    @Test
    public void testConnectionSuccessToMySQLDB(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ConnectionCreater connectionCreater = context.getBean("connectionCreater", ConnectionCreater.class);

        boolean isValid = false;

        try {
            Connection myConn = connectionCreater.ConnectionCreation();
            isValid = myConn.isValid(10);
        } catch (SQLException e) {
            System.out.println(">> Error when creating Connection!");
        }

        Assert.assertTrue(isValid);

    }






}
