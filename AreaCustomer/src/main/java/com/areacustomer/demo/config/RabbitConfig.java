package com.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author liuxk@e6yun.com
 * @Created Date: 2020/8/25 15:08
 * @ClassName RabbitConfig
 * @Remark
 */
@Configuration
public class RabbitConfig {
//交换机名称

    @Value("${spring.rabbitmq.queueName}")
    public String FANOUT_QUEUE_NAME;

    //队列名称
    @Value("${spring.rabbitmq.exchangeName}")
    public String TEST_FANOUT_EXCHANGE;


    //创建队列
    @Bean
    public Queue createFanoutQueue() {
        return new Queue(FANOUT_QUEUE_NAME);
    }

    //创建交换机
    @Bean
    public FanoutExchange defFanoutExchange() {
        return new FanoutExchange(TEST_FANOUT_EXCHANGE);
    }


    //队列与交换机进行绑定
    @Bean
    Binding bindingFanout() {
        return BindingBuilder.bind(createFanoutQueue()).
                to(defFanoutExchange());

    }
}