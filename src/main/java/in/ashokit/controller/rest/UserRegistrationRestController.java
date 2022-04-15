package in.ashokit.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.constants.AppConstants;
import in.ashokit.entity.City;
import in.ashokit.entity.Country;
import in.ashokit.entity.State;
import in.ashokit.entity.User;
import in.ashokit.props.AppProperties;
import in.ashokit.service.CityService;
import in.ashokit.service.CountryService;
import in.ashokit.service.EmailService;
import in.ashokit.service.StateService;
import in.ashokit.service.UserService;



@RestController
@RequestMapping("user-management")
@CrossOrigin("*")
public class UserRegistrationRestController {

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AppProperties appProps;
	
	@Autowired
	private EmailService emailService;
	
	//#1.get all countries
	
	@GetMapping("/countries")
	public ResponseEntity<?> getAllCountries(){
		
		Map<String, String> messages = appProps.getMessages();
		
		ResponseEntity<?> resp=null;
		List<Country> list=countryService.getAllCountries();
		if(list.isEmpty()||list==null) {
			resp=new ResponseEntity<String>(messages.get(AppConstants.USER_SAVE_SUCC),HttpStatus.NOT_FOUND);
		}else {
			resp=new ResponseEntity<List<Country>>(list,HttpStatus.OK);
		}
		return resp;
	}
	
	
	//#2.get all states by country id
	
	@GetMapping("/states/{countryId}")
	public ResponseEntity<?> getAllStatesByCountryId(@PathVariable Integer countryId){

		Map<String, String> messages = appProps.getMessages();
		ResponseEntity<?> resp=null;
		List<State> states=stateService.getStatesByCountryId(countryId);
		if(states.isEmpty()||states==null) {
			resp=new ResponseEntity<String>(messages.get(AppConstants.DATA_NOT_FOUND),HttpStatus.NOT_FOUND);
		}else {
			resp=new ResponseEntity<List<State>>(states,HttpStatus.OK);
		}
		return resp;
	}
	
	//#4. get all cities by state id
	@GetMapping("/cities/{stateId}")
	public ResponseEntity<?> getAllCitiesByStateId(@PathVariable Integer stateId){
		
		ResponseEntity<?> resp=null;
		
		List<City> cities=cityService.getAllCitiesByStateId(stateId);
		if(cities.isEmpty()||cities==null) {
			resp=new ResponseEntity<String>("No Data Found",HttpStatus.NOT_FOUND);
		}else {
			resp=new ResponseEntity<List<City>>(cities,HttpStatus.OK);
		}
		return resp;
	}
	
	//# checking email is already registered ?
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> isDuplicateEmailAddress(@PathVariable String email){
		Map<String, String> messages = appProps.getMessages();
		
		ResponseEntity<?> resp=null;
		boolean result = userService.isDuplicateEmailAddress(email);
		String status=result ? messages.get(AppConstants.EMAIL_DUPLICATE):messages.get(AppConstants.EMAIL_UNIQUE);
		resp=new ResponseEntity<String>(status,HttpStatus.OK);
		return resp;
		
	}
	
	//# save User
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody User user){
	
		Map<String, String> messages = appProps.getMessages();
		
		ResponseEntity<?> resp=null;
		String status = userService.saveUser(user)?messages.get(AppConstants.USER_SAVE_SUCC):messages.get(AppConstants.USER_SAVE_FAIL);
		
		return new ResponseEntity<String>(status,HttpStatus.OK);
		//Integer userId=userService.saveUser(user);
		//return new ResponseEntity<Integer>(userId,HttpStatus.OK);
	}
	
}
