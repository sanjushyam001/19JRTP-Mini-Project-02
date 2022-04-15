package in.ashokit.service;

import in.ashokit.entity.User;

public interface UserService {

	public boolean saveUser(User use);
	public boolean isDuplicateEmailAddress(String email);
	
}
