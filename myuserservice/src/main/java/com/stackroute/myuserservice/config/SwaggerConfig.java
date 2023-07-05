//Completed---just for api documentation

package com.stackroute.myuserservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/*
	 * @Bean public Docket postsApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).groupName("public-api")
	 * .apiInfo(apiInfo()).select().paths(postPaths()).build(); }
	 */

	/*
	 * private Predicate<String> postPaths() { return or(regex("/api/posts.*"),
	 * regex("/api/v1.*")); }
	 * 
	 * 
	 */
	
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.stackroute.myuserservice")).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
		
	}
	
	
	private ApiInfo apiInfo() {
		
		ApiInfoBuilder apiInfoBuilder=new ApiInfoBuilder();
		
		return apiInfoBuilder.title("Covid-19 API")
		.description("Swagger for Covid-19 Capstone")
		.termsOfServiceUrl("https://stackbooks.stackroute.in/terms-of-use.html")
		.contact("charansanthu4@gmail.com").license("charansanthu4@gmail.com")
		.licenseUrl("charansanthu4@gmail.com").version("v1.0.1").build();
		
		
	}


}
