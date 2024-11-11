package com.bms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bms.dto.UserDto;
import com.bms.exception.DuplicateRecordException;
import com.bms.repository.UserRepository;
import com.bms.service.UserService;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testAddUser() {

		deleteUser();

		String name = "Test";
		String mobile = "124";

		UserDto userDto = UserDto.builder().name(name).mobile(mobile).build();

		userDto = userService.addUser(userDto);

		assertTrue(Objects.nonNull(userDto));
        assertEquals(userDto.getName(), name);
        assertEquals(userDto.getMobile(), mobile);

		userRepository.deleteById(userDto.getId());
	}

	@Test(expected = DuplicateRecordException.class)
	public void testAddDuplicateUser() {

		deleteUser();

		String name = "Test";
		String mobile = "124";

		UserDto userDto = UserDto.builder().name(name).mobile(mobile).build();

		userDto = userService.addUser(userDto);

		assertTrue(Objects.nonNull(userDto));
        assertEquals(userDto.getName(), name);
        assertEquals(userDto.getMobile(), mobile);

		userService.addUser(userDto);

	}

	@Test
	public void testGetUser() {

		deleteUser();

		String name = "Test";
		String mobile = "124";

		UserDto userDto = UserDto.builder().name(name).mobile(mobile).build();

		userDto = userService.addUser(userDto);

		userDto = userService.getUser(userDto.getId());

		assertTrue(Objects.nonNull(userDto));
        assertEquals(userDto.getName(), name);
        assertEquals(userDto.getMobile(), mobile);

		userRepository.deleteById(userDto.getId());

	}

	@Test(expected = EntityNotFoundException.class)
	public void testGetNonExistentUser() {
		userService.getUser(-1);
	}

	private void deleteUser() {
		userRepository.deleteByMobile("124");
	}
}