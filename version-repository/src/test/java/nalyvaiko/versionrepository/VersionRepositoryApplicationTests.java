package nalyvaiko.versionrepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import nalyvaiko.versionrepository.controller.VersionController;

@SpringBootTest
class VersionRepositoryApplicationTests {
	
	@Autowired
	private VersionController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
