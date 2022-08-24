package lt.codeacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.entity.ServiceProvider;
import lt.codeacademy.service.ClientService;
import lt.codeacademy.service.ServiceProviderService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ClientService clientService; 
	
	@Autowired
	ServiceProviderService serviceProviderService;
	
	
//	
//	@GetMapping("/index")
//	public String showUserList(Model model) {
//	    model.addAttribute("clients", clientService.findAll());
//	    return "admin/index";
//	}
	
	
	@GetMapping("/review/{id}")
    public String showOrder(@PathVariable("id") int id, Model model) {
        ServiceProvider serviceProvider = serviceProviderService.findById(id);   
                model.addAttribute("provider", serviceProvider);
                return "/orders/review";
	}
	
	@GetMapping("")
	public String editProvider() {
		return "";
		
	}
	
	
}
