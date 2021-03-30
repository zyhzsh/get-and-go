package nl.getandgo.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static nl.getandgo.application.security.UserRole.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
              //  .antMatchers(HttpMethod.GET,"api/products").hasAuthority(UserPermission.PRODUCT_READ.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       UserDetails amanageruser= User.builder()
                .username("manager")
                .password(passwordEncoder.encode("manager"))
                .authorities(Manager.getGrantedAuthorities())
                .build();
       UserDetails acustomeruser= User.builder()
               .username("customer")
               .password(passwordEncoder.encode(("customer")))
  //             .roles(Customer.name())
                .authorities(Customer.getGrantedAuthorities())
               .build();


        return new InMemoryUserDetailsManager(
                amanageruser,
                acustomeruser
        );
    }
}
