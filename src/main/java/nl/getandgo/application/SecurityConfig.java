package nl.getandgo.application;

import lombok.AllArgsConstructor;
import nl.getandgo.application.filter.JwtRequestFilter;
import nl.getandgo.application.model.UserType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private UserDetailsService myUserDetailService;
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//       http.authorizeRequests()
//
//               .antMatchers("").hasAnyRole();
        //http.csrf()//.disable()
                //.sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.and()
                //.authorizeRequests()
                //.antMatchers("/api/login").permitAll();
                //.anyRequest()
                //.authenticated();
       // http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

//    http.authorizeRequests()
//            .antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/signin");
    http
            .csrf()
            .disable()
            .authorizeRequests().anyRequest().permitAll();
//            .antMatchers("/api/customer/signup").permitAll()
//            .antMatchers("/api/test/manager").hasAnyAuthority(UserType.MANAGERUSER.toString())
//            .antMatchers("/api/test/customer").hasAuthority(UserType.CUSTOMERUSER.toString())
//            .antMatchers("/api/test/vendor").hasAuthority(UserType.VENDORUSER.toString())
//            .antMatchers(
//                    HttpMethod.GET,
//                    "/index*", "/static/**", "/*.js", "/*.json", "/*.ico")
//            .permitAll()
//            .anyRequest().authenticated()
//            .and().formLogin().loginPage("/index.html")
//            .loginProcessingUrl("/signin")
//            .defaultSuccessUrl("/index.html",true)
//            .failureForwardUrl("/index.html/signin");

            //.antMatchers("/api/products").hasAuthority(UserType.CUSTOMERUSER.toString())
//            .antMatchers("/api/login").permitAll()
//            .and().formLogin().loginPage();
//            .permitAll()
//            .antMatchers("/api/test/**").fullyAuthenticated()
//            .and().formLogin().loginPage("/signin");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
       return NoOpPasswordEncoder.getInstance();
    }
}
