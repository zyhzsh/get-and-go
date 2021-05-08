package nl.getandgo.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebServerAutoConfig implements WebMvcConfigurer {
    /**
     * When url request are not defined.
     * Redirect to the Frontend to handle content;
     * */

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/{spring:\\w+}")
                .setViewName("forward:/");
        registry.addViewController("/**/{spring:\\w+}")
                .setViewName("forward:/");
        registry.addViewController("/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}")
                .setViewName("forward:/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","http://localhost:8080")
                .allowedMethods("GET", "POST", "OPTIONS", "PUT")
                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                        "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Access-Control-Allow-Method", "Set-Cookie")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(true).maxAge(3600);
    }

//    @Override
//    public void addResourceHandlers(
//            ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("/WEB-INF/view/react/build/static/");
//        registry.addResourceHandler("/*.js")
//                .addResourceLocations("/WEB-INF/view/react/build/");
//        registry.addResourceHandler("/*.json")
//                .addResourceLocations("/WEB-INF/view/react/build/");
//        registry.addResourceHandler("/*.ico")
//                .addResourceLocations("/WEB-INF/view/react/build/");
//        registry.addResourceHandler("/index.html")
//                .addResourceLocations("/WEB-INF/view/react/build/index.html");
//    }




//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/**")
//                        .allowedOrigins("http://localhost:8080","http://localhost:3000");
//            }
//        };
//    }

}
