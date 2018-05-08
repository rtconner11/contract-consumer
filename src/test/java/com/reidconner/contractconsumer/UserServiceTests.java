package com.reidconner.contractconsumer;

import com.reidconner.contractconsumer.model.User;
import com.reidconner.contractconsumer.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.reidconner:contract-producer:+:stubs:6565")
public class UserServiceTests {

	@Autowired
	private UserService userService;

	@Test
	public void shouldReturnUserById() {
		final String id = "33";

		User user = userService.getUserById(id);

		assertNotNull(user);
		assertEquals(id, user.getId());
		assertEquals("Joe", user.getName());
	}

}
