package com.springredisexample.repos;

import com.springredisexample.model.CustomerAccount;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CustomerAccountRepo {

    void save(CustomerAccount customerAccount);

    Map<String, CustomerAccount> findAll();

    CustomerAccount findById(String id);

    void update(CustomerAccount user);

    void delete(String id);
}
