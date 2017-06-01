package com.gaonsoft.mcs.workorder.controller;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaonsoft.mcs.workorder.domain.ProductionSum;
import com.gaonsoft.mcs.workorder.domain.WorkOrder;
import com.gaonsoft.mcs.workorder.service.WorkOrderService;

@RestController
@RequestMapping("/api/workorders")
public class RestWorkOrderController {
    protected Log logger = LogFactory.getLog(RestWorkOrderController.class);

	@Autowired
	private WorkOrderService workOrderService;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<WorkOrder>> selectAllWorkOrder() {
		final List<WorkOrder> result = workOrderService.getAllWorkOrders();
		if (result.isEmpty()) {
			return new ResponseEntity<List<WorkOrder>>(HttpStatus.NO_CONTENT);
		} 
		return new ResponseEntity<List<WorkOrder>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{no}", method = RequestMethod.GET) 
	public ResponseEntity<WorkOrder> selectWorkOrderByNo(@PathVariable(name="no") String no) {
		final WorkOrder result = workOrderService.getWorkOrderByNo(no);
		if (result == null) {
			return new ResponseEntity<WorkOrder>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<WorkOrder>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/date", method = RequestMethod.GET) 
	public ResponseEntity<List<WorkOrder>> selectWorkOrdersByOrderDate(@RequestParam(name="from") String from, @RequestParam(name="to") String to) {
		logger.info("from[" + from + "]/to[" + to + "]");
		final List<WorkOrder> result = workOrderService.getWorkOrdersByPeriod(from, to);
		if (result == null) {
			return new ResponseEntity<List<WorkOrder>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<WorkOrder>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/production", method = RequestMethod.GET) 
	public ResponseEntity<ProductionSum> selectWorkOrdersByOrderDate(@RequestParam(name="tool") String toolId, @RequestParam(name="start") long start) {
		final ProductionSum result = workOrderService.getProductionSummary(toolId, new Timestamp(start));
		if (result == null) {
			return new ResponseEntity<ProductionSum>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ProductionSum>(result, HttpStatus.OK);
	}
}
