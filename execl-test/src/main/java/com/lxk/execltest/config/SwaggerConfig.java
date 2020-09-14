package com.lxk.execltest;
/**
 * @Description TODO
 * @Author liuxk@e6yun.com
 * @Created Date: 2020/9/5 13:49
 * @ClassName Tets
 * @Remark
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 创建一个Docket实例
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                // controller接口路径
                .apis(RequestHandlerSelectors.basePackage("com.lxk.execltest"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboordemo")
                .description("Springboot整合SpringMVC")
                .version("0.0.1")
                .build(); // 这部分信息其实可以自定义到配置文件中读取
    }

}