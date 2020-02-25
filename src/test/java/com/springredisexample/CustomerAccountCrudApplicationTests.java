package com.springredisexample;

import com.springredisexample.model.CustomerAccount;
import com.springredisexample.service.CustomerAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		boolean result= customerAccountRepo.findById("25").isPresent();
		assertTrue(result);
		customerAccountRepo.delete("25");
	}

	@Test
	public void findAllCustomers() {
		Iterable<CustomerAccount>  findAllTest = customerAccountRepo.findAll();
		assertNotNull(findAllTest);
	}

	@Test
	public void updateCustomer() {
		customerAccountRepo.update(new CustomerAccount("25", "Yaroslav"));
		boolean result= customerAccountRepo.findById("25").isPresent();
		assertTrue(result);
		customerAccountRepo.delete("25");
	}

	@Test
	public void deleteCustomer() {
		customerAccountRepo.update(new CustomerAccount("25", "Yaroslav"));
		customerAccountRepo.delete("25");
		boolean result= customerAccountRepo.findById("25").isPresent();
		assertTrue(!result);

	}


}
