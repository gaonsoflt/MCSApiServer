package com.gaonsoft.mcs.workorder.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaonsoft.mcs.workorder.dao.WorkHistoryDAO;
import com.gaonsoft.mcs.workorder.domain.ProductionSum;
import com.gaonsoft.mcs.workorder.domain.WorkHistory;

@Service
public class WorkHistoryServiceImpl implements WorkHistoryService {

    protected Log logger = LogFactory.getLog(WorkHistoryServiceImpl.class);
    
	@Autowired
	private WorkHistoryDAO workHistoryDAO;
	
	@Autowired
	private WorkOrderService workOrderService;

	@Override
	public WorkHistory saveWorkHistory(WorkHistory history) {
		return workHistoryDAO.createWorkHistory(history);
	}

	@Override
	public WorkHistory getWorkHistoryBySeq(Long seq) {
		return workHistoryDAO.selectWorkHistoryBySeq(seq);
	}

	@Override
	public List<WorkHistory> getAllWorkHistories() {
		return workHistoryDAO.selectAllWorkHistories();
	}

	@Override
	public WorkHistory getLatestWorkByToolId(String toolId) {
		WorkHistory history =  workHistoryDAO.selectLatestWorkHistoryByToolId(toolId);
//		// production list too big size
//		// make production summary by production list
//		history.getWorkOrder().setProdSummary(makeSummary(history.getProduction()));
//		// set null(production list) after make summary  
////		history.setProduction(null);
		ProductionSum summary = workOrderService.getProductionSummary(toolId, history.getStartDt());
		history.getWorkOrder().setProdSummary(summary);
		return history;	
	}
	
	
} 