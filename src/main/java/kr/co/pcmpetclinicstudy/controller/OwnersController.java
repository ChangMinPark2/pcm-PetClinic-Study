package kr.co.pcmpetclinicstudy.controller;

import kr.co.pcmpetclinicstudy.service.service.OwnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OwnersController {

    private final OwnersService ownersService;
}
