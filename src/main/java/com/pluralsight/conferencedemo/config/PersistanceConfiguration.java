/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.conferencedemo.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 *
 * @author elias
 */

@Configuration
public class PersistanceConfiguration {
    
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:mysql://localhost/conference_demo?serverTimezone=UTC");
        builder.username("root");
        builder.password("root");
        System.out.println("BEAN DATASOURCE initiliazed");
        return builder.build();
    }
}
