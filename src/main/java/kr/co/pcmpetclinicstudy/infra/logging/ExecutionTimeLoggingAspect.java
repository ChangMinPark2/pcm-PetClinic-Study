package kr.co.pcmpetclinicstudy.infra.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j // Logger객체 자동 생성 (lombok)
public class ExecutionTimeLoggingAspect {

    // 실행 위치 지정, 이 클래스의 모든 메소드가 해당 포인트 컷에 매칭된다.
    @Pointcut("execution(* kr.co.pcmpetclinicstudy.service.service.OwnersService.*(..))")
    private void allOwnerService(){}

    @Pointcut("execution(* kr.co.pcmpetclinicstudy.service.service.PetService.*(..))")
    private void allPetService() {
    }

    @Pointcut("execution(* kr.co.pcmpetclinicstudy.service.service.VetService.*(..))")
    private void allVetService() {
    }

    @Pointcut("execution(* kr.co.pcmpetclinicstudy.service.service.VisitService.*(..))")
    private void allVisitService() {
    }

    //메소드 실행 전후에 처리를 수행해주는 어노테이션이다.
    @Around("allOwnerService() || allPetService() || allVetService() || allVisitService()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        //매개변수 -> AOP를 통해 적용된 메소드를 나타내는 객체이다.

        String className = joinPoint.getTarget().getClass().getSimpleName();
        // 현재 실행되고 있는 메소드가 속한 클래스의 이름을 가져온다.

        String methodName = joinPoint.getSignature().getName();
        //메소드 이름

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        //실행시간 측정

        Object result = joinPoint.proceed();
        //실제 메소드 시작. result에 저장
        stopWatch.stop();
                            //클라스이름.메소드이름 : 시간
        log.info("[ExecutionTime] {}.{} : {}ms", className, methodName, stopWatch.getTotalTimeMillis());
        //실행 시간을 로그로 출력 로그는 실행된 메소드의 클래스, 메소드, 실행시간을 포함한다.
        return result;
    }

}
