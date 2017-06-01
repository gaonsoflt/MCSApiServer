package com.gaonsoft.mcs.equipment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaonsoft.mcs.equipment.domain.Equipment;
import com.gaonsoft.mcs.equipment.service.EquipmentService;

@RestController
@RequestMapping("/api/equipments")
public class RestEquipmentController {
	
	@Autowired
	private EquipmentService eqService;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<Equipment>> selectAllEquipments() {
		final List<Equipment> result = eqService.getAllEquipments();
		if (result.isEmpty()) {
			return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
		} 
		return new ResponseEntity<List<Equipment>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{eqId}", method = RequestMethod.GET) 
	public ResponseEntity<Equipment> selectEquipmentById(@PathVariable(name="eqId") String eqId) {
//		final User result = wcService(wcId);
//		if (result == null) {
			return new ResponseEntity<Equipment>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<WorkCenter>(result, HttpStatus.OK);
	}
}
