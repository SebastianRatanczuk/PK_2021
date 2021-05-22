package soundsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CDPlayerMain {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "peper");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        CDPlayerConfig.class);
        MediaPlayer player = context.getBean(CDPlayer.class);
        player.play();
        context.close();
    }

}
