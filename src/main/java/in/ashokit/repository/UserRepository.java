package in.ashokit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.email=?1")
	public User findUserByEmail(String email);
	
	
	@Query("SELECT u FROM User u WHERE u.email = ?1 and u.password = ?2") 
	public User findUserByEmailandPaswd(String userEmail,String userPaswd);
	
	/*
	 * @Query("SELECT u.status FROM User u WHERE u.email=?1") public String
	 * userStatus(String userEmail);
	 */
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE User u SET u.password = ?1,u.status=?2 where u.email = ?3")
	 * public void setNewPasswordAndStatus(String newUserPaswd,String
	 * userStatus,String userEmail);
	 */
	
	
}
