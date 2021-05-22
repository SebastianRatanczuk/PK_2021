package concert;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {

    @Before("execution(* concert.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Wyłączenie telefonów");
    }

    @Before("execution(* concert.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Zajęcie miejsc");
    }

    @AfterReturning("execution(* concert.Performance.perform(..))")
    public void applause() {
        System.out.println("Brawa i oklaski!!!");
    }

    @AfterThrowing("execution(* concert.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Domaganie się zwrotu a bilety");
    }
}