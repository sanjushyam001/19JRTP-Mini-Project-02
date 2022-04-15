package in.ashokit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;
import in.ashokit.service.EmailService;
import in.ashokit.service.ForgotPasswordUserRequestService;

@Service
public class ForgotPasswordUserRequestServiceImpl implements ForgotPasswordUserRequestService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmailService emailService;
	
	
	User user=null;
	private boolean isUserValid(String userEmail) {
		
		user = userRepo.findUserByEmail(userEmail);
		
		return user==null?false:true;
	}


	@Override
	public boolean sendPasswordToEmail(String uEmail) {
		boolean result=false;
		if(isUserValid(uEmail)) {
			String body="Congratulations! your password successfully recovered\n";
			body+="Your new password is : "+user.getPassword();
			
			result = emailService.sendEmail(uEmail, "Password Recovered", body);
		}
		return result;
		
	}
	


}
