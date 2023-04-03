package kr.co.pcmpetclinicstudy.persistence.repository;

import kr.co.pcmpetclinicstudy.persistence.entity.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnersRepository extends JpaRepository<Owners, Long> {
    Optional<Owners> findById(Long id);
}
