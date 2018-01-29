package com.qianfeng.dubbo.main;

import com.qianfeng.dubbo.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dubbo-consumer.xml");
        context.start();
        DemoService bean = (DemoService)context.getBean("demoService");
        String str = bean.sayHello("jiang");
        System.out.println(str);
    }
}
