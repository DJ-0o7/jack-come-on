package com.jack.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 直连型交换机配置
 */
@Configuration
public class DirectRabbitConfig {

    //创建一个Direct交换机
    @Bean
    public DirectExchange directEx(){
        /**
         * 参数1：交换机名
         * 参数2：是否持久化
         * 参数3：是否自动删除
         */
        return new DirectExchange("directEx", true, false);
    }

    //创建一个队列
    @Bean
    public Queue DirectQu1(){
        /**
         * 参数1：队列名
         * 参数2：是否持久化
         */
        return new Queue("DirectQu1", true);
    }

    //绑定队列与交换机
    @Bean
    public Binding bindingDirect(){
        /**
         * 参数1：需要绑定某一个队列
         * 参数2：需要将队列绑定到哪一个交换机上
         * 参数3：执行路由键RoutingKey
         */
        return BindingBuilder.bind(DirectQu1()).to(directEx()).with("DirectRK1");
    }
}
