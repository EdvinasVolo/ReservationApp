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
import lt.codeacademy.entity.ServiceProvider;

import lt.codeacademy.repository.ServiceProviderRepository;
import lt.codeacademy.service.ClientService;
import lt.codeacademy.service.ServiceProviderService;

@Controller
@RequestMapping("/service")
public class ServiceContoller {
	@Autowired
	ServiceProviderService serviceService;
	
	@Autowired
	ServiceProviderRepository serviceRepository;



	@GetMapping("")
	public String showList(Model model) {
		model.addAttribute("providers", serviceService.findAllProvider());
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

	@GetMapping("/edit/{id}")
	public String editProvider(@PathVariable("id") int id, Model model) {
		ServiceProvider serviceProvider = serviceService.findById(id);   
		model.addAttribute("provider", serviceProvider);
		return "/index/review";		
	}

	//	@PostMapping("/updateProvider/{id}")
	//	public String updateProvider(@PathVariable("id"), Model model) {		
	//}

	@PostMapping("/updateProvider/{id}")
	public String updateProvider(@PathVariable("id") int id, ServiceProvider serviceProvider, BindingResult result,
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
		ServiceProviderRepository provider = serviceRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		serviceRepository.delete((ServiceProvider) provider);
	    return "redirect:/service";
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
