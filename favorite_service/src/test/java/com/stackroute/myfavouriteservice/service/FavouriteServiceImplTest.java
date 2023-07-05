package com.stackroute.myfavouriteservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.stackroute.myfavouriteservice.exception.CountryAlreadyExistsException;
import com.stackroute.myfavouriteservice.exception.CountryNotFoundException;
import com.stackroute.myfavouriteservice.model.Covid;
import com.stackroute.myfavouriteservice.model.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class FavouriteServiceImplTest {

	 private User user;
	    private Covid covid, covid1;
	    List<Covid> list;

	    @BeforeEach
	    public void setUp() {
	        user = new User();
	        covid = new Covid();
	        covid.setCountry("india");
	        covid.setRecovered("172817281");
	        covid.setDeceased("6677777");
	        covid.setInfected("88999");
	        user.setUsername("charan");
	        list = new ArrayList<>();
	        list.add(covid);
	        user.setCountryList(list);
	    }

	    @AfterEach
	    public void tearDown() {
	        covid = null;
	        user = null;
	    }

	    @Test
	    public void testSaveWatchListForUser() throws CountryAlreadyExistsException {
	    	FavouriteServiceImpl service = mock(FavouriteServiceImpl.class);
	        when(service.saveCountryToFavorite(covid, "charan")).thenReturn(user);
	        User dummy = service.saveCountryToFavorite(covid, "charan");
	        assertNotNull(dummy);
	    }

	    @Test
	    public void testViewWatchListForUser() throws Exception {
	    	FavouriteServiceImpl service = mock(FavouriteServiceImpl.class);
	        covid1 = new Covid();
	        covid1.setCountry("USA");
	        covid1.setRecovered("172817281");
	        covid1.setDeceased("6677777");
	        covid1.setInfected("88999");
	        list.add(covid);
	        user.setCountryList(list);
	        when(service.getCountryList("charan")).thenReturn(list);
	        List<Covid> list1 = service.getCountryList("charan");
	        assertNotNull(list1);
	        assertEquals(list1.size(), list.size());

	    }

	    @Test
	    public void testDeleteWatchListForUser() throws CountryNotFoundException {
	    	FavouriteServiceImpl service = mock(FavouriteServiceImpl.class);
	        when(service.deleteCountryFromFavorite("india", "charan")).thenReturn(null);
	        User dummy = service.deleteCountryFromFavorite("india", "charan");
	        assertNull(dummy);

	    }

}
