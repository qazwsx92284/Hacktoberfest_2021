package com.my.swaggerExample.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
        .paths(PathSelectors.any()).build();
    }
//return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//        .apis(RequestHandlerSelectors.basePackage("com.my.swaggerExample")).build();

//    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//               .apis(RequestHandlerSelectors.basePackage("com.my.swaggerExample")).build();



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Profile API")
               .description("This API can be used to get profile for an Employee")
               .version("1.0.0")
               .contact(new Contact("MY Lee", "https://www.myprincess.com","qwerasdf@gmail.com"))
            .license("Apache License")
               .licenseUrl("https://www.apache.com")
               .termsOfServiceUrl("https://www.termsofservice.com")
               .build();
    }


//            return new ApiInfoBuilder().title("Employee Profile Api")
//                .description("This Api can be used to get profile level actions and information for an Employee")
//                .version("V1.0").build();
}
