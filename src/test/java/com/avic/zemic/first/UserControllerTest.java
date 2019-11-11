package com.avic.zemic.first;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(
                this. webApplicationContext).build();
    }
    @Test
    public void getUser() throws Exception {
        String getUserUri = "/user/getUser";
        MvcResult mvcResult = this.mockMvc
                .perform(get(getUserUri))
                .andReturn();
        System.out.println("User是：" + mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void saveUser() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(post("/user/saveUser")
                .param("name","的")
                .param("age","666")
                .param("password","test")).andReturn();
        System.out.println("User是：" + mvcResult.getResponse().getContentAsString());
    }
}
