package kr.co.pcmpetclinicstudy.persistence;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
/*
* 직접 생성해서 사용할 일이 없으므로 추상 클래스로 만드는 것을 권장한다. 추상 클래스는 상속을 강제하기 위한 것.
 * */
@Getter
@MappedSuperclass //엔티티로 생성 안됨. 이 클라스를 상속받은 엔티티에 매핑되는 테이블에 id생성됨.
@EqualsAndHashCode(of = "id", callSuper = false)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
