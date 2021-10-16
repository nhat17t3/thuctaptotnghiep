package com.thuctap.swagger;

//http://localhost:8080/v2/api-docs
//http://localhost:8080/swagger-ui.html
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

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
                .select()
            	.apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.example.demoSpringBoot.controller"))
//                .paths(PathSelectors.ant("/rest/*"))
                .paths(PathSelectors.any())
                .build();


 	
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Student API thuc tap tot nghiep")
        		.description("Hoang Long Nhat 102170176 Student API  for intern")
        		.licenseUrl("hoanglongnhat@gmail.com").version("1.0").build();
    }
	
}
