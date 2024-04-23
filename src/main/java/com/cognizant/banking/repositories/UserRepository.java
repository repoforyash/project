package com.cognizant.banking.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.banking.entities.Users;

@Repository
public interface UserRepository extends CrudRepository<Users,String>{

}
