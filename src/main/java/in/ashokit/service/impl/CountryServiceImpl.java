package in.ashokit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Country;
import in.ashokit.repository.CountryRepository;
import in.ashokit.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepo;
	@Override
	public boolean saveCountry(Country country) {
		
		return countryRepo.save(country)==null?false:true;
	}
	@Override
	public List<Country> getAllCountries() {
		
		return countryRepo.findAll();
	}

}
