package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Country;

public interface CountryService {

	public boolean saveCountry(Country country);
	public List<Country> getAllCountries();
}
