package com.example.demo;

import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        // SpringApplication.run(DemoApplication.class, args);

        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.setWebEnvironment(false);
        application.setBannerMode(Banner.Mode.OFF);

        ConfigurableWebApplicationContext context = new AnnotationConfigEmbeddedWebApplicationContext();
        context.setParent(application.run(args));

        SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler =
                SpringLambdaContainerHandler.getAwsProxyHandler(context);
    }
}
