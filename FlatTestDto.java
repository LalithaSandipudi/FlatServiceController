package com.cg.ofr.testdto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.dto.FlatDto;


@SpringBootTest
class FlatTestDto {
 static FlatDto flatDto; 
	
	@BeforeAll
	static void setUp() {
		flatDto=new FlatDto();
		flatDto.setAvailability("available");
		flatDto.setCost(3500000.0);
	}

	

	@Test
	 void testGetters() {
		
		assertEquals(3500000,flatDto.getCost());
		assertEquals("available",flatDto.getAvailability());
	}

}
