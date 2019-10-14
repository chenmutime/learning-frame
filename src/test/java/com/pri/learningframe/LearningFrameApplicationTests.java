package com.pri.learningframe;

import com.google.common.hash.Hashing;
import com.pri.learningframe.controller.TestController;
import com.pri.learningframe.eventPublisher.DataEvent;
import com.pri.learningframe.eventPublisher.DemoService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class LearningFrameApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Ignore
    @Test
    public void contextLoads() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/test/test01").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Ignore
    @Test
    public void test() {
        Long hashcode = Hashing.sha256().hashBytes("323232wfwef32".getBytes()).asLong();
        System.out.println(">>>>>>>>>:"+(hashcode & (5-1))+"+++++++++:"+"323232wfwef32".hashCode());
    }


    @Autowired
    private DemoService demoService;

    @Test
    public void testService() {
        DataEvent dataEvent = new DataEvent("order", "订单总价2100");
        demoService.service(dataEvent);
    }

}
