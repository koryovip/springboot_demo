package com.example.demo._config.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ninja.cero.sqltemplate.core.FreeMarkerSqlTemplate;
import ninja.cero.sqltemplate.core.PlainTextSqlTemplate;
import ninja.cero.sqltemplate.core.SqlTemplate;

@Configuration
public class SqlTemplateConfiguration {

    @Bean
    public SqlTemplate sqlTemplate(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new SqlTemplate(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Bean
    @SqlTemplate_FreeMarker
    public FreeMarkerSqlTemplate sqlTemplate1(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new FreeMarkerSqlTemplate(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Bean
    @SqlTemplate_PlainText
    public PlainTextSqlTemplate sqlTemplate2(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new PlainTextSqlTemplate(jdbcTemplate, namedParameterJdbcTemplate);
    }

}