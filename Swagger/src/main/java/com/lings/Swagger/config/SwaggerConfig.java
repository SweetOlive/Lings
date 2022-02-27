package com.lings.Swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    // 如何配置多个分组:使用多个Docket Bean实例
    @Bean
    public Docket docket1( ){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2( ){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3( ){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }



    // 配置了Swagger的Bean实例
    @Bean
    public Docket docket(Environment environment){

        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");
        // 通过environment获取项目的环境是否处在自己设定的环境
        boolean isTrue = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("LingsAPI文档") // 修改文档默认分组名称
                // enable默认true为开启，false关闭
                .enable(isTrue)
                .select()
                // RequestHandlerSelectors 配置要扫描接口的方式
                // basePackage指定要扫描的包
                // any():扫描全部
                // none():不扫描
                // withClassAnnotation:扫描类上的注解 参数是一个注解的反射对象 RestController.class
                // withMethodAnnotation:扫描方法上的注解 GetMapping.class
                .apis(RequestHandlerSelectors.basePackage("com.lings.Swagger.controller"))
                // 过滤路径
                // .paths(PathSelectors.ant("/lings/Swagger.controller/**"))
                .build();
    }

    // 配置Swagger的信息ApiInfo
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("Lings","https://sweetolive.github.io/","10@qq.com");
        return new ApiInfo(
                "Lings的SwaggerAPI文档",
                "test-swagger",
                "V1.0",
                "https://sweetolive.github.io/",
                contact,
                "Apache 2.0",
                "https://sweetolive.github.io/",
                new ArrayList<>());
    }

}
