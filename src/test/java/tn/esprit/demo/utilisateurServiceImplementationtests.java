package tn.esprit.demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.demo.service.utilisateurServiceImplementation;



@RunWith(SpringRunner.class)
@SpringBootTest
public class utilisateurServiceImplementationtests {

	public utilisateurServiceImplementationtests() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	 utilisateurServiceImplementation userser;
	
	@Test
	public void findAllusersTest() {
		userser.findAllusers();	
		
	}
	
	
}
