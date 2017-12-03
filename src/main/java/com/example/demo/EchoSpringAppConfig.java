package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.amazonaws.serverless.proxy.spring.echoapp")
public class EchoSpringAppConfig {

}