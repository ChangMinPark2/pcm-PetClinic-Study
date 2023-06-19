package kr.co.pcmpetclinicstudy.infra.config;

import kr.co.pcmpetclinicstudy.service.model.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {

        //인가 정책
        http
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/members/fail").permitAll()
                .requestMatchers("/api/v1/members/hello").hasRole(Role.ADMIN_ROLE.getRole())
                .requestMatchers("/api/v1/members/**").authenticated();

        //인증 정책 :
        http
                .formLogin().permitAll() //로그인 페이지 접근을 모두 허용
                .defaultSuccessUrl("/api/v1/member") //로그인 성공시 기본 페이지
                .failureUrl("/api/v1/member/fail"); //실페시 들어갈 페이지


        return http.build();
    }

    private LogoutSuccessHandler logoutSuccessHandler() {

        return (request, response, authentication) -> {
            response.sendRedirect("/login");
        };
    }
}
