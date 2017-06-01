package com.gaonsoft.mcs.workcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaonsoft.mcs.workcenter.domain.WorkCenter;
import com.gaonsoft.mcs.workcenter.service.WorkCenterService;

@RestController
@RequestMapping("/api/workcenters")
public class RestWorkCenterController {
	
	@Autowired
	private WorkCenterService wcService;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<WorkCenter>> selectAllWorkCenters() {
		final List<WorkCenter> result = wcService.getAllWorkCenters();
		if (result.isEmpty()) {
			return new ResponseEntity<List<WorkCenter>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<WorkCenter>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{wcId}", method = RequestMethod.GET) 
	public ResponseEntity<WorkCenter> selectWorkCenterById(@PathVariable(name="wcId") String wcId) {
//		final User result = wcService(wcId);
//		if (result == null) {
			return new ResponseEntity<WorkCenter>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<WorkCenter>(result, HttpStatus.OK);
	}
}
