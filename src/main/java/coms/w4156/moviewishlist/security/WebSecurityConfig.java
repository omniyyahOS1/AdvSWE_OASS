package coms.w4156.moviewishlist.security;

import coms.w4156.moviewishlist.security.jwt.JwtRequestFilter;
import coms.w4156.moviewishlist.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private JwtRequestFilter jwtFilter;

    // @Autowired
    // private ClientService clientService;

    // protected final void configure(final AuthenticationManagerBuilder auth)
    //     throws Exception {
    //     auth
    //         .userDetailsService(clientService)
    //         .passwordEncoder(passwordEncoder());
    // }

    /**
     * Configure the security of the application.
     */
    // @Bean
    // public AuthenticationManager authenticationManagerBean() throws Exception {
    //     return super.authenticationManagerBean();
    // }

    /**
     * Configure the password encoder of the application.
     * @return - The password encoder
     */
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    /**
     * Configure the security of the application.
     * @param http - The http security to configure
     * @throws Exception - If there is an error configuring the security
     * @return - The security filter chain
     */
    @Bean
    public SecurityFilterChain configure(final HttpSecurity http)
        throws Exception {
        http.addFilterBefore(
            jwtFilter,
            UsernamePasswordAuthenticationFilter.class
        );

        return http
            .csrf(x -> x.disable())
            .authorizeRequests(auth -> {
                auth.anyRequest().permitAll();
            })
            .sessionManagement(x ->
                x.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .build();
    }
}
