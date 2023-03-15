package com.demo.addressservice.Exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

@Configuration
public class ExceptionHandlerConfig {

    @Bean
    public WebExceptionHandler webExceptionHandler() {
        return (exchange, ex) -> {
            if (ex instanceof DataNotFoundException) {
                exchange.getResponse().setStatusCode(HttpStatusCode.valueOf(404));
                return exchange.getResponse().writeWith(Mono.just(
                        exchange.getResponse().bufferFactory().wrap(ex.getMessage().getBytes())));
            }
            return Mono.error(ex);
        };
    }
}
