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
public class JobControlerTests {


    private MockMvc mvc;

    @Autowired
    private JobController jobController;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(jobController).build();
    }

    @Test
    public void queryJobs() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("page", "1");
        multiValueMap.add("rows", "10");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/job/queryJobs").contentType(MediaType.APPLICATION_FORM_URLENCODED).params(multiValueMap)).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void addJob() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("jobClassName", "cn.kenenjoy.quartz.job.ScheduledJob1");
        multiValueMap.add("jobGroupName", "group1");
        multiValueMap.add("cronExpression", "0/10 * * * * ?");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/job/addJob").contentType(MediaType.APPLICATION_FORM_URLENCODED).params(multiValueMap)).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void rescheduleJob() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("jobClassName", "cn.kenenjoy.quartz.job.ScheduledJob1");
        multiValueMap.add("jobGroupName", "group1");
        multiValueMap.add("cronExpression", "0 * * * * ?");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/job/rescheduleJob").contentType(MediaType.APPLICATION_FORM_URLENCODED).params(multiValueMap)).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }


    @Test
    public void deleteJob() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("jobClassName", "cn.kenenjoy.quartz.job.ScheduledJob1");
        multiValueMap.add("jobGroupName", "group1");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/job/deleteJob").contentType(MediaType.APPLICATION_FORM_URLENCODED).params(multiValueMap)).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }


    @Test
    public void pauseJob() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("jobClassName", "cn.kenenjoy.quartz.job.ScheduledJob1");
        multiValueMap.add("jobGroupName", "group1");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/job/pauseJob").contentType(MediaType.APPLICATION_FORM_URLENCODED).params(multiValueMap)).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }


    @Test
    public void resumeJob() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("jobClassName", "cn.kenenjoy.quartz.job.ScheduledJob1");
        multiValueMap.add("jobGroupName", "group1");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/job/resumeJob").contentType(MediaType.APPLICATION_FORM_URLENCODED).params(multiValueMap)).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

}
