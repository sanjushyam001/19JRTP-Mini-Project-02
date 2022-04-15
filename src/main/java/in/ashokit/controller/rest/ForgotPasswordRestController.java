package in.ashokit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.ForgotPasswordUserRequest;
import in.ashokit.service.ForgotPasswordUserRequestService;

@RestController
@RequestMapping("user-management")
@CrossOrigin("*")
public class ForgotPasswordRestController {

	@Autowired
	private ForgotPasswordUserRequestService forgotPasswordService;
	
	@PostMapping("/forgot-paswd")
	public ResponseEntity<?> forgotPaswd(@RequestBody ForgotPasswordUserRequest reqst){
		boolean status= forgotPasswordService.sendPasswordToEmail(reqst.getUserEmail());
		String mesg= status?"Password sent to your registered email":"Invalid email,Please enter your registered email ";
		return new ResponseEntity<String>(mesg,HttpStatus.OK);
	}
}
