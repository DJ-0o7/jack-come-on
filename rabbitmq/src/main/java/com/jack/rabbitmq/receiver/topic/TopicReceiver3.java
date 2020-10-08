package com.jack.rabbitmq.receiver.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TopicReceiver3 {
    @RabbitListener(queues = {"topic.Qu3.cn"})
    public void topicReceive(String msg){
        System.out.println("Topic 3 接收的消息：" + msg);
    }
}
