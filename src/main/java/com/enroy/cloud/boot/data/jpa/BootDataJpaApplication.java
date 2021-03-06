package com.enroy.cloud.boot.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class BootDataJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(BootDataJpaApplication.class, args);
  }

  @Bean
  public Docket swaggerDocket() {
    return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName())).build();
  }
}
