package com.pri.learningframe;

import com.pri.learningframe.eventPublisher.DataEvent;
import com.pri.learningframe.eventPublisher.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void testService() {
        DataEvent dataEvent = new DataEvent("order", "订单总价2100");
        demoService.service(dataEvent);
    }
}
