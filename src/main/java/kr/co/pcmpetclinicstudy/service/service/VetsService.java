package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Vets;
import kr.co.pcmpetclinicstudy.persistence.repository.VetsRepository;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.CreateVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.DeleteVetDto;
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

    public void deleteVet(DeleteVetDto deleteVetDto){
        Vets vets = new Vets();
        // Dto의 무슨 값을 가져와서 일치하는지 확인하는 것을 모르겠음.
        // 기본키를 가져온다해도 자신의 기본키를 입력한다?
        vetsRepository.delete(vets);
    }
}
