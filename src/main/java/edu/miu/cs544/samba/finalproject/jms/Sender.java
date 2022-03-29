package edu.miu.cs544.samba.finalproject.jms;

import edu.miu.cs544.samba.finalproject.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Value(value="${springjms.mqName}")
    private String queueName;

    public void send(Object job) {
        jmsTemplate.convertAndSend(queueName,job);
    }

}
