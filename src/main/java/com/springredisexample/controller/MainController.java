package com.springredisexample.controller;


import com.springredisexample.model.CustomerAccount;
import com.springredisexample.service.CustomerAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private CustomerAccountService customerAccountRepo;

    @PostMapping("/create")
    public CustomerAccount create(@RequestBody CustomerAccount customerAccount) {
        return customerAccountRepo.save(customerAccount);
    }

    @PutMapping("{id}")
    public Optional<CustomerAccount> update(@PathVariable("id") String id,
                                            @RequestBody CustomerAccount customerAccount) {
        customerAccountRepo.update(customerAccount);
        return customerAccountRepo.findById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        customerAccountRepo.delete(id);
    }

    @GetMapping()
    public Iterable<CustomerAccount> all() {
        return customerAccountRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<CustomerAccount> findById(@PathVariable("id") String id){
        return customerAccountRepo.findById(id);
    }
}