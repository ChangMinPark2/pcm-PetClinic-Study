package kr.co.pcmpetclinicstudy.persistence.repository;

import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {

    @Query("select v from Vet v where v.id=:vetId")
    Optional<Vet> findById(Long vetId);
}
