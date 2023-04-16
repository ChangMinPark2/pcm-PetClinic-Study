package kr.co.pcmpetclinicstudy.persistence.repository;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findByPet(Pet pet);
    List<Visit> findByOwner(Owner owner); //해당 소유자 방문 정보 리스트


    @Query("select v from Visit v where v.owner.id =:ownerId")
    List<Visit> findByOwnerId(Long ownerId);

    @Query("select v from Visit v where v.pet.id =:petId")
    List<Visit> findByPetId(Long petId);
}
