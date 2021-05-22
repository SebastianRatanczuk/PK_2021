package contacts.web;

import contacts.Contact;
import contacts.data.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Qualifier("hibernateContactRepository")
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/create", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Contact());
        return "contactForm";
    }

    @RequestMapping(value = "/create", method = POST)
    public String processContact(@Valid Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            return "contactForm";
        }
        contactRepository.insert(contact);
        return "redirect:/";
    }

    @RequestMapping(value = "/update/{id}", method = GET)
    public String updateContact(@PathVariable String id, Model model) {
        System.out.println("******* updateContact id=" + id);
        Contact contact = contactRepository.findOne(Long.parseLong(id));
        model.addAttribute(contact);
        return "contactForm";
    }

    @RequestMapping(value = "/update/{id}", method = POST)
    public String updateContact(@Valid Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            return "contactForm";
        }
        contactRepository.update(contact);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = GET)
    public String updateContact(@PathVariable Long id) {
        contactRepository.delete(id);
        return "redirect:/";
    }

}
