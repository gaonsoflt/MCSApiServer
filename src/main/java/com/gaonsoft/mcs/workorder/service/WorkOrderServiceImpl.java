package com.gaonsoft.mcs.workorder.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaonsoft.mcs.workorder.dao.WorkOrderDAO;
import com.gaonsoft.mcs.workorder.domain.Production;
import com.gaonsoft.mcs.workorder.domain.ProductionSum;
import com.gaonsoft.mcs.workorder.domain.WorkOrder;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    protected Log logger = LogFactory.getLog(WorkOrderServiceImpl.class);
    
	@Autowired
	private WorkOrderDAO workOrderDAO;
	
	@Override
	public List<WorkOrder> getAllWorkOrders() {
		return workOrderDAO.selectAllWorkOrder();
	}

	@Override
	public WorkOrder getWorkOrderByNo(String no) {
		return workOrderDAO.selectWorkOrderByNo(no);
	}

	@Override
	public List<WorkOrder> getWorkOrdersByPeriod(String from, String to) {
		String _from = new SimpleDateFormat("yyyyMMdd").format(new Date(Long.valueOf(from)));
		String _to = new SimpleDateFormat("yyyyMMdd").format(new Date(Long.valueOf(to)));
		
//		String _from = "20170123";
//		String _to = "20170124";
		return workOrderDAO.selectWorkOrdersByPeriod(_from, _to);
	}

	@Override
	public ProductionSum getProductionSummary(String toolId, Timestamp startDt) {
		ProductionSum summary = makeSummary(workOrderDAO.selectProductionByHistory(toolId, startDt));
		return summary;
	}
	
	private ProductionSum makeSummary(List<Production> production) {
		ProductionSum summary = new ProductionSum();
		logger.info(production);
		if(!production.isEmpty()) {
//			summary.setCompSeq(production.get(0).getId().getCompSeq());
//			summary.setToolId(production.get(0).getId().getToolId());
			summary.setCompSeq(production.get(0).getCompSeq());
			summary.setToolId(production.get(0).getToolId());
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
