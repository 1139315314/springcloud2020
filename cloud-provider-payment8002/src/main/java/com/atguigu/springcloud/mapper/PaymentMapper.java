package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

//@Mapper  //使用了MapperScan就可以不需要Mapper注解
public interface PaymentMapper {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
