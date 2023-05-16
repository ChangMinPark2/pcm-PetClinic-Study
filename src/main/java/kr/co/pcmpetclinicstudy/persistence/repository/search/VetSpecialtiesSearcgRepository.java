package kr.co.pcmpetclinicstudy.persistence.repository.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.pcmpetclinicstudy.persistence.entity.QSpecialty;
import kr.co.pcmpetclinicstudy.persistence.entity.QVetSpecialty;
import kr.co.pcmpetclinicstudy.service.model.request.SpecialtiesReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VetSpecialtiesSearcgRepository {

    private final JPAQueryFactory queryFactory;

    private final QVetSpecialty vetSpecialty = QVetSpecialty.vetSpecialty;

    private final QSpecialty specialty = QSpecialty.specialty;

    public List<Long> find(SpecialtiesReqDto.CONDITION condition){
        return queryFactory
                .select(vetSpecialty.count())
                .from(vetSpecialty)
                .join(specialty).fetchJoin()
                .where(specialtyIdIn(condition.getNames()))
                .fetch();
    }
    /**
     * 다시
     * */
    private BooleanExpression specialtyIdIn(List<String> names){
        if (CollectionUtils.isEmpty(names)){
            return null;
        }

        return vetSpecialty.specialty.specialtiesNames.in(names);
    }
}
