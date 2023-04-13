package kr.co.pcmpetclinicstudy.persistence.repository;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpecialtiesRepository extends JpaRepository<Specialties, Long> {

    //List<Specialties> findAllBySpecialtiesName(List<String> names);

    @Query("" +
            "select s " +
            "from Specialties s " +
            "where s.specialtiesNames in :specialtiesNames")
    List<Specialties> findAllBySpecialtiesNamesIn(List<String> specialtiesNames);

}
