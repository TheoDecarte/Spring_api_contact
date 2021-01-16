package com.universitenanterre.projetfsr.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@ImportResource(locations = {"classpath:applicationContext.xml"})
@ComponentScan(basePackages = {"com.universitenanterre.projetfsr"})
@Configuration
public class AppConfiguration {

}
