package sia.knights;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Minstrel {

    public Minstrel() {
    }

    @Pointcut("execution(* sia.knights.Quest.embark(Horse)) && args(horse)")
    public void KnightMission(Horse horse) {
    }

    @Before(value = "KnightMission(horse)", argNames = "horse")
    public void singBeforeQuest(Horse horse) {
        System.out.println("Tra la la; Jakiż rycerz jest dzielny!");
        System.out.println("Look at his horse " + horse.getClass());
    }

    @After(value = "KnightMission(horse)", argNames = "horse")
    public void singAfterQuest(Horse horse) {
        System.out.println("Hip hip hura; Dzielny rycerz wypełnił misję!");
        System.out.println("His horse is amazing " + horse.getClass());
    }
}
