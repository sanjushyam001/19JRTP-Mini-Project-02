package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.City;
import in.ashokit.entity.Country;

public interface CityService {

	public boolean saveCity(City city);
	public List<City> getAllCitiesByStateId(Integer stateId);
	
}
