package tn.esprit.demo.service;



import tn.esprit.demo.entities.Utilisateur;
import tn.esprit.demo.repository.UtilisateurRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class utilisateurServiceImplementation implements utilisateurService {
	private static final Logger L=LogManager.getLogger(utilisateurServiceImplementation.class);
    @Autowired
    UtilisateurRepository UR ;
    @Autowired
    public PasswordEncoder bCryptPassowordEncoder ;
    @Override
    public boolean adduser(Utilisateur u) {
        //Encrypt Password here when adding a user
        String CryptedPassword = bCryptPassowordEncoder.encode(u.getMdp());
        u.setMdp(CryptedPassword);
        try{
            UR.save(u);
            System.out.println("Saved");
            L.info("user added !!");
            return true ;
        }catch (Exception E){
            System.out.println(E.getMessage());
            return false ;
        }
    }

    @Override
    public boolean updateUser(Utilisateur u,int id) {
		Optional<Utilisateur> v =UR.findById(id);

		if (!v.isPresent())
			
			return false ;

		u.setId(id);
		L.info("user updated !!");
		UR.save(u);
		return true;
    }
    /*@Override
	@Override
		public List<Utilisateur> retrieveAllUser() {
			
		
	}*/

	@Override
	public Optional<Utilisateur> retrieveUser(Integer id) {
		L.info("User  retrieved");
		return UR.findById(id);
	}
	
    
    @Override
    public List<Utilisateur> findAllusers() {
    	List<Utilisateur> users=(List<Utilisateur>) UR.findAll();
		for (Utilisateur us:users)
			L.info("User +++"+us.toString());
		
		return users;
        
    }

    @Override
    public boolean findById(int id) {
    	L.info("user find !!");
        return false;
    }

    @Override
    public boolean deleteuser(String  login) {

          int i= UR.deleteUser(login);
          if(i>0) {L.info("user deleted !!");
              return true;
          }else {
              return false;
          }

    }

    @Override
    public Utilisateur findbyLogin(String login) {
        if(null == UR.FindByLogin(login)){
            System.out.println("*****************User NOT found ****************");
        }
        System.out.println("*************** DAO success " + UR.FindByLogin(login).getNom()+" "+ UR.FindByLogin(login).getPrenom());
       return  UR.FindByLogin(login);
    }
}
