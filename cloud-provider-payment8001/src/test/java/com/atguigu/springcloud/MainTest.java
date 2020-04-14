package com.atguigu.springcloud;

import com.atguigu.springcloud.mapper.PaymentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    @Autowired
    PaymentMapper paymentMapper;

    @Test
    public void test(){
        System.out.println(paymentMapper.getPaymentById(1L));
    }


}
