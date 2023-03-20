package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_vets")
public class Vets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vets_id")
    private Long vId;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Builder
    public Vets(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
