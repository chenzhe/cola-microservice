package cn.startom.mall.order.test;

import cn.startom.mall.order.api.OrderServiceI;
import com.alibaba.cola.dto.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is for integration test.
 *
 * Created by fulan.zjf on 2017/11/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private OrderServiceI orderService;

    @Before
    public void setUp() {

    }

//    @Test
//    public void testCustomerAddSuccess(){
//        //1.prepare
//        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
//        Customer customer = new Customer();
//        customer.setCompanyName("NormalName");
//        customerAddCmd.setCustomer(customer);
//
//        //2.execute
//        Response response = orderService.addCustomer(customerAddCmd);
//
//        //3.assert
//        Assert.assertTrue(response.isSuccess());
//    }
//
//    @Test
//    public void testCustomerAddCompanyNameConflict(){
//        //1.prepare
//        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
//        Customer customer = new Customer();
//        customer.setCompanyName("ConflictCompanyName");
//        customerAddCmd.setCustomer(customer);
//
//        //2.execute
//        Response response = customerService.addCustomer(customerAddCmd);
//
//        //3.assert
//        Assert.assertEquals(ErrorCode.B_CUSTOMER_companyNameConflict.getErrCode(), response.getErrCode());
//
//    }
}