package com.springredisexample.service;

import com.springredisexample.model.CustomerAccount;
import com.springredisexample.repos.CustomerAccountRepo;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

//@Repository
@Service
public class CustomerAccountService implements CustomerAccountRepo {

    private final String key = "customer_account";
    private RedisTemplate<String, CustomerAccount> redisTemplate;
    private HashOperations hashOperations;


    public CustomerAccountService(RedisTemplate<String, CustomerAccount> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(CustomerAccount customerAccount) {
        hashOperations.put(key, customerAccount.getId(), customerAccount);
    }

    @Override
    public Map<String, CustomerAccount> findAll() {
        return hashOperations.entries(key);
    }

    @Override
    public CustomerAccount findById(String id) {
        return (CustomerAccount)hashOperations.get(key, id);
    }

    @Override
    public void update(CustomerAccount customerAccount) {
        save(customerAccount);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(key, id);
    }
}
