package com.cognizant.banking.dto;

import lombok.Data;

@Data
public class UserDTO {

	private String userName;
	private String password;
	private String role;
	private boolean isAccountLocked;

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", password=" + password + ", role=" + role + ", isAccountLocked="
				+ isAccountLocked + "]";
	}
	
	
}

