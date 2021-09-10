package br.com.quimicar.api;

import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.repository.ElementRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class ApiApplicationTests {
//	@Autowired
//	private ElementRepository elementRepository;


	@Test
	void contextLoads() {
	}

//	@Test
//	void testCreateElement() {
//		Integer[] shells = new Integer[] {1};
//
//		ElementEntity element = new ElementEntity();
//		element.setNumber(120);
//		element.setAtomic_mass(1.00784);
//		element.setName("Testing Element");
//		element.setSymbol("Te");
//		element.setCategory("nonmetal");
//		element.setElement_img("https://cen.acs.org/content/dam/cen/89/web/20111116lnj1-SANY0429.jpg");
//		element.setShells(shells);
//		elementRepository.save(element);
//		assertNotNull(element.getId());
//	}

//	@Test
//	void testShouldDeleteElement() {
//		ElementEntity removed = elementRepository.delete();
//	}

//	@Test
//	void testShouldGetElement() {
//		List<ElementEntity> elements = elementRepository.findAll();
//		assertNotNull(elements);
//	}

}
