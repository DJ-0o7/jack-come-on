package com.jack.rabbitmq.receiver.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FanoutReceiver1 {
    @RabbitListener(queues = {"fanoutQu1"})
    public void topicReceive(String msg){
        System.out.println("fanout 1 接收的消息：" + msg);
    }
}
