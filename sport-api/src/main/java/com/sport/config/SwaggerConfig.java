package com.sport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*
     * swagger2的配置文件，这里可以配置swagger2的一些基本内容，比如扫描的包等等
     */
    @Bean
    public Docket productApi() {
        String tokenstr = "3AC97A924D7A2E3298B275F19EC02AF2";
        ParameterBuilder tokenParameterBuilder = new ParameterBuilder();

        tokenParameterBuilder.name("token").defaultValue(tokenstr).description("用户token")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();

        List<Parameter> addParameters = new ArrayList<Parameter>();
        addParameters.add(tokenParameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(addParameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sport.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SpringBoot 集成Swagger2构建Restfu API")
                .contact(new Contact("陕西科技大学运动会管理系统","http://localhost:8080/","1844861420@qq.com"))
                .version("1.0")
                .description("Api描述")
                .build();
    }


    private String initContextInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("REST API 设计在细节上有很多自己独特的需要注意的技巧，并且对开发人员在构架设计能力上比传统 API 有着更高的要求。")
                .append("<br/>")
                .append("本文通过翔实的叙述和一系列的范例，从整体结构，到局部细节，分析和解读了为了提高易用性和高效性，REST API 设计应该注意哪些问题以及如何解决这些问题。");

        return sb.toString();
    }

}
