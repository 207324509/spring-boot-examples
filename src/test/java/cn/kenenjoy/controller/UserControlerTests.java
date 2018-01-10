package cn.kenenjoy.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("sort", "id");
        multiValueMap.add("order", "asc");
        multiValueMap.add("page", "1");
        multiValueMap.add("rows", "10");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/get_users").contentType(MediaType.APPLICATION_FORM_URLENCODED).params(multiValueMap)).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void saveUser() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("firstname", "Two");
        multiValueMap.add("lastname", "Lv");
        multiValueMap.add("email", "lvtwo@wu.com");
        multiValueMap.add("phone", "187126176271");

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/save_user").contentType(MediaType.APPLICATION_FORM_URLENCODED).params(multiValueMap)).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

}
