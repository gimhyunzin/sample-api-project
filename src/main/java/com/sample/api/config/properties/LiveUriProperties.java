package com.sample.api.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "resources.uri.live")
public class LiveUriProperties {
    private String mypagePurchase;
}
