package com.stackroute.myfavouriteservice.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.myfavouriteservice.MyfavouriteserviceApplication;
import com.stackroute.myfavouriteservice.model.Covid;
import com.stackroute.myfavouriteservice.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
 	classes = MyfavouriteserviceApplication.class
 )
 @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 @AutoConfigureMockMvc
class FavouriteControllerTest {

	 private Covid covid;
	    private User user;
	    private List<Covid> covids;

	    @Autowired
	    private MockMvc mockMvc;

	    @Autowired
	    private ObjectMapper mapper;



//	    @BeforeEach
//	    public void setUp() {
//
//	        job1 = new Job("2211", "java Full stack", "Hyderabad", "Developer", "Wipro","www.wipro.com");
//	        jobs = new ArrayList<>();
//	        jobs.add(job1);
//	        user = new User("abcd",jobs);
//			
//	    }
//
//	    @AfterEach
//	    public void tearDown() {
//	        job1 = null;
//	    }
//
//	    @Test
//		@Order(1)
//	    public void givenJobDetailsWhenCreatedThenReturnSuccessCode() throws Exception {
//	        //when(service.saveJobToWishlist(job1,"siva")).thenReturn(user);
//
//	        MvcResult mvcResult = mockMvc.perform(post("/wishlist/abcd")
//	                        .contentType(MediaType.APPLICATION_JSON)
//	                        .content(mapper.writeValueAsString(job1)))
//	                .andExpect(status().isCreated())
//	                .andReturn();   
//
//	        assertThat(mapper.readValue(mvcResult.getResponse().getContentAsString(), User.class))
//	                .usingRecursiveComparison().isEqualTo(user);
//	    }
//
//	    @Test
//		@Order(2)
//	    public void givenExistingJobDetailsWhenCreatedThenReturnConflictCode() throws Exception {
//
//	        mockMvc.perform(post("/wishlist/abcd")
//	                        .contentType(MediaType.APPLICATION_JSON)
//	                        .content(mapper.writeValueAsString(job1)))
//	                .andExpect(status().isConflict());
//	    }
//
//
//	@Test
//		@Order(3)
//	    public void getJobsThenReturnSuccessCode() throws Exception {
//
//	        MvcResult mvcResult = mockMvc.perform(get("/wishlist/abcd"))
//	                .andExpect(status().is2xxSuccessful())
//	                .andReturn();   
//	        assertThat(mapper.readValue(mvcResult.getResponse().getContentAsString(), List.class))
//			.hasSize(1);
//	    }
//
//
//
//		@Test
//		@Order(4)
//	    public void givenJobDetailsWhenDeletedThenReturnSuccessCode() throws Exception {
//
//	        MvcResult mvcResult = mockMvc.perform(delete("/wishlist/abcd/2211"))
//	                .andExpect(status().is2xxSuccessful())
//	                .andReturn();   
//	        user.getJobList().clear();
//	        assertThat(mapper.readValue(mvcResult.getResponse().getContentAsString(), User.class))
//	                .usingRecursiveComparison().isEqualTo(user);
//	    }
//
//
//
//
//
//
//
//	    
	}
