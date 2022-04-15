package in.ashokit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;
import in.ashokit.service.LoginUserService;

@Service
public class LoginUserServiceImpl implements LoginUserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Integer LoginUser(String userEmail, String userPaswd) {
		
		Integer result=0;
		User user=userRepo.findUserByEmailandPaswd(userEmail, userPaswd);
		if(user!=null) {
			if(user.getStatus().equalsIgnoreCase("y")) {
				result=1;
			}else {
				result=2;
			}
		}else {
			result=0; 
			
		}
		return result;
		
	}

}
