package com.offcn.ptp;

import com.offcn.jms.ptp.QueueProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;


/**
 * @author wuyuhu
 * @email 870598090@qq.com
 * @data 2020/5/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext_jms_producer.xml")
public class TestQueue {
    @Autowired
    private QueueProducer queueProducer;

    @Test
    public void testSend(){
        queueProducer.sendTextMessage("SpringJms-点对点消息测试！");
    }

    @Test
    public void senSmsTest(){
        queueProducer.sendSmsTextMessage();
    }


    @Test
    public void testQueue(){
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
