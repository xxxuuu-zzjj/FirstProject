package com.xzj.springbootandvue.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Auther Xu
 * @Date 2021/11/15
 */
@Configuration
public class SwaggerIIIConfig {
    @Value("${xzj.swagger.enabled}")
    private Boolean enableSwagger;

    @Value("${xzj.application.name}")
    private String applicationName;


    @Value("${xzj.application.version}")
    private String applicationVersion;


    @Value("${xzj.application.description}")
    private String applicationDescription;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).pathMapping("/")
                .enable(enableSwagger)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title(applicationName+" Api 文档")
                .description(applicationDescription)
                .contact(new Contact("Admin", null, ""))
                .version("Application Version: " + applicationVersion + ", Spring Boot Version: " + SpringBootVersion.getVersion())
                .build();
    }
}
