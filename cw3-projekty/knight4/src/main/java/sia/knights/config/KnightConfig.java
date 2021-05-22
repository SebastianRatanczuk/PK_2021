package sia.knights.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sia.knights.*;

@Configuration
@EnableAspectJAutoProxy
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest();
    }

    @Bean
    public Horse horse() {
        return new BlackHorse();
    }

    @Bean
    public Minstrel minstrel() {
        return new Minstrel();
    }
}
