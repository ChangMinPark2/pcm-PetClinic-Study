package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VetResDto;
import kr.co.pcmpetclinicstudy.service.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vet")
public class VetController {

    private final VetService vetsService;

    @PostMapping
    public void createVet(@RequestBody @Valid VetReqDto.CREATE create){
        vetsService.CreateVet(create);
    }

    @PutMapping
    public void updateVet(@RequestBody @Valid VetReqDto.UPDATE update){
        vetsService.updateVet(update);
    }

    @DeleteMapping
    public void deleteVet(@PathVariable(name = "vet_id")Long vetId){
        vetsService.deleteVet(vetId);
    }

    @GetMapping
    public VetResDto.READ readVet(@PathVariable(name = "id") Long id){
        return vetsService.readVetDto(id);
    }
}
