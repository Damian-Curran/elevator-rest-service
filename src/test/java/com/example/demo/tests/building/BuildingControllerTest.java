package com.example.demo.tests.building;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.model.Building;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingControllerTest {

	private MockMvc mockMvc; 
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setupMock() {
	    MockitoAnnotations.initMocks(this); 
	    this.mockMvc = webAppContextSetup(webApplicationContext).build();
	 } 
	
	@Test
	public void verifyIfAddBuildingSucceeds() throws Exception 
	{
		Building building = new Building();
		building.setName("test1");
		building.setLocation("Galway");
		building.setElevators(null);
		
		this.mockMvc.perform( MockMvcRequestBuilders
	      .post("/building/add")
	      .content(asJsonString(building))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON));
		
		 //some assertions to to be implemented here
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
