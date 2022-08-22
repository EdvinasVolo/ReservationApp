package lt.codeacademy.cotroller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.entity.Client;
import lt.codeacademy.service.ClientService;



@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/save")
	public String saveClient(Client client) {
		clientService.save(client);
		return "redirect:/clients/create";
	}

	@GetMapping("/create")
    public String showCreateForm(Client client) {
        return "/clients/add-client";
    }
	
	@GetMapping("/all")
	public String getAllDishes(Model model){
		model.addAttribute("dishes",clientService.getAll());
		model.addAttribute("hello","Welcome to our restaurant");
		return "/dishes/list";
	}

}
