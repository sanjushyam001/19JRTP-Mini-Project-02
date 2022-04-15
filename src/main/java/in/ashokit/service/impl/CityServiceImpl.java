package in.ashokit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.City;
import in.ashokit.entity.Country;
import in.ashokit.repository.CityRepository;
import in.ashokit.repository.CountryRepository;
import in.ashokit.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Override
	public boolean saveCity(City city) {
		
		return cityRepo.save(city)==null?false:true;
	}

	@Override
	public List<City> getAllCitiesByStateId(Integer stateId) {
		
		
		return cityRepo.findAllCitiesByStateId(stateId);
	}
	

}
