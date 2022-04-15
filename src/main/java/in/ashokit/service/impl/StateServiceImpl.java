package in.ashokit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.State;
import in.ashokit.repository.StateRepository;
import in.ashokit.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepo;
	
	@Override
	public boolean saveState(State state) {
		
		return stateRepo.save(state)==null?false:true;
	}
	@Override
	public List<State> getStatesByCountryId(Integer countryId) {
		
		return stateRepo.findStatesByCountryById(countryId);
	}

}
