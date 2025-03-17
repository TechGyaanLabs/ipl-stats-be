package com.careerit.iplstats.service;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "app.custom")
public class TenantDetails {

    @Getter @Setter
    private List<Tenant> tenants;

    public static class Tenant {
        @Getter @Setter
        private String tenantId;
        @Getter @Setter
        private String tenantName;
        @Getter @Setter
        private String ip;

    }
}
