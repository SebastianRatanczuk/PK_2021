package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
@ActiveProfiles(profiles = "dev")
public class CDPlayerTestDEV {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;

    @Test
    public void play() {
        player.play();
        assertEquals(
                "Playing DaftPunk My Fav by DaftPunk\r\n" +
                        "-Track: One More Time\r\n" +
                        "-Track: Get Lucky\r\n" +
                        "-Track: Instant Crush\r\n" +
                        "-Track: Harder, Better, Faster, Stronger\r\n" +
                        "-Track: Around The World\r\n" +
                        "-Track: Digital Love\r\n" +
                        "-Track: Aerodynamic\r\n",
                log.getLog());
    }

}
