package com.springredisexample;

import com.springredisexample.model.CustomerAccount;
import com.springredisexample.service.CustomerAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerAccountCrudApplicationTests {

	@Autowired
	private CustomerAccountService customerAccountRepo;

	@Test
	public void contexLoads() {
		assertThat(customerAccountRepo).isNotNull();

	}

	@Test
	public void CreateConnection() {
		JedisConnectionFactory con = new JedisConnectionFactory();
		con.getConnection().ping();
		con.destroy();
	}

	@Test
	public void Save() {
		CustomerAccount testCustomerAccount = new CustomerAccount("25", "Yaroslav");
		customerAccountRepo.save(testCustomerAccount);
		assertNotNull(testCustomerAccount);
		customerAccountRepo.delete("25");
	}

	@Test
	public void findCustomer() {
		CustomerAccount testCustomerAccount = new CustomerAccount("25", "Yaroslav");
		customerAccountRepo.save(testCustomerAccount);
		String name = customerAccountRepo.findById("25").getName();
		assertEquals("Yaroslav", name);
		customerAccountRepo.delete("25");
	}

	@Test
	public void findAllCustomers() {
		Map<String, CustomerAccount> findAllTest = customerAccountRepo.findAll();
		assertNotNull(findAllTest);
	}

	@Test
	public void updateCustomer() {
		customerAccountRepo.update(new CustomerAccount("25", "Yaroslav"));
		String name = customerAccountRepo.findById("25").getName();
		assertEquals("Yaroslav", name);
		customerAccountRepo.delete("25");
	}

	@Test
	public void deleteCustomer() {
		customerAccountRepo.update(new CustomerAccount("25", "Yaroslav"));
		String name = customerAccountRepo.findById("25").getName();
		customerAccountRepo.delete("25");
		try {
			customerAccountRepo.findById("25").getName();
		}catch (NullPointerException e){
			assertTrue(true);
		}

	}


}
