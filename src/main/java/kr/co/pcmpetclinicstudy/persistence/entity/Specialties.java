package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Table(name = "tbl_specialties")
@Entity
@AttributeOverride(
        name = "id",
        column = @Column(name = "specialties_id", length = 4)
)
public class Specialties extends BaseEntity {

    @Column(name = "name", length = 20)
    private String SpecialtiesName;

    @Builder
    public Specialties(String  specialtiesName) {
        this.SpecialtiesName = specialtiesName;
    }
}
