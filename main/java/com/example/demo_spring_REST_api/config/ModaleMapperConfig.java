package com.example.demo_spring_REST_api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModaleMapperConfig {
	  @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
}
