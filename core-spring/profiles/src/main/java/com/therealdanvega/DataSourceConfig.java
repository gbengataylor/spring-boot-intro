package com.therealdanvega;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    @Value("${environments.development.url}")
    private String devUrl;
    @Value("${environments.production.url}")
    private String prodUrl;

    @Bean(name = "datasource")
    @Profile("development")
    DataSource development(){
        return new DataSource(devUrl/*"my-development-url"*/,9999);
    }

    @Bean(name = "datasource")
    @Profile("production")
    DataSource production(){
        return new DataSource(prodUrl /*"my-production-url"*/,9999);
    }

}
