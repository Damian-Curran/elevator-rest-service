package com.example.demo.tests.building;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.building.Building;
import com.example.demo.building.BuildingRepository;

@RunWith(SpringRunner.class)
@SpringBootTest 
public class BuildingRepositoryTest {
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Before
	public void setupMock() {
	    MockitoAnnotations.initMocks(this);   
	 }
	
	@Test
	public void testInsertSucceeds(){   
		Building building =  new Building();
		building.setName("test3");
		building.setLocation("Clare");
		Building savedBuilding = buildingRepository.save(building);  
		assertThat(building).isEqualTo(savedBuilding);	
	} 
	  
	@Test
	public void testFindSucceeds(){   
		Building building =  new Building();
		building.setName("test4");
		building.setLocation("Donegal");
		buildingRepository.save(building); 
	    Building foundBuilding =  buildingRepository.findOneByName("test4");
		assertThat(building.getName()).isEqualTo(foundBuilding.getName()); 	
	} 
	
	@Test(expected = Exception.class)
	public void testDeleteSucceeds(){   
		Building building =  new Building();
		building.setName("test5");
		building.setLocation("Limerick");
		buildingRepository.save(building); 
	    buildingRepository.deleteByName("test5");
	    Optional<Building> deletedBuilding = buildingRepository.findById(building.getId());
		assertThat(deletedBuilding).isNull();
	} 
}
