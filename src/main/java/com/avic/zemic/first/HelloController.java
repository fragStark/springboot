package com.avic.zemic.first;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("苏驰")
    private String name;

    @Value("20")
    private Integer remark;
    @RequestMapping("/hello")

    public String hello(String father){
        return "Hello World!!!" + name + remark + "\n父亲是：" + father;
    }
}
