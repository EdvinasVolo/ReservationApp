package lt.codeacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.entity.Client;
import lt.codeacademy.entity.Provider;

import lt.codeacademy.repository.ProviderRepository;
import lt.codeacademy.service.ClientService;
import lt.codeacademy.service.ProviderService;

@Controller
@RequestMapping("/service")
public class ServiceContoller {
	@Autowired
	ProviderService serviceService;
	
	@Autowired
	ProviderRepository serviceRepository;



	@GetMapping("")
	public String showList(Model model) {
		model.addAttribute("providers", serviceService.findAllProvider());
		return "/index/Home";	
	}
	@GetMapping("/show")
	public String showListAfterLogin(Model model) {
		model.addAttribute("providers", serviceService.findAllProvider());
		return "/index/Home";	
	}
	
	@GetMapping("/create")
	public String showCreateForm(Provider serviceProvider) {
		return "/index/addProvider";
	}


	@PostMapping("/save")
	public String saveClient(Provider serviceProvider) {
		serviceService.save(serviceProvider);
		return "redirect:/service";
	}

	@GetMapping("/edit/{id}")
	public String editProvider(@PathVariable("id") int id, Model model) {
		Provider serviceProvider = serviceService.findById(id);   
		model.addAttribute("provider", serviceProvider);
		return "/index/review";		
	}

	

	@PostMapping("/updateProvider/{id}")
	public String updateProvider(@PathVariable("id") int id, Provider serviceProvider, BindingResult result,
			Model model) {
		  if (result.hasErrors()) {
		serviceProvider.setId(id);
		return "/index/save";
	}
	serviceService.save(serviceProvider);
	    return "redirect:/service";
	}
	@GetMapping("/delete/{id}")
	public String deleteProvider(@PathVariable("id") int id, Model model) {
		ProviderRepository provider = serviceRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		serviceRepository.delete((Provider) provider);
	    return "redirect:/service";
	}
	
	@GetMapping("/reservation")
	public String reservation(Model model) {
		return "/index/reservation";
	}
	 @GetMapping("/logout")
	    public String redirectToLogout(){
	        return "/index/login.html";
	    }
	
}
//	@PostMapping("/update/{id}")
//	public String updateUser(@PathVariable("id") int id, Student student,  Model model) {
//	    if (result.hasErrors()) {
//	        student.setId(id);
//	        return "admin/update-student";
//	    }
//	        
//	    studentService.save(student);
//	    return "redirect:/admin/index";
//	}
