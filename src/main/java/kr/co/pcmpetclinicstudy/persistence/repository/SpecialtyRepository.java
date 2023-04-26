package kr.co.pcmpetclinicstudy.persistence.repository;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialty;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Boolean existsBySpecialtiesNames(String SpecialtiesName);

    @Query("select s from Specialty s where s.specialtiesNames in:specialtiesNames")
    List<Specialty> findAllBySpecialtiesNameIn(@Param("specialtiesNames")Set<String> specialtiesNames);

    @Query("select s from Specialty s where s.specialtiesNames =:specialtyName")
    Optional<Specialty> findBySpecialtyName(String specialtyName);

    @Query("select s from Specialty s")
    List<Specialty> findAll();
}
