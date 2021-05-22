package sia.knights;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KnightConfig.class, loader = AnnotationConfigContextLoader.class)
public class KnightJavaConfigInjectionTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();
    @Autowired
    Knight knight;

    @Test
    public void shouldInjectKnightWithSlayDragonQuest() {
        knight.embarkOnQuest();
        assertEquals(
                "Tra la la; Jakiż rycerz jest dzielny!\r\n" +
                        "Look at his horse class sia.knights.BlackHorse\r\n" +
                        "Wsiadam na konia i podejmuję misję pokonania smoka!\r\n" +
                        "Hip hip hura; Dzielny rycerz wypełnił misję!\r\n" +
                        "His horse is amazing class sia.knights.BlackHorse\r\n",
                log.getLog());
    }
}

