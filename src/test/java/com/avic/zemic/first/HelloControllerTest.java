package com.avic.zemic.first;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class HelloControllerTest extends ControllerBaseTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(
               this. webApplicationContext).build();
    }

    @Test
    public void getHello() throws Exception {
        String uri = "/hello?father=我";

        MvcResult mvcResult = this.mockMvc
                .perform(get(uri))
                .andReturn();

        System.out.println("User是：" + mvcResult.getResponse().getContentAsString());

    }
}
