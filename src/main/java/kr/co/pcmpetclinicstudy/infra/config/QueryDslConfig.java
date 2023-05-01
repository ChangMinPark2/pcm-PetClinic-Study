package kr.co.pcmpetclinicstudy.infra.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Spring의 설정 클래스이다. -> 이 클래스의 빈 메소드는 Spring 컨테이너 빈으로 사용된다.
public class QueryDslConfig {

    /**
     * JPAQueryFactory 클래스 -> Querydsl을 사용하여 JPA쿼리를 생성하는데 사용됨
     * */
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }

}
