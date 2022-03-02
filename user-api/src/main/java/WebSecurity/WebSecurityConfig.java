package WebSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.cors().and().csrf().disable()
                .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(SWAGGER_WHITELIST).permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.POST, "/api").permitAll()
                .antMatchers(HttpMethod.POST, "/exams").permitAll()
                .antMatchers(HttpMethod.POST, "/bloodtype").permitAll()
                .antMatchers(HttpMethod.PUT, "/users").permitAll()
                .antMatchers(HttpMethod.PUT, "/api").permitAll()
                .antMatchers(HttpMethod.PUT, "/exams").permitAll()
                .antMatchers(HttpMethod.PUT, "/bloodtype").permitAll()
                .antMatchers(HttpMethod.GET, "/users").hasAnyRole("USERS", "MANAGERS")
                .antMatchers(HttpMethod.GET, "/api").hasAnyRole("USERS", "MANAGERS")
                .antMatchers(HttpMethod.GET, "/exams").hasAnyRole("USERS", "MANAGERS")
                .antMatchers(HttpMethod.GET, "/bloodtype").hasAnyRole("USERS", "MANAGERS")
                .antMatchers(HttpMethod.GET, "/docs").hasAnyRole("MANAGERS")


                .antMatchers("/managers").hasAnyRole("MANAGERS")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
