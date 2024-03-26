/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Isaura Manico
 * Data  : 09 - 07 - 2023
 * 
 */
@Configuration
//@EnableWebMvc
@EnableSwagger2
//@Component
public class SwaggerConfig{
    
  
    @Bean
    public Docket CentralDeInformacaoDeRiscoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("edu.ucan"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());  
        
        
    }
    
    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                
                
                "Sistema de Partilha de Informação de Risco Entre agentes Económicos",
                "API para o Sistema de Partilha de Informação de Risco Entre agentes Económicos",
                "1.0",
                "Termos de Serviço",
                new Contact("Yuri Domingos", "+244 946 413 617", "josemarlabareda@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
        );
        
        return apiInfo;
        
    }
}

