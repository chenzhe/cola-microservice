package cn.startom.mall.storage.config;

import com.alibaba.cola.boot.Bootstrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for COLA framework
 */
@Configuration
public class ColaConfig {

    @Bean(initMethod = "init")
    public Bootstrap bootstrap() {
        Bootstrap bootstrap = new Bootstrap();
        List<String> packagesToScan  = new ArrayList<>();
        packagesToScan.add("cn.startom.mall.storage");
        bootstrap.setPackages(packagesToScan);
        return bootstrap;
    }
}