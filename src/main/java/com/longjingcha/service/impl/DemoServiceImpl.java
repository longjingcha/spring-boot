package com.longjingcha.service.impl;

import com.longjingcha.service.DemoService;

/**
 * Created by User on 2018/2/6.
 */
public class DemoServiceImpl implements DemoService{
    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }

}
