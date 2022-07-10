package com.cg.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.dto.FlatDto;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.service.FlatService;

@RestController 
@RequestMapping("/FlatDetails")
public class FlatController {
	@Autowired
	private FlatService flatService;
	@PostMapping
	public FlatDto addFlat(@RequestBody FlatDto flatDto) {
		return flatService.addFlat(flatDto);
	}
	
	@PutMapping("/flatId/{newcost}")
	public FlatDto updateCost(@PathVariable("flatId")Integer flatId,@PathVariable("newCost")Double cost) {
		return flatService.updateFlat(flatId,cost);
	}
	@DeleteMapping("/flatId")
	public FlatDto deleteFlat(@PathVariable("flatId")Integer flatId){
	
		return flatService.deleteFlat(flatId);
	}
	@GetMapping("/flatId")
	public FlatDto viewFlatById(@PathVariable("flatId")Integer flatId) {
		return flatService.viewFlat(flatId);
	}
	@GetMapping("/viewAllFlat")
	public List<FlatDto>viewAllFlat(){
		return flatService.viewAllFlat();
	}
	@GetMapping ("/viewAllFlatByCostAndAvailability")
	public List<FlatDto> findByCostAndAvailability(@PathVariable("cost")Double cost,@PathVariable("availability")String availability){
		return flatService.findByCostAndAvailability(cost, availability);
	}

}
