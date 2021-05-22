package concert;

import org.aspectj.lang.annotation.*;


@Aspect
public class Audience {
    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Wyłączenie telefonów");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Zajęcie miejsc");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("Brawa i oklaski!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Domaganie się zwrotu a bilety");
    }
}