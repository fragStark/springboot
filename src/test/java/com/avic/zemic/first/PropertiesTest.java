package com.avic.zemic.first;

import com.avic.zemic.first.model.DatabaseProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Value("${neo.title}")
    private String title;
    @Value("${neo.description}")
    private String description;

    @Resource
    private DatabaseProperties databaseProperties;

    @Test
    public void testSingleGetValue() {
        Assert.assertEquals(description,"123");
    }
    @Test
    public void testReadProperties() {
        System.out.println("地址是： " + databaseProperties.getConnectURL());
        System.out.println("用户名是： " + databaseProperties.getUserName());
        System.out.println("密码是： " + databaseProperties.getPassword());
    }

}
