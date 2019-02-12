package com.websystique.springboot.config.properties;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AsyncHttpClientProperties {
    @Value("${org.app.properties.ahc.max.total.connections}")
    private Integer maxTotalConnections;
    @Value("${org.app.properties.ahc.max.total.connections.per.host}")
    private Integer maxTotalConnectionsPerHost;
    @Value("${org.app.properties.ahc.max.idle.time}")
    private Integer maxIdleTime;
    @Value("${org.app.properties.ahc.request.timeout}")
    private Integer requestTimeout;
    @Value("${org.app.properties.ahc.compression.enforced}")
    private boolean compressionEnforced;
    @Value("${org.app.properties.ahc.pooledconnectionidletimeout}")
    private Integer pooledconnectionidletimeout;
}