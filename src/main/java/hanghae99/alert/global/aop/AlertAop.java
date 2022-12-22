package hanghae99.alert.global.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect //AOP 가능하게 하는 어노테이션
@Component
public class AlertAop {
    long i = 0;
    @Around("execution(public * hanghae99.alert.calendar.controller..*(..))")
    public synchronized Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("================= " + i + "회 성능 검사 시작 =================");
        try {
            Object output = joinPoint.proceed();
            return output;
        } finally {
            long endTime = System.currentTimeMillis();

            long runTime = endTime - startTime;

            log.info("================= " + i + "회 성능 검사 종료 : " + runTime + "ms =================");
            i++;
        }
    }
}
