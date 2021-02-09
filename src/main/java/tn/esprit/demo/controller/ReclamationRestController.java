package tn.esprit.demo.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.demo.entities.Reclamation;

import tn.esprit.demo.service.IReclamationService;

@RestController
public class ReclamationRestController {
	
	@Autowired
	IReclamationService reclamationService;
	
	// http://localhost:8090/bookstore/servlet/retrieve-all-reclamations
	@GetMapping("/retrieve-all-reclamations")
	@ResponseBody
	public List<Reclamation> getAllReclamations(){
	return reclamationService.retrieveAllReclamations();
	}
	/*
	 * "titre":"rec1",
    "description":"desc",
    "date":"2021-02-08",
    "user":1
	 */
	//http://localhost:8090/bookstore/servlet/add-reclamation
	@PostMapping("/add-reclamation")
	@ResponseBody
	public Reclamation addReclamation (@RequestBody Reclamation r) {
	return reclamationService.addReclamation(r) ;	
	}
	
	// http://localhost:8090/bookstore/servlet/deleteReclamation/{reclamation-id}
    @DeleteMapping("/deleteReclamation/{reclamation-id}")
	public void deletereclamation (@PathVariable("reclamation-id")String reclamationId ) {
	reclamationService.deleteReclamation(reclamationId);
	}
    
    //http://localhost:8090/bookstore/servlet/update-reclamation
 	@PutMapping("/update-reclamation")
 	@ResponseBody
 	public Reclamation updateReclamation (@RequestBody Reclamation r) {
 	return reclamationService.updateReclamation(r);	
 	}
	
	// http://localhost:8090/bookstore/servlet/retrieve-reclamation/{reclamation-id}
	@GetMapping("/retrieve-reclamation/{reclamation-id}")
	@ResponseBody
	public Reclamation retrieveReclamation (@PathVariable("reclamation-id")String reclamationId ) {	
	return reclamationService.retrieveReclamation(reclamationId);
	}
	
	// http://localhost:8090/bookstore/servlet/retrieve-reclamationByUser/{user-id}
	@GetMapping("/retrieve-reclamationByUser/{user-id}")
	@ResponseBody
	public List<Reclamation> retrieveReclamationByUser (@PathVariable("user-id")String userId ) {	
	return reclamationService.findReclamationByUser(userId);
	}
	
	// http://localhost:8090/bookstore/servlet/retrieve-reclamationByDate/{date}
    @GetMapping("/retrieve-reclamationByDate/{date}")
	@ResponseBody
	public List<Reclamation> retrieveReclamationByDate (@PathVariable("date")String date ) throws ParseException {
	return reclamationService.findReclamationByDate(date);
	}
    
    // http://localhost:8090/bookstore/servlet/retrieve-reclamationByDateBetween/{date1}/{date2}
    @GetMapping("/retrieve-reclamationByDateBetween/{date1}/{date2}")
	@ResponseBody
	public List<Reclamation> retrieveReclamationByDateBetween (@PathVariable("date1")String date1,@PathVariable("date2")String date2 ) throws ParseException {
	return reclamationService.findReclamationByDateBetween(date1, date2);
	}
    
    // http://localhost:8090/bookstore/servlet/retrieve-reclamationByTitleContaining/{txt}
    @GetMapping("/retrieve-reclamationByTitleContaining/{txt}")
	@ResponseBody
	public List<Reclamation> retrieveReclamationByTitleContaining (@PathVariable("txt")String txt){
	return reclamationService.findReclamationByTitleContaining(txt);
	}
    
    // http://localhost:8090/bookstore/servlet/retrieve-reclamationByUserNameContaining/{txt}
    @GetMapping("/retrieve-reclamationByUserNameContaining/{txt}")
	@ResponseBody
	public List<Reclamation> retrieveReclamationByUserNameContaining (@PathVariable("txt")String txt){
	return reclamationService.findReclamationByUserNameLike(txt);
	}
    
    // http://localhost:8090/bookstore/servlet/deleteReclamationByUserId/{user-id}
    @DeleteMapping("/deleteReclamationByUserId/{user-id}")
    @ResponseBody
	public List<Reclamation> deleteReclamationByUserId (@PathVariable("user-id")String userId ) {
    return reclamationService.deleteReclamationByUser(userId);
	}
    
    // http://localhost:8090/bookstore/servlet/retrieve-all-reclamationsLimit
 	@GetMapping("/retrieve-all-reclamationsLimit")
 	@ResponseBody
 	public List<Reclamation> getAllReclamationsLimit(){	
 	return reclamationService.retrieveAllReclamationsLimit3();	
 	}
 	
 	// http://localhost:8090/bookstore/servlet/retrieve-reclamationByUserLimit/{user-id}
 	@GetMapping("/retrieve-reclamationByUserLimit/{user-id}")
 	@ResponseBody
 	public List<Reclamation> retrieveReclamationByUserLimit (@PathVariable("user-id")String userId ) {
 	return reclamationService.findReclamationByUserLimit(userId);	
 	}
 	   
 	// http://localhost:8090/bookstore/servlet/retrieve-countReclamation
	@GetMapping("/retrieve-countReclamation")	
	public String countReclamation (){	
	return "Total Number of Reclamation="+reclamationService.countReclamation();	
	}
	
	// http://localhost:8090/bookstore/servlet/retrieve-countReclamationByUser/{user-id}
	@GetMapping("/retrieve-countReclamationByUser/{user-id}")	
	public String countReclamationByUser (@PathVariable("user-id")String userId){	
	return "Number of Reclamation of User Id="+userId+" is\n"+reclamationService.countReclamationByUser(userId);
	
	}
	// http://localhost:8090/bookstore/servlet/retrieve-all-usersReclamationLastNames
	@GetMapping("/retrieve-all-usersReclamationLastNames")
	@ResponseBody
	public List<String> usersReclamationNames(){
	return reclamationService.usersReclamationLastNames();
		
	}
	

}