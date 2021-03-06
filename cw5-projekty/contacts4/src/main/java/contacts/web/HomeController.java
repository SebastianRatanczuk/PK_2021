package contacts.web;

import contacts.data.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(method = GET)
    public String home(Model model) {
        model.addAttribute("contacts", contactRepository.findContacts(0, 0));
        return "home";
    }
}
