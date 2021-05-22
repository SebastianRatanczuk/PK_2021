package sia.knights;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightJavaMain {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                sia.knights.config.KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
