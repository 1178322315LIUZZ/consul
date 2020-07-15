package com.bw.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalenConfig {
    @Bean
    public IRule myrul(){
        //指定随机负载均衡
        //return new RandomRule();
        //轮训机制
        return new RoundRobinRule();
    }
}
