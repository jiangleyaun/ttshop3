package com.qianfeng.dubbo.service.impl;

import com.qianfeng.dubbo.service.DemoService;

public class DemoServiceImpl implements DemoService{
    @Override
    public String sayHello(String name) {
        return "Hello!"+name;
    }
}
