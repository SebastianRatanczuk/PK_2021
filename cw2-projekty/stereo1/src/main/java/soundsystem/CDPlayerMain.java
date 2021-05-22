package soundsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CDPlayerMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("soundsystem");
        context.refresh();

        MediaPlayer player = context.getBean(MediaPlayer.class);
        player.play();
        context.close();
    }
}

