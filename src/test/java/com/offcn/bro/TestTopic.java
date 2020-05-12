package com.offcn.bro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.offcn.jms.bro.TopicProducer;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext_jms_producer.xml")
public class TestTopic {
    @Autowired
    private TopicProducer topicProducer;
    @Test
    public void sendTextQueue(){
        topicProducer.sendTextMessage("欢迎来优就业学习！!!!!!!");
    }

    @Test
    public void testTopic(){
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
