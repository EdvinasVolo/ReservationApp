package lt.codeacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.entity.Client;
import lt.codeacademy.repository.ClientRepository;
import lt.codeacademy.service.ClientService;



@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	ClientRepository clientRepository;
	
	@PostMapping("/save")
	public String saveClient(Client client) {
		clientService.save(client);
		return "redirect:/service";
	}

	@GetMapping("/create")
    public String showCreateForm(Client client) {
        return "/clients/add-client";
    }
	@PostMapping("/create")
    public String showForm(Client client) {
        return "/clients/add-client";
    }
	
	@GetMapping("/all")
	public String getAllDishes(Model model){
		model.addAttribute("client",clientService.getAll());
		model.addAttribute("hello","Welcome to our restaurant");
		return "/clients/list";
	}

}
