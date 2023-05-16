package kr.co.pcmpetclinicstudy.persistence.repository.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.QSpecialty;
import kr.co.pcmpetclinicstudy.persistence.entity.Specialty;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;
import kr.co.pcmpetclinicstudy.service.model.request.SpecialtiesReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SpecialtySearchRepository {

    private final JPAQueryFactory queryFactory;

    private final QSpecialty specialty = QSpecialty.specialty;

    public List<Specialty> find(SpecialtiesReqDto.CONDITION condition){
        return queryFactory
                .selectFrom(specialty)
                .where(specialtyIdIn(condition.getIds()))
                .fetch();
    }

    private BooleanExpression specialtyIdIn(List<Long> ids){
        if (CollectionUtils.isEmpty(ids)){
            return null;
        }

        return specialty.id.in(ids);
    }
}
