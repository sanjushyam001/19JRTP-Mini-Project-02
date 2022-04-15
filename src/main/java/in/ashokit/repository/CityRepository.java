package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	@Query("SELECT c FROM City c WHERE c.stateId=?1")
	public List<City> findAllCitiesByStateId(Integer stateId);
}
