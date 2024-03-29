package ru.logisticplatform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.logisticplatform.security.jwt.JwtConfigurer;
import ru.logisticplatform.security.jwt.JwtTokenProvider;

/**
 * Security configuration class for JWT based Spring Security application.
 *
 * @author Sergei Perminov
 * @version 1.0
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/api/v1/admins/**";
    private static final String LOGIN_ENDPOINT = "/api/v1/sign/**";
    private static final String CUSTOMER_ENDPOINT = "/api/v1/customers/**";
    private static final String CONTRACTOR_ENDPOINT = "/api/v1/contractors/**";
    private static final String TRANSPORT_TYPE_ENDPOINT = "/api/v1/transporttypes/**";
   // private static final String TRANSPORTATION_ENDPOINT = "/api/v1/transportations/**";
   // private static final String TRANSPORTATION_LOCATIONS_ME_ENDPOINT = "/api/v1/transportations/locations/me/**";


    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
                .antMatchers(CUSTOMER_ENDPOINT).hasRole("CUSTOMER")
                .antMatchers(CONTRACTOR_ENDPOINT).hasRole("CONTRACTOR")
                .antMatchers(TRANSPORT_TYPE_ENDPOINT).hasAnyRole("CONTRACTOR", "CUSTOMER")
 //               .antMatchers(TRANSPORTATION_ENDPOINT).hasRole("CONTRACTOR")
//                .antMatchers(TRANSPORTATION_LOCATIONS_ME_ENDPOINT).hasRole("CONTRACTOR")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}







//@Configuration
//@EnableWebSecurity
//public class SecurityConfig
//        extends WebSecurityConfigurerAdapter implements ApplicationContextAware {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                // ...
//                .csrf().disable();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder =
//                PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth
//                .inMemoryAuthentication()
//                .withUser("user")
//                .password(encoder.encode("password"))
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password(encoder.encode("admin"))
//                .roles("USER", "ADMIN");
//    }
//
//
//}
