package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tbl_owners")
@NoArgsConstructor (access = AccessLevel.PROTECTED)//기본 생성자 만들기
@AttributeOverride( //컬럼 명 속성 재 정의
        name = "id",
        column = @Column(name = "owners_id", length = 4)
)
public class Owner extends BaseEntity {

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
    public Owner(String address,
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

    public void updateOwner( OwnerReqDto.UPDATE update){
        this.address = update.getAddress();
        this.city = update.getCity();
        this.firstName = update.getFirstName();
        this.lastName = update.getLastName();
        this.telephone = update.getTelephone();
    }

}
