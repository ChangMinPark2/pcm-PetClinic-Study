package kr.co.pcmpetclinicstudy.controller;

import kr.co.pcmpetclinicstudy.service.service.VetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VetsController {

    private final VetsService vetsService;
}
