package cn.kenenjoy.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;

/**
 * Created by hefa on 2017/7/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControlerTests {


    private MockMvc mvc;

    @Autowired
    private UserController userController;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getUsers() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/get_users")).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

}
