package com.example.demo.tests.building;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.building.Building;
import com.example.demo.building.BuildingService;

@RunWith(SpringRunner.class)
@SpringBootTest 
public class BuildingServiceTest {
	@Autowired
	private BuildingService buildingService;  
	
	@Before
	public void setupMock() {
	    MockitoAnnotations.initMocks(this);	    
	 }
     
	@Test
	public void testBuildingsRetrieveSucceeds(){  		
		Building building =  new Building("test2","Cork",null);
	    buildingService.add(building);	
	    List<Building> buildings = buildingService.getAll();
		assertThat(buildings.size()).isPositive();
	} 
}
