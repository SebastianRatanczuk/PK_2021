package concert;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

public class ConcertConfig {
    @Bean
    @Primary
    @Profile("prod")
    public Performance wood() {
        return new Woodstock();
    }

    @Bean
    @Qualifier("ThrowTest")
    @Profile("test")
    public Performance woodFail() {
        return new Woodstock2();
    }

    @Bean
    Audience audience() {
        return new Audience();
    }
}
