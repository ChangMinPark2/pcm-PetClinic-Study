package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Table
@Entity(name = "tbl_specialties")
@AttributeOverride(
        name = "id",
        column = @Column(name = "specialties_id", length = 4)
)
public class Specialties extends BaseEntity {

    @OneToMany(mappedBy = "specialties")
    List<VetSpecialties> vetSpecialties = new ArrayList<>();
}
