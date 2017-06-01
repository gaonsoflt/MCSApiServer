package com.gaonsoft.mcs.workorder.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaonsoft.mcs.workorder.dao.WorkOrderDAO;
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
}
