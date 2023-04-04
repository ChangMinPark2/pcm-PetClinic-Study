package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.CreateVisitDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.ReadVisitDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tbl_visits")
@AttributeOverride( //컬럼 명 속성 재 정의
        name = "id",
        column = @Column(name = "visits_id", length = 4)
)
public class Visit extends BaseEntity {

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pets_id")
    private Pet pets;

    @Builder
    public Visit(String description,
                 LocalDate visitDate,
                 Pet pets) {
        this.description = description;
        this.visitDate = visitDate;
        this.pets = pets;
    }

    public static Visit of(CreateVisitDto createVisitDto, Pet pets){
        return Visit.builder()
                .description(createVisitDto.getDescription())
                .visitDate(createVisitDto.getVisitDate())
                .pets(pets)
                .build();
    }

    public static ReadVisitDto of(Visit visit){
        return ReadVisitDto.builder()
                .description(visit.description)
                .visitDate(visit.visitDate)
                .petName(visit.pets.getName())
                .build();
    }
}
