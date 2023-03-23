package kr.co.pcmpetclinicstudy.controller;

import kr.co.pcmpetclinicstudy.service.service.PetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PetsController {

    private final PetsService petsService;
}
