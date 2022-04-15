package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.State;

public interface StateRepository extends JpaRepository<State, Integer> {

	
	@Query("SELECT s FROM State s WHERE s.countryId=?1")
	public List<State> findStatesByCountryById(Integer countryId);
	
}
