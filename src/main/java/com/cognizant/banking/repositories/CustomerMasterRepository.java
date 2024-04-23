package com.cognizant.banking.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.banking.entities.CustomerMaster;

@Repository
public interface CustomerMasterRepository extends CrudRepository<CustomerMaster,String> {


	Optional<CustomerMaster> findByAdharCard(int adharCard);


}