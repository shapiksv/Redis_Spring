package com.springredisexample.repos;

import com.springredisexample.model.CustomerAccount;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerAccountRepo extends KeyValueRepository<CustomerAccount, String> {

}

