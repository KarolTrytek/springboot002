package com.example.springboot002;

import com.example.springboot002.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final String title = "Test page";

    @Autowired //adnotacja okresla, ze spring sam wstrzykuje zaleznosc do zmiennej
    private UserRepository userRepository; //pobranie repozytorium z userami

    @GetMapping("/") //żądanie get pod adresem glownym
    public String index(Model model) { //model abysmy mogli zwrocic dane do szablonu
        model.addAttribute("title", title);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/user/view/{id}")
    public String singleUserWiev(@PathVariable("id") int id, Model model) { //zwracamy dane po wpisaniu id
        model.addAttribute("title", title);
        model.addAttribute("user", userRepository.findById(id).get());
        return "user/view";
    }

    @GetMapping("/home")
    public String home(Model model,
                       @RequestParam(value = "name",
                               required = false,
                               defaultValue = "Guest") String name ) {
        model.addAttribute("name", name);
        model.addAttribute("title", title);
        return "home";
    }
}
