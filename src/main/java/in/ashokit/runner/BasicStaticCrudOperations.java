package in.ashokit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.City;
import in.ashokit.entity.Country;
import in.ashokit.entity.State;
import in.ashokit.service.CityService;
import in.ashokit.service.CountryService;
import in.ashokit.service.StateService;
//@Component
public class BasicStaticCrudOperations implements CommandLineRunner {

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@Override
	public void run(String... args) throws Exception {
		//#1. Save Country
		
		countryService.saveCountry(new Country("IND", "India"));
		countryService.saveCountry(new Country("AUS", "Australia"));
		
		//#2. Save State
		
		stateService.saveState(new State("Uttar Pradesh", 1));
		stateService.saveState(new State("Bihar", 1));
		stateService.saveState(new State("Queensland", 2));
		stateService.saveState(new State("South Australia", 2));
		
		//#4 Save City
		
		//UP
		cityService.saveCity(new City("Noida", 3));
		cityService.saveCity(new City("Moradabad", 3));
		
		//Bihar 
		cityService.saveCity(new City("Patna", 4));
		cityService.saveCity(new City("Baliya", 4));
		
		//Queensland
		cityService.saveCity(new City("Brisbane", 5));
		cityService.saveCity(new City("Mackay", 5));
		
		//South Australia
		cityService.saveCity(new City("Coober Pedy", 6));
		cityService.saveCity(new City("Whyalla", 6));
		
		
		
		
		
		

	}

	
}
