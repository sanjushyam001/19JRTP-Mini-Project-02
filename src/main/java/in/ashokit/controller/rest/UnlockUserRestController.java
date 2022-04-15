package in.ashokit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.UnLockUserRequest;
import in.ashokit.service.UnlockUserService;


@RestController
@RequestMapping("user-management")
@CrossOrigin("*")
public class UnlockUserRestController {

	@Autowired
	private UnlockUserService service;
	
	@PostMapping("/unlock-user")
	public ResponseEntity<?> unlockUser(@RequestBody UnLockUserRequest reqst){
		
		String userEmail=reqst.getUserEmail();
		System.out.println("ID: "+userEmail);
		String tempPaswd=reqst.getUserTempPaswd();
		System.out.println("TEMP: "+tempPaswd);
		String newPaswd=reqst.getUserNewPaswd();
		
		String status = service.setNewUserPaswd(tempPaswd, newPaswd, userEmail);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
}
