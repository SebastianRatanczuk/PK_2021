package contacts.config;

import contacts.dao.repository.ContactsRepository;
import contacts.dao.repository.ContactsRepositoryImpl;
import contacts.services.ContactServiceImpl;
import contacts.services.ContactsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Klasa konfigurująca usługi dodatkowe
@Configuration
@ComponentScan(basePackages = {"contacts"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class RootConfig {

        @Bean
        public ContactsRepository contactRepository() {
                return new ContactsRepositoryImpl();
        }

        @Bean
        public ContactsService contactsService() {
                return new ContactServiceImpl();
        }
}