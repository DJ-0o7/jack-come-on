package com.jack.rabbitmq.receiver.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TopicReceiver2 {
    @RabbitListener(queues = {"topic.Qu2"})
    public void topicReceive(String msg){
        System.out.println("Topic 2 接收的消息：" + msg);
    }
}
