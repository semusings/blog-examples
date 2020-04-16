package io.github.bhuwanupadhyay.cmis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
@Data
public class AppCfg {

    private Cmis cmis;

    @Data
    public static class Cmis {
        private String apiUrl;
        private String username;
        private String password;
    }
}
