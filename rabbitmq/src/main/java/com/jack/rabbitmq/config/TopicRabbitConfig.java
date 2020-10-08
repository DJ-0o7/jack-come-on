package com.jack.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    //创建一个交换机
    @Bean
    public TopicExchange topicExchange(){
        /**
         * 参数1：交换机名
         * 参数2：是否持久化
         * 参数3：是否自动删除
         */
        return new TopicExchange("topicExchange",true,false);
    }

    //创建队列
    @Bean
    public Queue TopicQu(){
        return new Queue("topic");
    }

    @Bean
    public Queue TopicQu2(){
        return new Queue("topic.Qu2");
    }

    @Bean
    public Queue TopicQu3(){
        return new Queue("topic.Qu3.cn");
    }

    /**
     * 将TopicQu队列和topicExchange交换机进行绑定
     * 绑定参数为topic
     * 只有携带topic路由键才会分发到该队列
     */
    @Bean
    public Binding bindingTopic(){
        return BindingBuilder.bind(TopicQu()).to(topicExchange()).with("topic");
    }

    /**
     * 消息写带topic.开头，以一个单词为结尾都会推送到队列中
     * @return
     */
    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(TopicQu2()).to(topicExchange()).with("topic.*");
    }
    /**
     * 消息写带topic开头，以0个或多个个单词为结尾都会推送到队列中
     * @return
     */
    @Bean
    public Binding bindingTopic3(){
        return BindingBuilder.bind(TopicQu3()).to(topicExchange()).with("topic.#");
    }
}
