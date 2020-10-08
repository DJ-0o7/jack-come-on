package com.jack.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class FanoutRabbitConfig {

    //创建交换机-----------
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange", true,false);
    }

    //创建队列（3个队列）-------------
    @Bean
    public Queue fanoutQu1(){
        return new Queue("fanoutQu1");
    }
    @Bean
    public Queue fanoutQu2(){
        return new Queue("fanoutQu2.2");
    }
    @Bean
    public Queue fanoutQu3(){
        return new Queue("fanoutQu3.3.3");
    }

    //交换机与队列进行绑定---------------
    //fanout不会处理路由键，所以不用设置RoutingKey
    //fanout会将消息推送到所有绑定到自身的队列中
    @Bean
    public Binding bindingFanout1(){
        return BindingBuilder.bind(fanoutQu1()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingFanout2(){
        return BindingBuilder.bind(fanoutQu2()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingFanout3(){
        return BindingBuilder.bind(fanoutQu3()).to(fanoutExchange());
    }
}
