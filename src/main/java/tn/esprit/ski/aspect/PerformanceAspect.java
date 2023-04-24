package tn.esprit.ski.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Aspect
@Component
@Slf4j
public class PerformanceAspect{
    @Around("execution( * tn.esprit.ski.Services.*.add*(..))")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatch stopWatch= new StopWatch();
        Object o = joinPoint.proceed();
        stopWatch.stop();
        log.info("executionTime of {} is {}",joinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
         return o;
    }
    @Around("execution( * tn.esprit.ski.Services.InscriServiceImp.getAll(..))")
    public List<Object> executionTime2(ProceedingJoinPoint joinPoint) throws Throwable{
        List<Object> o = (List<Object>) joinPoint.proceed();
        return o;
    }
}
