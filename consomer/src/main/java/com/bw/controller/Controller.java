package com.bw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("list")
    public List<String> list(){
        List<String> services = discoveryClient.getServices();
        return services;
    }
    @RequestMapping("see")
    public List<ServiceInstance> see(){
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        return provider;
    }
    @RequestMapping("call")
    public String call(){
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        if(provider!=null && provider.size()>0){
            RestTemplate restTemplate = new RestTemplate();
            ServiceInstance instance = provider.get(0);
            String forObject = restTemplate.getForObject(instance.getUri().toString() + "/test", String.class);
            System.out.println(forObject);
            return forObject;
        }else {
            return "no server";
        }
    }
    @RequestMapping("bcall")
    public String ba(){
        ServiceInstance instance = loadBalancerClient.choose("provider");
        String url = instance.getUri().toString() + "/test";
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
        return forObject;
    }
}
