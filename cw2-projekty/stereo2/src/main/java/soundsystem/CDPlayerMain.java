package soundsystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CDPlayerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/stereo.xml");
        MediaPlayer player = (MediaPlayer) context.getBean("cdPlayer");
        player.play();
        context.close();
    }
}
