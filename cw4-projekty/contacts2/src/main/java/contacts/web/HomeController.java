package contacts.web;


import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
@NoArgsConstructor
public class HomeController {


    @RequestMapping(method = GET)
    public String home(Model model) {
        return "home";
    }
}
