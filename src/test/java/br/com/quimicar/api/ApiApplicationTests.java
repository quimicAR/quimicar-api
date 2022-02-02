package br.com.quimicar.api;

import br.com.quimicar.api.entity.Element;
import br.com.quimicar.api.entity.Role;
import br.com.quimicar.api.entity.User;
import br.com.quimicar.api.repository.ElementRepository;
import br.com.quimicar.api.repository.RoleRepository;
import br.com.quimicar.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback
class ApiApplicationTests {
	@Autowired
	private ElementRepository elementRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Test
	void contextLoads() {}

    @Test
	@Transactional
	void testCreateElement() {
		Integer[] shells = new Integer[] {1};
		Integer[] ionization_energies = new Integer[] {1};
		Element element = new Element();
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
		List<Element> elements = elementRepository.findAll();
		assertNotNull(elements);
	}

	@Test
	@Transactional
	void testShouldCreateUser() {
		User user = new User();
		user.setEmail("user@test.com");
		user.setPassword("123456");
		userRepository.save(user);
		assertNotNull(user.getId());
	}

	@Test
	@Transactional
	void testShouldCreateRoleAndUser() {
		// Create ROLE_MANAGER
		Role role = new Role();
		role.setName("ROLE_MANAGER");
		roleRepository.save(role);

		// Create User Manager
		User manager = new User();
		manager.setFullName("Test Manager");
		manager.setEmail("manager@email.com");
		manager.setPassword("123456");
		manager.setRole(roleRepository.getByName("ROLE_MANAGER"));
		userRepository.save(manager);

		assertEquals("ROLE_MANAGER", manager.getRole().getName());
	}
}
