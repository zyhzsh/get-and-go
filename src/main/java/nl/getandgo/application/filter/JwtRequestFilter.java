package nl.getandgo.application.filter;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.Util.JwtHelper;
import nl.getandgo.application.config.JwtConfig;
import nl.getandgo.application.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final JwtHelper jwtHelper;
    private final JwtConfig jwtConfig;

    /**
     * Check Every Single Requests
     * */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String requestHeader=request.getHeader(jwtConfig.getAuthorizationHeader());
        String email=null;
        String jwt=null;
        //When The Https Header not Empty
        if (requestHeader!=null&&requestHeader.startsWith(jwtConfig.getTokenPrefix())){
            //Extra Token
            jwt=requestHeader.substring(7);
            email=jwtHelper.extractUsername(jwt);
        }
        if(email!=null&&jwt!=null){
            //Find User
            UserDetails userDetails=userService.loadUserByUsername(email);
            if(jwtHelper.validateToken(jwt,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                System.out.println(usernamePasswordAuthenticationToken);
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }


}
