package lt.codeacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.entity.Client;
import lt.codeacademy.entity.ServiceProvider;
import lt.codeacademy.service.ClientService;
import lt.codeacademy.service.ServiceProviderService;

@Controller
@RequestMapping("/service")
public class ServiceContoller {
	@Autowired
	ServiceProviderService serviceService;
	
	
	
	@GetMapping("")
	public String showList(ServiceProvider serviceProvider) {
		serviceService.findAll();
		return "/index/list";
		
	}
	@GetMapping("/create")
    public String showCreateForm(ServiceProvider serviceProvider) {
        return "/index/addProvider";
    }
	@PostMapping("/save")
	public String saveClient(ServiceProvider serviceProvider) {
		serviceService.save(serviceProvider);
		return "redirect:/service";
	}
}
