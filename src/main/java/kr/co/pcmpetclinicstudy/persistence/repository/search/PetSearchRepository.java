package kr.co.pcmpetclinicstudy.persistence.repository.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.entity.QOwner;
import kr.co.pcmpetclinicstudy.persistence.entity.QPet;
import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PetSearchRepository {

    private final JPAQueryFactory jpaQueryFactory;

    private final QPet pet = QPet.pet;

    private final QOwner owner = QOwner.owner;

    public List<Pet> find(PetReqDto.CONDITION condition){
        return jpaQueryFactory
                .selectFrom(pet)
                .join(owner).fetchJoin()
                .where(petIdIn(condition.getIds()))
                .fetch();
    }

    private BooleanExpression petIdIn(List<Long> ids){
        if (CollectionUtils.isEmpty(ids)){
            return null;
        }

        return pet.id.in(ids);
    }
}
