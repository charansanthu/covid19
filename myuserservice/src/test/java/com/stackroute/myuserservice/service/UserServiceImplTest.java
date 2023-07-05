package com.stackroute.myuserservice.service;
import java.util.Optional;
import com.stackroute.myuserservice.exception.PasswordMisMatchException;
import com.stackroute.myuserservice.exception.UserAlreadyExistsException;
import com.stackroute.myuserservice.exception.UserNotFoundException;
import com.stackroute.myuserservice.model.ChangePassword;
import com.stackroute.myuserservice.model.User;
import com.stackroute.myuserservice.repository.UserRepository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;
	private User user;
	private ChangePassword changepassword;
	Optional<User> optional;
	Optional<ChangePassword> optional1;
	@InjectMocks
	UserServiceImpl userServiceImpl;
	@BeforeEach
	public void setup() throws Exception{
		MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUsername("charan");
        user.setPassword("password");
        user.setEmail("charansanthu4@gmail.com");
        optional = Optional.of(user);
        changepassword = new ChangePassword();
        changepassword.setOldpassword("password");
        changepassword.setNewpassword("password@123");
        optional1 = Optional.of(changepassword);
	}
	 @AfterEach
    public void tearDown() throws Exception {
	 userRepository.deleteAll();
    }
	@Test
	void UserRegister() throws UserAlreadyExistsException{
		 Mockito.when(userRepository.save(user)).thenReturn(user);
         assertEquals(true, userServiceImpl.registerUser(user)!=null);
	}	
	
	@Test
	void ExistsUserRegistration() {
		Mockito.when(userRepository.findByUsername("charan")).thenReturn(optional);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertThrows(UserAlreadyExistsException.class, 
        		()->userServiceImpl.registerUser(user));
	}

	@Test
	void ExistLoginUser() throws UserNotFoundException {
		 Mockito.when(userRepository.findByUsernameAndPassword("charan", "password")).thenReturn(user);
	     User fetchedUser = userServiceImpl.validateUser("charan", "password");
	     assertEquals("charan", fetchedUser.getUsername());
	}
	
	@Test
	void LoginNotExistUser(){
		//Mockito.when(userRepository.findByUsername("charan")).thenReturn(optional);
		Mockito.when(userRepository.save(user)).thenReturn(user);
        assertThrows(UserNotFoundException.class, 
        		()->userServiceImpl.validateUser("charan","password"));
	}
	
	@Test
	void UpdatePassword() throws PasswordMisMatchException{;
		Mockito.when(userRepository.findByUsername("charan")).thenReturn(optional);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User fetcheduser = userServiceImpl.updatePassword(changepassword, user.getUsername()); 
		assertEquals("password@123", fetcheduser.getPassword());
	}
//	@Test
//	void UpdateMissmatchPassword() {
//		Mockito.when(userRepository.findByUsername("charan")).thenReturn(optional);
//		Mockito.when(userRepository.save(user)).thenReturn(user);
//		//User fetcheduser = userServiceImpl.updatePassword(changepassword1, user.getPassword());
//		//System.out.println(user.getPassword()+" "+changepassword.getOldpassword());
//        assertThrows(PasswordMisMatchException.class, 
//        		()->userServiceImpl.updatePassword(changepassword1,user.getPassword()));
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}