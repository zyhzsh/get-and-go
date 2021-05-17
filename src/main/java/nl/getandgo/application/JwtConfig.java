package nl.getandgo.application;

import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
@ConfigurationProperties(prefix = "application.jwt")
@NoArgsConstructor
@AllArgsConstructor
public class JwtConfig {
    @Setter
    private String securityKey;
    @Bean
    public SecretKey getSecurityKeyForSigning(){
       return Keys.hmacShaKeyFor(securityKey.getBytes());
    }

    public String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }

    @Getter
    @Setter
    private String tokenPrefix;
    @Getter @Setter
    private Integer tokenExpirationAfterDays;
}
