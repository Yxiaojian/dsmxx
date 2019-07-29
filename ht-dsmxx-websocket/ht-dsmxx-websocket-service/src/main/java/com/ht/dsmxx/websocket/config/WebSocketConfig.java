package com.ht.dsmxx.websocket.config;

import com.ht.dsmxx.websocket.handler.WebSocketNoticeHandler;
import com.ht.dsmxx.websocket.interceptor.WebSocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by zhou on 2018/10/24.
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketNoticeHandler(), "/webSocketNoticeHandler").addInterceptors(new WebSocketInterceptor()).setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler webSocketNoticeHandler() {
        return new WebSocketNoticeHandler();
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
