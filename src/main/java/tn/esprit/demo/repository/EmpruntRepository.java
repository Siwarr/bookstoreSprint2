package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Emprunt;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt,Integer>  {

	//List<Emprunt> findByUserId(User user);
		/*
		@Query("select count(*) from emprunt e where e.memberId= :memberId GROUP BY e.memberId")
		public int countEmpruntUser(@Param("memberId")Long memberId);
		
		@Query("select b.isAvail from book b where b.id= :bookId")
		public boolean getAvailabilityById(@Param("bookId") Long bookId);
		
		@Modifying
		@Query(value="insert into emprunt(memberId,bookId) VALUES (:memberId, :bookId)", nativeQuery = true)
		public void insertEmprunt(@Param("memberId") Long memberName,@Param("bookId") Long bookName);
		
		// hedhy on peut la changer nrodouha haka :
		 * Book b=new book(.....);
		 * Emprunt e=new emprunt();
		 * User u=new user(...);
		 *   e.setBook(b);
		 *   e.setUser(u);
		 *   empruntRepository.save();
		
		@Modifying
		@Query(value="UPDATE book b set b.isAvail = false where b.id= :bookId")
		public void updateBookAvail(@Param("bookId") Long bookName);
		*/
}
