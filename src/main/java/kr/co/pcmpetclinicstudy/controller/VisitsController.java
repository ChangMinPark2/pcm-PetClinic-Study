package kr.co.pcmpetclinicstudy.controller;

import kr.co.pcmpetclinicstudy.service.service.VisitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VisitsController {

    private final VisitsService visitsService;
}
