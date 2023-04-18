package kr.co.pcmpetclinicstudy.persistence.repository;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    /**
     * Spring Data JPA를 사용함으로써, findBy -> 다음에 나오는 속성을 이용해 where절이 자동생성됨
     * 메소드 이름 규칙으로는 표현하기 어려운 복잡한 쿼리, Join쿼리 등을 작성할 때 직접 쿼리 작성해야함
     * 하지만 밑에 경우, 자동으로 생성되지만, 성능 최적화를 위해 작성(과제)
     * */
    @Query("select p from Pet p where p.owner =:owner")
    List<Pet> findByOwner(Owner owner);

    @Query("select p from Pet p")
    List<Pet> findAll();
}
