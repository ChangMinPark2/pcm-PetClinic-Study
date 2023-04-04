package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.repository.VetRepository;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.CreateVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.DeleteVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.ReadVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.UpdateVetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VetService {

    private final VetRepository vetRepository;

    public void CreateVet(CreateVetDto createVetDto){
        final Vet vetsBuild = Vet.of(createVetDto);

        vetRepository.save(vetsBuild);
    }

    public void updateVet(UpdateVetDto updateVetDto){
        Vet vets = vetRepository.findById(updateVetDto.getId())
                        .orElseThrow(() -> new RuntimeException("Not Found Vet"));

        vets.updateVet(updateVetDto.getFirstName(), updateVetDto.getLastName(), updateVetDto.getVetSpecialties());

        vetRepository.save(vets);
    }

    public void deleteVet(DeleteVetDto deleteVetDto){
        final Vet vets = vetRepository.findById(deleteVetDto.getId())
                .orElseThrow(() -> new RuntimeException("Not Found Vet"));

        vetRepository.delete(vets);
    }

    @Transactional(readOnly = true)
    public ReadVetDto readVetDto(Long id){
        Vet vets = vetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found Vet"));

        return vets.of(vets);
    }
}
