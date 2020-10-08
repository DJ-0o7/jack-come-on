package com.jack.rabbitmq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory，才能触发回调函数
        rabbitTemplate.setMandatory(true);

        //将消息推送到交换机触发该回调函数，无论是否推送成功都会触发
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("CorrelationData data:" + correlationData);
                System.out.println("CorrelationData condition:" + ack);
                System.out.println("CorrelationData cause:" + cause);
            }
        });

        //消息推送到队列，当推送不成功时触发，成功不触发
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback message:" + message);
                System.out.println("ReturnCallback replyCode:" + replyCode);
                System.out.println("ReturnCallback replyText:" + replyText);
                System.out.println("ReturnCallback exchange:" + exchange);
                System.out.println("ReturnCallback routingKey:" + routingKey);
            }
        });
        return rabbitTemplate;
    }
}
