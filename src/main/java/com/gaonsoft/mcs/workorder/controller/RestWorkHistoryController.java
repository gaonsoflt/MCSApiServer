package com.gaonsoft.mcs.workorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaonsoft.mcs.workorder.domain.WorkHistory;
import com.gaonsoft.mcs.workorder.service.WorkHistoryService;

@RestController
@RequestMapping("/api/workorders")
public class RestWorkHistoryController {
	
	@Autowired
	private WorkHistoryService workHistoryService;

	/**
	 * 
	 * @param history
	 * {
	 * 		"compSeq" : 1,
	 * 		"workOrderNo" : "201704130001-test",
	 * 		"toolId" : "tool-abc",
	 * 		"workerId" : "admin",
	 *		"startDt" : 1499038000
	 * }
	 * @param ucBuilder
	 * @return Location
	 * 		http://localhost:8080/api/workorders/history/14
	 */
	@RequestMapping(value = "/history", method = RequestMethod.POST)
	public ResponseEntity<Void> createWorkHistory(@RequestBody final WorkHistory history,
			final UriComponentsBuilder ucBuilder) {
		
		final WorkHistory savedHis = workHistoryService.saveWorkHistory(history);
		
		/* 
		 * Customer를 생성하고 HttpHeaders 객체의 location 정보를 넣어 주기 위함이다. 
		 * 이렇게 해 주면 Front-end 쪽 개발자는 새로운 데이타가 성공적으로 생성 (HttpStatus.CREATED) 되었을 경우 header 정보에서 location 값을 찾아 redirect 해 줄 수 있게 된다. 
		 */
		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/workorders/history/{seq}").buildAndExpand(savedHis.getWorkHisSeq()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/history/{seq}", method = RequestMethod.GET) 
	public ResponseEntity<WorkHistory> selectWorkHistoryById(@PathVariable(name="seq") Long seq) {
		final WorkHistory result = workHistoryService.getWorkHistoryBySeq(seq);
		if (result == null) {
			return new ResponseEntity<WorkHistory>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<WorkHistory>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET) 
	public ResponseEntity<List<WorkHistory>> selectWorkHistories() {
		final List<WorkHistory> result = workHistoryService.getAllWorkHistories();
		if (result.isEmpty()) {
			return new ResponseEntity<List<WorkHistory>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<WorkHistory>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/history/equipments/{id}", method = RequestMethod.GET) 
	public ResponseEntity<WorkHistory> selectLatestWorkByToolId(@PathVariable(name="id") String id) {
		final WorkHistory result = workHistoryService.getLatestWorkByToolId(id);
		if (result == null) {
			return new ResponseEntity<WorkHistory>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<WorkHistory>(result, HttpStatus.OK);
	}
}
