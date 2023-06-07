package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import kr.co.pcmpetclinicstudy.service.model.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_admin")
@Getter
@NoArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(name = "admin_id")
)
public class Member extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "identity")
    private String identity;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

}
