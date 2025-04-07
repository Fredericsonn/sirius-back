package upec.episen.eco;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = EcoApplication.class,
    exclude = UserController.class
)
class EcoApplicationTests {

	@Test
	void contextLoads() {
	}

}
