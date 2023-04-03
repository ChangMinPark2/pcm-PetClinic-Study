package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Vets;
import kr.co.pcmpetclinicstudy.persistence.repository.VetsRepository;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.CreateVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.UpdateVetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetsService {

    private final VetsRepository vetsRepository;

    public void CreateVet(CreateVetDto createVetDto){
        final Vets vetsBuild = Vets.of(createVetDto);

        vetsRepository.save(vetsBuild);
    }

    public void updateVet(UpdateVetDto updateVetDto){
        Vets vets = new Vets();

        vets.updateVet(updateVetDto.getFirstName(), updateVetDto.getLastName(), updateVetDto.getVetSpecialties());

        vetsRepository.save(vets);
    }
}
