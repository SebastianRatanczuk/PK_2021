package concert;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConcertMain {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "prod");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
        Performance p = context.getBean(Performance.class);

        p.perform();
        context.close();
    }
}
