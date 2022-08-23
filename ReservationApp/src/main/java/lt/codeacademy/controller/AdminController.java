package lt.codeacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.service.ClientService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ClientService clientService; 
	
	@GetMapping("/admin")
	public String sayHello() {
		return "Admin: Viskas OK";
	}	
	
//	
//	@GetMapping("/index")
//	public String showUserList(Model model) {
//	    model.addAttribute("clients", clientService.findAll());
//	    return "admin/index";
//	}
	
}
