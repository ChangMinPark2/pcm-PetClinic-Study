package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.controller.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.controller.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialties;
import kr.co.pcmpetclinicstudy.persistence.repository.SpecialtiesRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VetRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.SpecialtiesMapper;
import kr.co.pcmpetclinicstudy.service.model.mapper.VetMapper;
import kr.co.pcmpetclinicstudy.service.model.mapper.VetSpecialtiesMapper;
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

    private final VetSpecialtiesMapper vetSpecialtiesMapper;

    private final SpecialtiesMapper specialtiesMapper;

    @Transactional
    public void createVet(VetReqDto.CREATE create){

        Vet vet = vetMapper.toVetEntity(create, Collections.emptyList());

        final List<VetSpecialties> vetSpecialties = getOrCreateVetSpecialties(create.getSpecialtiesName(), vet);

        vet.updateVetSpecialties(vetSpecialties);

        vetRepository.save(vet);
    }

    public VetResDto.READ readVetDto(Long vetId){

        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final List<String> specialtiesName = getSpecialtiesNameByVet(vet);

        return vetMapper.toReadDto(vet, specialtiesName);
    }

    @Transactional
    public void updateVet(VetReqDto.UPDATE update){

        Vet vet = vetRepository.findById(update.getVetId())
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final List<VetSpecialties> vetSpecialties = getOrCreateVetSpecialties(update.getSpecialtiesName(), vet);

        vet.updateVetSpecialties(vetSpecialties);
    }

    public void deleteVet(Long vetId){

        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        vetRepository.delete(vet);
    }

    private List<String> getSpecialtiesNameByVet(Vet vet){

        return vet.getVetSpecialties().stream()
                .map(VetSpecialties::getSpecialties)
                .map(Specialties::getSpecialtiesName)
                .collect(Collectors.toList());
    }

    private List<Specialties> getOrCreateSpecialtiesByNames(List<String> names){

        List<Specialties> specialties = specialtiesRepository.findAllByName(names);

        final Set<String> existNames = specialties.stream()
                .map(Specialties::getSpecialtiesName)
                .collect(Collectors.toSet());

        final List<Specialties> createSpecialties = names.stream()
                .filter(name -> !existNames.contains(name))
                .map(specialtiesMapper::toSpecialtiesEntity)
                .collect(Collectors.toList());

        specialties.addAll(createSpecialties);

        return specialties;
    }

    private List<VetSpecialties> getOrCreateVetSpecialties(List<String> names,
                                                           Vet vet){

        final List<Specialties> specialty = getOrCreateSpecialtiesByNames(names);

        return specialty.stream()
                .map(specialties -> vetSpecialtiesMapper.toVetSpecialtiesEntity(specialties, vet))
                .collect(Collectors.toList());
    }

}
