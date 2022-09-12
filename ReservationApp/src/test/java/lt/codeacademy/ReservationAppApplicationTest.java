package lt.codeacademy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import lt.codeacademy.controller.ServiceContoller;

// 1 testas.
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReservationAppApplicationTest {

	@Autowired
	ServiceContoller serviceContoller;
	
	@Test
	void contextLoads() {
		Assertions.assertThat(serviceContoller).isNotNull();
    }

}
