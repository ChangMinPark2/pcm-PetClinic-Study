package kr.co.pcmpetclinicstudy.persistence.repository;

import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface VetSpecialtiesRepository extends JpaRepository<VetSpecialty, Long> {

    @Query("select vs from VetSpecialty vs where vs.vet.id=:vetId")
    List<VetSpecialty> findByVetId(@Param("vetId") Long vetId);

    Set<VetSpecialty> findByVetAndSpecialty_SpecialtiesNamesIn(Vet vet, Set<String> specialtiesNames);

    @Query("select count(vs) from VetSpecialty vs where vs.specialty.specialtiesNames =:specialtiesNames")
    int countBySpecialtyName(@Param("specialtiesNames")String specialtiesNames);
}
