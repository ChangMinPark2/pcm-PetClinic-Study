package kr.co.pcmpetclinicstudy.infra.config;

import kr.co.pcmpetclinicstudy.service.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {

        //인가 정책 : 해당 사용자가 본인이 맞는지 확인하는 절차
        http
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/members/fail").permitAll()
                .requestMatchers("/api/v1/members/hello").hasRole(Role.ADMIN_ROLE.getRole()); //경로에 대해 ADMIN_ROLE만 허용한다.
//                .requestMatchers("/api/v1/members/**").authenticated();
        //api/vq/members/** -> 해당 경로에 대해 인증된 사용자만 허용한다
        //1 -> fail은 누구나 허용한다.
        //2 -> ADMIN_ROLE만 가능하다
        //3 -> members/로 시작하는 모든 경로는 인증된 사용자만 가능하다

        /**
         * .authorizeHttpRequests()
         * .anyRequest().authenticated(); (로그인 성공)
         * */


        //인증 정책 : 인증된 사용자가 요청한 자원에 접근 가능한지를 결정하는 절차
        http
                .formLogin().permitAll() //로그인 페이지 접근을 모두 허용
                .defaultSuccessUrl("/api/v1/member") //로그인 성공시 기본 페이지
                .failureUrl("/api/v1/member/fail"); //실페시 들어갈 페이지

        //1 -> Form 로그인 인증 기능 작동, permitALL -> 특정 엔드포인트에 대한 접근 권한을 모든 사용자에게 허용한다.


        return http.build();
    }

//    private LogoutSuccessHandler logoutSuccessHandler() {
//
//        return (request, response, authentication) -> {
//            response.sendRedirect("/login");
//        };
//    }
}
