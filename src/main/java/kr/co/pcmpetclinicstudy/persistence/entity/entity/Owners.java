package kr.co.pcmpetclinicstudy.persistence.entity.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "tbl_owners")
@Entity
@NoArgsConstructor //기본 생성자 만들기
public class Owners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owners_id")
    private Long oId;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone", unique = true)
    private String telephone;

    @Builder
    public Owners(Long oId,
                  String address,
                  String city,
                  String firstName,
                  String lastName,
                  String telephone) {
        this.oId = oId;
        this.address = address;
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }
}
