package com.bw;

import com.bw.config.BalenConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "provider",configuration = {BalenConfig.class})
public class Starts {
    public static void main(String[] args) {
        SpringApplication.run(Starts.class);
    }
}
