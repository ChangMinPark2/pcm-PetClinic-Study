package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_specialties")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AttributeOverride(
        name = "id",
        column = @Column(name = "specialties_id", length = 4)
)
public class Specialty extends BaseEntity {

    @Column(name = "specialties_name", length = 80)
    private String specialtiesNames;

    @Builder
    private Specialty(String specialtiesNames) {
        this.specialtiesNames = specialtiesNames;
    }

    public void updateSpecialtiesName(String specialtiesNames){
        this.specialtiesNames = specialtiesNames;
    }
}
