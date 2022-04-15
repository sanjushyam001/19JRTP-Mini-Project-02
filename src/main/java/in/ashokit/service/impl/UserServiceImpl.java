package in.ashokit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;
import in.ashokit.service.EmailService;
import in.ashokit.service.UserService;
import in.ashokit.utils.email.EmailUtils;
import in.ashokit.utils.password.PasswordUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public boolean saveUser(User user) {
		user.setStatus("n");
		String generatePassword=  PasswordUtils.generatePassword();
		user.setPassword(generatePassword);
		
		
		
		//---------------------------------
		boolean result= userRepo.save(user)==null?false:true;
		//Integer id = userRepo.save(user).getId();
		if(result) {
			
			//# default password sending to user
			String toEmail=user.getEmail();
			String subject=emailUtils.getSubject();
			String body=emailUtils.formatWelcomeEmail(user.getFname(),user.getLname(),generatePassword,toEmail);
					
			
			emailService.sendEmail(toEmail, subject, body);
		}
		return result;
	}

	@Override
	public boolean isDuplicateEmailAddress(String email) {
		
		return userRepo.findUserByEmail(email)==null?false:true;
	}

}
