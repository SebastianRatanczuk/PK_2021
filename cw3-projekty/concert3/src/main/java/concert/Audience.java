package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance() {
    }

    @Around("performance()")
    public void audiencePerformance(ProceedingJoinPoint joinPoint) {
        try {
            silenceCellPhones();
            takeSeats();
            joinPoint.proceed();
            applause();
        } catch (Throwable e) {
            demandRefund();
        }
    }

    public void silenceCellPhones() {
        System.out.println("Wyłączenie telefonów");
    }

    public void takeSeats() {
        System.out.println("Zajęcie miejsc");
    }

    public void applause() {
        System.out.println("Brawa i oklaski!!!");
    }

    public void demandRefund() {
        System.out.println("Domaganie się zwrotu a bilety");
    }
}