package com.avic.zemic.first;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void saveEmployee() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "suchi");
        params.add("age", "25");
        params.add("birthday", new Date().toString());
        params.add("gender", "男");

        String result = mockMvc.perform(MockMvcRequestBuilders.get("/employee/findListEmployee"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("result: " + result);
    }

    @Test
    public void getEmployee() throws Exception {
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/employee/getEmployee"))
                .andReturn();
        String emplo = result.getResponse().getContentAsString();
        System.out.println("Employee是：" + result.getResponse().getContentAsString());
    }

}
