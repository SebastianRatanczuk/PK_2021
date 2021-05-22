package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:META-INF/spring/stereo.xml", "classpath:META-INF/spring/stereo.xml"})
public class CDPlayerConfig {
}

