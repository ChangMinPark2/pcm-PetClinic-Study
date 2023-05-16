package kr.co.pcmpetclinicstudy.persistence.repository.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.pcmpetclinicstudy.persistence.entity.*;
import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
import kr.co.pcmpetclinicstudy.service.model.request.VisitReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;
import java.util.List;

@RequiredArgsConstructor
public class VetSearchRepository {
    private final JPAQueryFactory jpaQueryFactory;

    private final QVet vet = QVet.vet;

    public List<Vet> find(VetReqDto.CONDITION condition){
        return jpaQueryFactory
                .selectFrom(vet)
                .where(vetIdIn(condition.getIds()))
                .fetch();
    }


    private BooleanExpression vetIdIn(List<Long> ids){
        if (CollectionUtils.isEmpty(ids)){
            return null;
        }

        return vet.id.in(ids);
    }
}
