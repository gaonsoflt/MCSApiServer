package com.gaonsoft.mcs.workorder.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaonsoft.mcs.workorder.dao.WorkHistoryDAO;
import com.gaonsoft.mcs.workorder.domain.Production;
import com.gaonsoft.mcs.workorder.domain.ProductionSum;
import com.gaonsoft.mcs.workorder.domain.WorkHistory;

@Service
public class WorkHistoryServiceImpl implements WorkHistoryService {

    protected Log logger = LogFactory.getLog(WorkHistoryServiceImpl.class);
    
	@Autowired
	private WorkHistoryDAO workHistoryDAO;
	
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
	public WorkHistory getLatestWorkHistoryByToolId(String toolId) {
		WorkHistory history =  workHistoryDAO.selectLatestWorkHistoryByToolId(toolId);
		// production list too big size
		// make production summary by production list
		history.getWorkOrder().setProdSummary(makeSummary(history.getProduction()));
		// set null(production list) after make summary  
//		history.setProduction(null);
		return history;	
	}
	
	private ProductionSum makeSummary(List<Production> production) {
		ProductionSum summary = new ProductionSum();
		logger.info(production);
		if(!production.isEmpty()) {
			summary.setCompSeq(production.get(0).getId().getCompSeq());
			summary.setToolId(production.get(0).getId().getToolId());
			summary.setNormalQty((long) 0);
			summary.setDefectQty((long) 0);
			for (Production prod : production) {
				if(prod.getDefective() == 0) {
					summary.setNormalQty(summary.getNormalQty() + prod.getQuantity());
				} else {
					summary.setDefectQty(summary.getDefectQty() + prod.getQuantity());
				}
			}
		}
		return summary;
	}
} 