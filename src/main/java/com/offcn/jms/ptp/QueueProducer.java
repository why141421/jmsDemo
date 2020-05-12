package com.offcn.jms.ptp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @author wuyuhu
 * @email 870598090@qq.com
 * @data 2020/5/5
 */
@Component
public class QueueProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination queueTextDestination;

    @Autowired
    private Destination smsDestination;
    /**
     * 发送文本消息
     * @param text
     */
    public void sendTextMessage(final String text){
        jmsTemplate.send(queueTextDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
    }

    public void sendSmsTextMessage(){
        jmsTemplate.send(smsDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();

                mapMessage.setString("mobile","13195516030");
                mapMessage.setString("sign_name","优乐选网上商城");
                mapMessage.setString("template_code","SMS_189622664");
                mapMessage.setString("param","{\"code\":\"12345\"}");
                return mapMessage;
            }
        });
    }
}
