package lt.codeacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.entity.Client;

@Controller
@RequestMapping("/login")
public class MainControler {
	
	
	@GetMapping("/home")
    public String showCreateForm(Client client) {
        return "/index/home";
	}
}
