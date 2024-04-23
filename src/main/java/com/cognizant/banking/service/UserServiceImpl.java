package com.cognizant.banking.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.banking.entities.Users;
import com.cognizant.banking.dto.UserDTO;
import com.cognizant.banking.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Users> listOfUsers() {
		return (List<Users>) userRepository.findAll();
	}
	

	@Override
	public UserDTO authenticateUser(String username, String password) {
		List<Users> users= listOfUsers();
		UserDTO userModel=new UserDTO();
		for(Users user:users) {
			if(user.getUserName().equals(username) && user.getPassword().equals(password) && !user.isAccountLocked()) {
				userModel.setUserName(user.getUserName());
				userModel.setPassword(user.getPassword());
				userModel.setRole(user.getRole());
				userModel.setAccountLocked(user.isAccountLocked());
				break;
			}
		}
		return userModel;
	}

	
	
}
