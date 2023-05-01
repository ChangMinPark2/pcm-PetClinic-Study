package kr.co.pcmpetclinicstudy.persistence.repository.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.pcmpetclinicstudy.persistence.entity.*;
import kr.co.pcmpetclinicstudy.service.model.request.VisitReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class VisitSearchRepository {

    private final JPAQueryFactory jpaQueryFactory;

    private final QPet pet = QPet.pet;

    private final QOwner owner = QOwner.owner;

    private final QVet vet = QVet.vet;

    private final QVisit visit = QVisit.visit;

    public List<Visit> findVisitToOwner(VisitReqDto.CONDITION condition){
        return jpaQueryFactory
                .selectFrom(visit)
                .join(owner).fetchJoin()
                .where(visitToOwnerIdIn(condition.getIds()))
                .fetch();
    }

    public List<Visit> findVisitToPet(VisitReqDto.CONDITION condition){
        return jpaQueryFactory
                .selectFrom(visit)
                .join(pet).fetchJoin()
                .where(visitToOwnerIdIn(condition.getIds()))
                .fetch();
    }

    public List<Visit> findVisitToVet(VisitReqDto.CONDITION condition){
        return jpaQueryFactory
                .selectFrom(visit)
                .join(vet).fetchJoin()
                .where(visitToOwnerIdIn(condition.getIds()))
                .fetch();
    }

    private BooleanExpression visitToOwnerIdIn(List<Long> ids){
        if (CollectionUtils.isEmpty(ids)){
            return null;
        }

        return visit.id.in(ids);
    }
}
