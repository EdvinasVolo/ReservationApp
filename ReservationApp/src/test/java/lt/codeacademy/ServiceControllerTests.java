package lt.codeacademy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import lt.codeacademy.controller.ServiceContoller;
import lt.codeacademy.service.ServiceProviderService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ServiceContoller.class)
public class ServiceControllerTests {

	 @MockBean
	 ServiceProviderService serviceProviderService;
	 
	 @Autowired
	    MockMvc mockMvc;
	 
	 @Test
	    void failsIfServiceProviderServiceNotAutowired() {
	        Assertions.assertThat(serviceProviderService).isNotNull();
	    }
	  
}
