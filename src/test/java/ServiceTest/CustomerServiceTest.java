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
import java.util.regex.Pattern;

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

  @Test
  public void deleteCustomerWithIdTest() {

    // define the index
    final int index = 1;

    // when the desire action is performed
    this.customerService.deleteCustomerWithId(index);

    // verify whether the delete action of the dao is performed
    Mockito.verify(this.customerDAO).deleteCustomerWithId(1);
  }

  @Test
  public void deleteCustomerTest() {
    // create the customer

    Customer customer = new Customer("Solomon", "Chow", "solomon1d24@gmail.com");

    // when the desired action is performed
    this.customerService.deleteCustomer(customer);

    // verify whether the action of the dao is performed
    Mockito.verify(this.customerDAO).deleteCustomer(customer);
  }

  @Test
  public void deleteCustomerWithName() {

    final String firstName = "Solomon";
    final String lastName = "Chow";

    this.customerService.deleteCustomerWithName(firstName, lastName);

    Mockito.verify(this.customerDAO).deleteCustomerWithName(firstName, lastName);
  }

  @Test
  public void saveCustomerTest() {

    // create the customer

    Customer customer = new Customer("Solomon", "Chow", "solomon1d24@gmail.com");

    // when the desired action is performed
    this.customerService.saveCustomer(customer);

    // verify whether the action of the dao is performed
    Mockito.verify(this.customerDAO).saveCustomer(customer);
  }

  @Test
  public void saveCustomersTest() {

    // create the customer lists
    List<Customer> customerList1 =
        Arrays.asList(
            new Customer("Solomon", "Chow", "solo5698@connect.hku.hk"),
            new Customer("Tom", "Cat", "kathon@hku.hk"));

    // when the desired action is performed
    this.customerService.saveCustomer(customerList1);

    // verify whether the action of the dao is performed

    Mockito.verify(this.customerDAO).saveCustomer(customerList1);
  }

  @Test
  public void updateCustomerTest() {

    // create the customer
    Customer customer = new Customer("Solomon", "Chow", "solomon1d24@gmail.com");

    // when the destired action is performed

    this.customerService.updateCustomer(customer);

    // verify whether the dao has performed the action

    Mockito.verify(this.customerDAO).updateCustomer(customer);
  }
}
