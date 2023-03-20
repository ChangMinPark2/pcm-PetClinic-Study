package kr.co.pcmpetclinicstudy.persistence.entity;

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
    @Column(name = "owners_id", length = 4) //Column(length -> 데이터베이스 안 열의 문자열의 길이 지정)
    private Long oId;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "telephone", unique = true, length = 30)
    private String telephone;

    @Builder
    public Owners(String address,
                  String city,
                  String firstName,
                  String lastName,
                  String telephone) {
        this.address = address;
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }
}
