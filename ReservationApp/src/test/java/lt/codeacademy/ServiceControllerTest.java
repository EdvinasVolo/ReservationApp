package lt.codeacademy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import lt.codeacademy.controller.ServiceContoller;
import lt.codeacademy.entity.Provider;
import lt.codeacademy.repository.ProviderRepository;
import lt.codeacademy.service.ProviderService;


@SpringBootTest
//@WebMvcTest(ServiceContoller.class)
//@ExtendWith(SpringExtension.class)
class ServiceControllerTest {
	
	@Autowired
	ProviderService serviceService;
	

	
	@Autowired
    MockMvc mockMvc;

	// 2 testas. 
	@Test
    void failsIfProviderServiceNotAutowired() {
        Assertions.assertThat(serviceService).isNotNull();
    }
	
	// 4 testas.
	@Test	void failsIfNoProviderProvidedByService() {		Provider provider = new Provider("Service");
		List<Provider> providers = Arrays.asList(provider);
		
		Mockito.when(serviceService.findAllProvider()).thenReturn(providers);
		
		mockMvc.perform(get("/"))
		.andExpect(status()).isOk());
		

	}
	
}
