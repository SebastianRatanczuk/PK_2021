package concert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
@ActiveProfiles(profiles = "test")
public class ConcertFailTest {

    @Autowired
    Performance perf;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void performanceIsNotNullTest() {
        assertNotNull("koncert powinen być przygotowany", perf);
    }

    @Test
    public void performanceTest() {
        Exception exception = assertThrows(ArithmeticException.class,() -> perf.perform());

        assertEquals("Wyłączenie telefonów\r\n" +
                        "Zajęcie miejsc\r\n" +
                        "Koncert Woodstock 2 ...\r\n" +
                        "Domaganie się zwrotu a bilety\r\n",
                log.getLog());

        String expectedMessage = "/ by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
