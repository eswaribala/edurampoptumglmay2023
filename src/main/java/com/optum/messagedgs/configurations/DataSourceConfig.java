package com.optum.messagedgs.configurations;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
public Faker getFaker(){
    return new Faker();
}
}
