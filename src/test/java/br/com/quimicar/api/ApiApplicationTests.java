package br.com.quimicar.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

	@Test
	void contextLoads() {
	}

	// @Autowired
	// ElementRepository elementRepository;

	// @Test
	// void testElements() {
	// 	Number[] shells = new Number[] {1};

	// 	ElementEntity element = new ElementEntity();
	// 	element.setNumber(1);
	// 	element.setAtomic_mass(1.00784);
	// 	element.setName("Hidrogênio");
	// 	element.setSymbol("H");
	// 	element.setCategory("nonmetal");
	// 	element.setElement_img("https://cen.acs.org/content/dam/cen/89/web/20111116lnj1-SANY0429.jpg");
	// 	element.setShells(shells);
	// 	elementRepository.save(element);

	// 	assertNotNull(element.getElement_id());
	// }

}
