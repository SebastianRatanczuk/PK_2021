package soundsystem;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
@ActiveProfiles(profiles = "test")
public class CDPlayerTestTEST {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;

    @Test
    public void play() {
        player.play();
        assertEquals(
                "Playing CYBERPUNK 2077 by SAMURAI\r\n" +
                        "-Track: Chippin'in\r\n" +
                        "-Track: Never Fade Away\r\n" +
                        "-Track: A Like Supreme\r\n" +
                        "-Track: Black Dog\r\n",
                log.getLog());
    }

}
