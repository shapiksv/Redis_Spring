package com.springredisexample.service;

import com.springredisexample.model.CustomerAccount;
import com.springredisexample.repos.CustomerAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerAccountService {


    @Autowired
    private CustomerAccountRepo customerAccountRepo ;


    public CustomerAccount save(CustomerAccount customerAccount) {
        return customerAccountRepo.save(customerAccount);
    }

    public Iterable<CustomerAccount> findAll() {
        return customerAccountRepo.findAll();
    }

    public Optional<CustomerAccount> findById(String id) {
        return  customerAccountRepo.findById(id);
    }

    public void update(CustomerAccount customerAccount) {
        customerAccountRepo.save(customerAccount);
    }

    public void delete(String id) {
        customerAccountRepo.deleteById(id);
    }
}
