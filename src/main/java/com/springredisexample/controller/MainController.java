package com.springredisexample.controller;


import com.springredisexample.model.CustomerAccount;
import com.springredisexample.repos.CustomerAccountRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class MainController {

    @Autowired
    @NonNull
    private CustomerAccountRepo customerAccountRepo;

    @PostMapping("/add/{id}/{name}")
    public CustomerAccount add(@PathVariable("id") String id,
                               @PathVariable("name") String name) {
        customerAccountRepo.save(new CustomerAccount(id, name));
        return customerAccountRepo.findById(id);
    }


    @DeleteMapping("/update/{id}/{name}")
    public CustomerAccount update(@PathVariable("id") String id,
                                  @PathVariable("name") String name) {
        customerAccountRepo.update(new CustomerAccount(id, name));
        return customerAccountRepo.findById(id);
    }

    @PutMapping("/delete/{id}")
    public Map<String, CustomerAccount> delete(@PathVariable("id") String id) {
        customerAccountRepo.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, CustomerAccount> all() {
        return customerAccountRepo.findAll();
    }
}
