package com.jack.rabbitmq.receiver.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TopicReceiver1 {
    @RabbitListener(queues = {"topic"})
    public void topicReceive(String msg){
        System.out.println("Topic 1 接收的消息：" + msg);
    }
}
