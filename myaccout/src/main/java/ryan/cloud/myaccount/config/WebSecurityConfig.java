package ryan.cloud.myaccount.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//import ryan.cloud.myaccount.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf().disable() // 禁用CSRF保护
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/register", "/register2", "/hh", "/login").permitAll() // 允许未认证用户访问这些路径
                        .anyRequest().authenticated() // 其他路径需要认证
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true) // 成功登录后重定向到/home

                        .permitAll() // 允许所有人访问登录页面
                )
                .logout((logout) -> logout.permitAll()); // 允许所有人访问登出URL

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
//        return new CustomUserDetailsService();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("pp")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}