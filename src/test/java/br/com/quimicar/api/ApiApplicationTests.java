package br.com.quimicar.api;


import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.entity.UserEntity;
import br.com.quimicar.api.repository.ElementRepository;
import br.com.quimicar.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class ApiApplicationTests {
	@Autowired
	private ElementRepository elementRepository;
	@Autowired
	private UserRepository userRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void testCreateElement() {
		Integer[] shells = new Integer[] {1};
		Integer[] ionization_energies = new Integer[] {1};
		ElementEntity element = new ElementEntity();
		element.setNumber(120);
		element.setAtomic_mass(1.00784);
		element.setName("Testing Element");
		element.setSymbol("Te");
		element.setCategory("nonmetal");
		element.setElement_img("https://cen.acs.org/content/dam/cen/89/web/20111116lnj1-SANY0429.jpg");
		element.setShells(shells);
		element.setEnabled(true);
		element.setIonization_energies(ionization_energies);
		elementRepository.save(element);
		assertNotNull(element.getId());
	}

	@Test
	void testShouldFindAllElements() {
		List<ElementEntity> elements = elementRepository.findAll();
		assertNotNull(elements);
	}

	@Test
	void testShouldCreateUser() {
		UserEntity user = new UserEntity();
		user.setEmail("user@test.com");
		user.setPassword("123456");
		userRepository.save(user);
		assertNotNull(user.getId());
	}
}
