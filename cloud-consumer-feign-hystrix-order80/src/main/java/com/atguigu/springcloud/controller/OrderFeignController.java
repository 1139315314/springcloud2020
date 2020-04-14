package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
    一般服务降级也在在客户端这里处理的
 */
@RestController
// 业务和服务降级耦合在一起，不爽，可以给自己写一个错误回调类来分离
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod", commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2500")
//})
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.paymentInfo_OK(id);
    }

      // 1.一对一实现服务降级
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })

    // 2.
    // 类头上设置了默认的服务降级的方法，没有特别指明则使用类头上默认的方法，解决代码量膨胀的问题
    // @HystrixCommand

    // 3.通过继承serviece来实现服务降级的方法，超时时间通过配置文件配置

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentFeignTimeout(@PathVariable("id") Long id){
        return paymentFeignService.paymentInfo_TimeOut(id);
    }

    //兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Long id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)"+id;
    }
    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }

}