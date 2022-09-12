package lt.codeacademy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lt.codeacademy.service.ClientService;

@SpringBootTest
class BookingControllerTest {
	
	@Autowired
	ClientService clientService;
	
	
// 3 testas
	@Test
	void failsIfBookingControllerNotAutowired() {
		Assertions.assertThat(clientService).isNotNull();
		
	}

}

