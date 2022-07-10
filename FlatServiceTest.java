package com.cg.ofr.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.ofr.dto.FlatDto;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;
import com.cg.ofr.serviceimpl.FlatService;
@SpringBootTest
class FlatServiceTest {

	@Mock
	private IFlatRepository flatRepository;
	
	
	@InjectMocks
	FlatService flatService=new FlatService();
	static Flat flat=new Flat();
	static FlatDto flatDto;
	static List<Flat>flatList;
	static List<Flat>flatList1;
	static List<FlatDto>flatDtoList;

	@BeforeAll
	public static void setUp() {
		flatList=new ArrayList<>();
		flatList1=new ArrayList<>();
        flatDtoList=new ArrayList<>();
		flatDto=new FlatDto();
		 flat.setAvailability("available");
		flat.setCost(350000.0);
		flatList.add(flat);
		BeanUtils.copyProperties(flat, flatDto);
	}

	@Test
	 void testAddFlat() {
		Mockito.when(flatRepository.saveAndFlush(flat)).thenReturn(flat);
		assertNotNull(flatService.addFlat(flatDto));	
	}
	@Test
	 void testViewAllFlat() throws FlatNotFoundException {
		Mockito.when(flatRepository.findAll()).thenReturn(flatList);
	
	assertNotNull(flatService.viewAllFlat());
	
     
	}
}
	

