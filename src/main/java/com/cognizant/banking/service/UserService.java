package com.cognizant.banking.service;


import java.util.List;

import com.cognizant.banking.dto.UserDTO;
import com.cognizant.banking.entities.Users;

public interface UserService {

	public List<Users> listOfUsers();
	public UserDTO authenticateUser(String username,String password);

	
}
