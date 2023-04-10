package kr.co.pcmpetclinicstudy.persistence.repository;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpecialtiesRepository extends JpaRepository<Specialties, Long> {

    List<Specialties> findAllByName(List<String> names);
}
