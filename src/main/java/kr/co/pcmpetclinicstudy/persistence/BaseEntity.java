package kr.co.pcmpetclinicstudy.persistence;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@MappedSuperclass //엔티티로 생성 안됨. 이 클라스를 상속받은 엔티티에 매핑되는 테이블에 id생성됨.
@EqualsAndHashCode(of = "id", callSuper = false)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
