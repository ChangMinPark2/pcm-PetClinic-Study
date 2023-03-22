package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_vets")
@AttributeOverride( //컬럼 명 속성 재 정의
        name = "id",
        column = @Column(name = "vets_id", length = 4)
)
public class Vets extends BaseEntity {

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Builder
    public Vets(String firstName,
                String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
