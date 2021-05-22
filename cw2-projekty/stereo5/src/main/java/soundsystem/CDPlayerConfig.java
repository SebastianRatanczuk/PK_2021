package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Configuration
@PropertySource("classpath:/META-INF/spring/ViolatorCD.properties")
public class CDPlayerConfig {

    @Autowired
    Environment env;

    @Bean
    public MediaPlayer player() {
        return new CDPlayer();
    }

    @Bean
    @Primary
    @Profile("prod")
    CompactDisc SongMachine() {
        String albumTitle = "Song Machine";
        String band = "Gorillaz";
        List<String> songTitles = Arrays.asList("Strange Timez", "The Valley of The Pagans", "The Lost Chord", "Pac-Man", "The Pink Phantom", "Aries", "Desole");
        return new BlankDisc(albumTitle, band, songTitles);
    }

    @Bean
    @Pop
    @Profile("test")
    CompactDisc Cyberpunk77() {
        String albumTitle = env.getProperty("albumTitle");
        String band = env.getProperty("band");
        List<String> songTitles = Arrays.asList(Objects.requireNonNull(env.getProperty("songTitles")).split(";"));
        return new BlankDisc(albumTitle, band, songTitles);
    }

    @Bean
    @Qualifier("DaftPunk")
    @Profile("dev")
    CompactDisc Synth() {
        String albumTitle = "DaftPunk My Fav";
        String band = "DaftPunk";
        List<String> songTitles = Arrays.asList("One More Time", "Get Lucky", "Instant Crush", "Harder, Better, Faster, Stronger", "Around The World", "Digital Love", "Aerodynamic");
        return new BlankDisc(albumTitle, band, songTitles);
    }

    public @interface Pop {
    }
}