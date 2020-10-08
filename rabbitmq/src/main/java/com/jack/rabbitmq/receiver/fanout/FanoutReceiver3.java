package com.jack.rabbitmq.receiver.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FanoutReceiver3 {
    @RabbitListener(queues = {"fanoutQu3.3.3"})
    public void topicReceive(String msg){
        System.out.println("fanout 3 接收的消息：" + msg);
    }
}
