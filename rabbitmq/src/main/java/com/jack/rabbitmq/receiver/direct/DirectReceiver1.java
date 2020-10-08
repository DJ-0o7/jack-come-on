package com.jack.rabbitmq.receiver.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
public class DirectReceiver1 {

    /**
     * 开启异步监听，不断监听队列
     * 当有消息时就会直接获取
     * @param msg
     */
    @RabbitListener(queues = {"DirectQu1"})
    public void directReceive(String msg){
        System.out.println("Direct 1 接收的消息：" + msg + UUID.randomUUID());
    }
}
