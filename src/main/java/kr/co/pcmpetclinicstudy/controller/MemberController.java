package kr.co.pcmpetclinicstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @GetMapping
    public String main(){

        return "main-page";
    }

    @GetMapping("/fail")
    public String fail(){

        return "login-fail";
    }

    @GetMapping("/hello")
    public String hello(){

        return "Hi";
    }
}
