package tn.esprit.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.demo.service.IReclamationService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ReclamationServiceTests {
	
	@Autowired
	IReclamationService reclamationService;
	
	@Test
	public void retrieveAllUsersTest() {
		reclamationService.retrieveAllReclamations();	
	}

}
