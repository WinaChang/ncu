package com.ncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Configuration
public class NcuApplication {

    public static void main(String[] args) {
        SpringApplication.run(NcuApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        List<String> allowedOrigins = Arrays.asList(
                "http://localhost:3000",
                "http://127.0.0.1:3000"
        );

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // 允許跨域請求的來源，* 表示允許所有來源
        config.setAllowedOrigins(allowedOrigins);
        // 允許跨域請求的方法，例如 GET、POST、PUT、DELETE 等
        config.addAllowedMethod("*");
        // 允許跨域請求包含的頭信息
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
