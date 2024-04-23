package com.cognizant.banking.dto;


import java.util.Objects;
import lombok.Data;

@Data
public class UserRequest {
	
	private String userName;
	private String password;
	
	@Override
	public int hashCode() {
		return Objects.hash(password, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRequest other = (UserRequest) obj;
		return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "UserRequest [userName=" + userName + ", password=" + password + "]";
	}
	

}
