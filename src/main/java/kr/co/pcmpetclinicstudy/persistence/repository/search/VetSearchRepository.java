//package kr.co.pcmpetclinicstudy.persistence.repository.search;
//
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import kr.co.pcmpetclinicstudy.persistence.entity.*;
//import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
//import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.util.CollectionUtils;
//import java.util.List;
//
//@RequiredArgsConstructor
//public class VetSearchRepository {
//    private final JPAQueryFactory jpaQueryFactory;
//
//    private final QVet vet = QVet.vet;
//
//    private final QVetSpecialty vetSpecialty = QVetSpecialty.vetSpecialty;
//
//    private final QSpecialty specialty = QSpecialty.specialty;
//
//    public List<Vet> find(VetReqDto.CONDITION condition){
//        return jpaQueryFactory
//                .selectFrom(vet)
//                .where(vetIdIn(condition.getIds()))
//                .fetch();
//    }
//
//    public List<VetSpecialty> vetSpecialtiesName(VetReqDto.CONDITION_SPECIALTY_NAME condition){
//
//        List<String> specialtyName = condition.getSpecialtyName();
//
//        return jpaQueryFactory
//                .selectFrom(vetSpecialty)
//                .where(specialtyNameIn(specialtyName))
//                .fetch();
//    }
//
//    private BooleanExpression specialtyNameIn(List<String> name){
//        if (CollectionUtils.isEmpty(name)){
//            return null;
//        }
//
//        return vetSpecialty.specialty.specialtiesNames.in(name);
//    }
//
//    private BooleanExpression vetIdIn(List<Long> ids){
//        if (CollectionUtils.isEmpty(ids)){
//            return null;
//        }
//
//        return vet.id.in(ids);
//    }
//}
