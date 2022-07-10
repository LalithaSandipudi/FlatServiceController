package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.dto.FlatDto;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;
@Service
public class FlatService {
	@Autowired
	
	private IFlatRepository iflatrepository;
	
	public FlatDto addFlat(FlatDto flatDto) {
		Flat flat=new Flat();
		BeanUtils.copyProperties(flatDto, flat);
		iflatrepository.save(flat);
		return flatDto;
	}
	
	
	
	public FlatDto updateFlat(Integer flatId, Double cost){
		Flat flat=new Flat();
		FlatDto flatDto=new FlatDto();
		if(!iflatrepository.existsById(flatId)) {
			throw new FlatNotFoundException();
	}
		else {
	BeanUtils.copyProperties(iflatrepository.findById(flatId),flatDto);
	 flatDto.setCost(cost);
	  BeanUtils.copyProperties(flatDto, flat);
		iflatrepository.flush();
		return flatDto;
		}
		}
	public FlatDto deleteFlat(Integer flatId) { 
		Flat flat=new Flat();
		FlatDto flatDto=new FlatDto();
		if(!iflatrepository.existsById(flatId)) {
			throw new FlatNotFoundException();
		}else
		{
			BeanUtils.copyProperties(iflatrepository.findById(flatId),flatDto);
		iflatrepository.deleteById(flatId);
		BeanUtils.copyProperties(flatDto, flat);
		 iflatrepository.flush();
		 return flatDto;
	}
	}
	 public FlatDto viewFlat(Integer flatId) {
		
	    Flat flat=new Flat();
	    FlatDto flatDto=new FlatDto();
		 iflatrepository.findById(flatId);
		 if(iflatrepository.findById(flatId).get()==null) {
		 
		 throw new FlatNotFoundException();
		 }
		 else {
		 BeanUtils.copyProperties(iflatrepository.existsById(flatId),flatDto);
		 // flatDto.findFlatId(flatId);
			 
			
		 iflatrepository.findById(flatId);
			 BeanUtils.copyProperties(flatDto, flat);
			 iflatrepository.flush();
	   return flatDto;
		 }
	 }
	 
	 
	 public List<FlatDto> viewAllFlat(){
		 List<FlatDto>flatDtoList=new ArrayList<>();
		 List<Flat>flatList=iflatrepository.findAll();
		 FlatDto flatDto=new FlatDto();
		 for(Flat flat:flatList) {
			 BeanUtils.copyProperties(flat,flatDto);
			 flatDtoList.add(flatDto);
		 }
		 return flatDtoList;
	 }
	 
	 
	 public List<FlatDto> findByCostAndAvailability(Double cost,String availability){
		 
		 return iflatrepository.findByCostAndAvailability(cost,availability);
	 }
}


