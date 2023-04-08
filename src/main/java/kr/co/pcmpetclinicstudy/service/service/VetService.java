package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialties;
import kr.co.pcmpetclinicstudy.persistence.repository.SpecialtiesRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VetRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.VetMapper;
import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VetResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VetService {

    private final VetRepository vetRepository;

    private final SpecialtiesRepository specialtiesRepository;

    private final VetMapper vetMapper;

    @Transactional
    public void CreateVet(VetReqDto.CREATE create){

        final Vet vet = vetMapper.createOf(create, Collections.emptyList());

        final List<VetSpecialties> vetSpecialties = getOrCreateVetSpecialties(create.getSpecialtiesName(), vet);

        vet.updateVetSpecialties(vetSpecialties);

        vetRepository.save(vet);
    }

    @Transactional
    public void updateVet(VetReqDto.UPDATE update){
        Vet vets = vetRepository.findById(update.getVetId())
                        .orElseThrow(() -> new RuntimeException("Not Found Vet"));

        final List<VetSpecialties> vetSpecialties = getOrCreateVetSpecialties(update.getSpecialtiesName(), vets);

        vets.updateVetSpecialties(vetSpecialties);

        vetRepository.save(vets);
    }

    @Transactional
    public void deleteVet(Long ownerId){
        final Vet vets = vetRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Not Found Vet"));

        vetRepository.delete(vets);
    }

    public VetResDto.READ readVetDto(Long vetId){
        Vet vets = vetRepository.findById(vetId)
                .orElseThrow(() -> new RuntimeException("Not Found Vet"));

        final List<String> specialtiesName = getSpecialtiesNameByVet(vets);

        return vetMapper.readOf(vets, specialtiesName);
    }

    private List<String> getSpecialtiesNameByVet(Vet vet){
        return vet.getVetSpecialties().stream()
                .map(VetSpecialties::getSpecialties)
                .map(Specialties::getName)
                .collect(Collectors.toList());
    }

    private List<Specialties> getOrCreateSpecialtiesByName(List<String> names){

        final List<Specialties> specialties = specialtiesRepository.findAllByName(names);

        final Set<String> existNames = specialties.stream()
                .map(Specialties::getName)
                .collect(Collectors.toSet());

        final List<Specialties> createSpecialties = names.stream()
                .filter(name -> !existNames.contains(name))
                .map(Specialties::paramToEntity)
                .collect(Collectors.toList());

        specialties.addAll(createSpecialties);

        return specialties;
    }

    private List<VetSpecialties> getOrCreateVetSpecialties(List<String> name,
                                                           Vet vet){
        final List<Specialties> specialties = getOrCreateSpecialtiesByName(name);

        return specialties.stream()
                .map(specialties1 -> VetSpecialties.builder()
                        .specialties(specialties1)
                        .vets(vet)
                        .build())
                .collect(Collectors.toList());
    }

}
