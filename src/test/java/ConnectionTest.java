import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.solomon.springcrm.Creater.ConnectionCreater;
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

    @Test
    public void testConnectionConfigurationMySQL(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ComboPooledDataSource comboPooledDataSource = context.getBean("myDataSource",ComboPooledDataSource.class);

        boolean isValid = false;

        try {
            Connection connection = comboPooledDataSource.getConnection();
            isValid = connection.isValid(10);
        } catch (SQLException e) {
            System.out.println(">> Error when creating Connection!");
        }
        Assert.assertTrue(isValid);
    }






}
