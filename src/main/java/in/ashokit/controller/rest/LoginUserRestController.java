package in.ashokit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.LoginUserRequest;
import in.ashokit.service.LoginUserService;

@RestController
@RequestMapping("user-management")
@CrossOrigin("*")
public class LoginUserRestController {

	@Autowired
	private LoginUserService service;
	
	@PostMapping("/sign-in")
	public ResponseEntity<?> signInUser(@RequestBody LoginUserRequest reqst){
		
		ResponseEntity<?> resp=null;
		String mesg="";
		Integer statusCode =service.LoginUser(reqst.getUserEmail(), reqst.getUserPassword()); 
		if(statusCode==1)
			mesg="Logged in successfully";
		else if(statusCode==2)
			mesg="Your account is Locked";
		else
			mesg="Invalid Credentials";
	
		return resp=new ResponseEntity<String>(mesg,HttpStatus.OK);
		
		
	}
}
