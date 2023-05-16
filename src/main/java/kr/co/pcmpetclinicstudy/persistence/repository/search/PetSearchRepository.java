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
    /**
     * N+1문제를 해결하기 위해서는 일반적으로 즉시 로딩이나, 지연로딩을 사용한다.
     * 즉시로딩(Eager Loding) -> 커리 결과를 미리 로딩한다.
     * 지연로딩(Lazy Loding) -> 필요한 경우에만 로딩하여 불필요한 데이터베이스 요청을 최소화 할 수 있다.
     * 아래에서 사용한 fetchJoin은 Lazy로 설정된 관계를 즉시로딩으로 땡겨온다.
     * */
    public List<Pet> find(PetReqDto.CONDITION condition){
        return jpaQueryFactory
                .selectFrom(pet)
                .join(owner)
                .fetchJoin()
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
