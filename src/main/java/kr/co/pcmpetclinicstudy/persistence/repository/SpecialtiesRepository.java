package kr.co.pcmpetclinicstudy.persistence.repository;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialtiesRepository extends JpaRepository<Specialties, Long> {

    Boolean existsBySpecialtiesNames(String SpecialtiesName);

    @Query("select s from Specialties s where s.vet =: vet")
    List<Specialties> findByVet(Vet vet);

    @Query("select s from Specialties s where s.id =:specialtiesId")
    Optional<Specialties> findById(Long specialtiesId);

    @Query("select s from Specialties s")
    List<Specialties> findAll();
}
