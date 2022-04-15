package in.ashokit.service;



import java.util.List;

import in.ashokit.entity.State;

public interface StateService {

	public boolean saveState(State state);
	public List<State> getStatesByCountryId(Integer countryId);
}
