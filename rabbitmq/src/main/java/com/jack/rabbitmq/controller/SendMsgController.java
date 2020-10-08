package com.jack.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate; //具备发送和接收操作

    @RequestMapping("/sendDirectMsg")
    public String sendDirectMsg(){
        //将消息推送到哪一个交换机上，交换机根据RoutingKey将数据发送到哪一个队列中
        /**
         * 参数1：传递给哪一个交换机
         * 参数2：路由键RoutingKey
         * 参数3：具体的消息
         */
        rabbitTemplate.convertAndSend("directEx","DirectRK1","my is direct : " + UUID.randomUUID());
        return "success";
    }

    @RequestMapping("/sendTopicMsg1")
    public String sendTopicMsg1(){
        rabbitTemplate.convertAndSend("topicExchange","topic","hello topic!" + UUID.randomUUID());
        return "success";
    }

    @RequestMapping("/sendTopicMsg2")
    public String sendTopicMsg2(){
        rabbitTemplate.convertAndSend("topicExchange","topic.33","hello topic!" + UUID.randomUUID());
        return "success";
    }

    @RequestMapping("/sendTopicMsg3")
    public String sendTopicMsg3(){
        rabbitTemplate.convertAndSend("topicExchange","topic.Qu3.3333","hello topic!" + UUID.randomUUID());
        return "success";
    }

    @RequestMapping("/sendFanoutMsg")
    public String sendFanoutMsg(){
        rabbitTemplate.convertAndSend("fanoutExchange", null,"my is fanout!" + UUID.randomUUID());
        return "success";
    }
}
