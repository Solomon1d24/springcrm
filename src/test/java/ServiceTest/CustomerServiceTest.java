package ServiceTest;

import com.solomon.springcrm.Dao.CustomerDAO;
import com.solomon.springcrm.Model.Customer;
import com.solomon.springcrm.ServiceImpl.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class CustomerServiceTest {

  @InjectMocks private CustomerServiceImpl customerService;

  @Mock private CustomerDAO customerDAO;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getCustomersTest() {

    List<Customer> customerList1 =
        Arrays.asList(
            new Customer("Solomon", "Chow", "solo5698@connect.hku.hk"),
            new Customer("Tom", "Cat", "kathon@hku.hk"));

    Mockito.when(this.customerService.getCustomers()).thenReturn(customerList1);

    Assertions.assertEquals(2, customerList1.size());
  }

  @Test
  public void getCustomerTest() {

    Customer customer = new Customer("Solomon", "Chow", "solomon1d24@gmail.com");

    Mockito.when(this.customerDAO.getCustomer(1)).thenReturn(customer);

    Customer customer1 = this.customerService.getCustomer(1);

    Assertions.assertEquals(customer, customer1);
  }

  @Test
  public void getCustomerTestFirstNameLastName() {

    Customer customer = new Customer("Solomon", "Chow", "solomon1d24@gmail.com");

    List<Customer> customerList =
        Arrays.asList(new Customer("Solomon", "Chow", "solomon1d24@gmail.com"));

    Mockito.when(this.customerDAO.getCustomer("Solomon", "Chow")).thenReturn(customerList);

    List<Customer> customerList1 = this.customerService.getCustomer("Solomon", "Chow");

    Customer customer1 = customerList1.get(0);

    Assertions.assertEquals(customer, customer1);
  }
}
