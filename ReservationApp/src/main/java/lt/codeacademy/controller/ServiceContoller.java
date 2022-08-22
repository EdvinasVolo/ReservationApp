package lt.codeacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.service.ClientService;
import lt.codeacademy.service.ServiceProviderService;

@RestController
@RequestMapping("/service")
public class ServiceContoller {
	@Autowired
	ServiceProviderService serviceService;

}
