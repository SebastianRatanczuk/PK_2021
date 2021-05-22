package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan("soundsystem")
public class CDPlayerConfig {

    @Bean
    public MediaPlayer cdPlayer() {
        return new CDPlayer();
    }

    @Bean
    public CompactDisc getSgtPeppersDisc() {
        return new SgtPeppers();
    }
}

