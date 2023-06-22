package kr.co.pcmpetclinicstudy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    @GetMapping
    public String main(){

        return "로그인 성공시 기본 페이지 입니다.";
    }

    @GetMapping("/fail")
    public String fail(){

        return "로그인 실패시 페이지 입니다.";
    }

    @GetMapping("/hello")
    public String hello(){

        return "Hi(관리자만 가능한 페이지 입니다)";
    }
}
