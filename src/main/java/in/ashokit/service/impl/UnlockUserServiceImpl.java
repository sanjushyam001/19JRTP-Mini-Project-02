package in.ashokit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.UnLockUserRequest;
import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;
import in.ashokit.service.UnlockUserService;

@Service
public class UnlockUserServiceImpl implements UnlockUserService {

	@Autowired
	private UserRepository userRepo;
	
	
	 User user=null;
	
	private boolean isTempPaswdMatched(String userEmail,String userTempPaswd) {
		
		 user= userRepo.findUserByEmailandPaswd(userEmail,userTempPaswd);
		 System.out.println("USER >> "+user);
		//return userRepo.findUserByIdandPaswd(userId,userTempPaswd)==null?false:true;
		 return user==null?false:true;
	}

	@Override
	public String setNewUserPaswd(String userTempPaswd,String userNewPaswd,String userEmail) {
		String mesg="";
		
		if(isTempPaswdMatched(userEmail,userTempPaswd)) {
			user.setStatus("y");
			user.setPassword(userNewPaswd);
			userRepo.save(user);
			//userRepo.setNewPasswordAndStatus(userNewPaswd,userStatus,userEmail);
			mesg="User verified successfully";
		}else {
			mesg="Temproray password not matched";
		}
		return mesg;
	}

}
