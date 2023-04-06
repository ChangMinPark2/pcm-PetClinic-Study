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
    private String name;

    @Builder
    public Specialties(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "specialties")
    List<VetSpecialties> vetSpecialties = new ArrayList<>();

    public static Specialties paramToEntity(String name){

        return Specialties.builder()
                .name(name)
                .build();
    }

}
