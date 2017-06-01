package com.gaonsoft.mcs.workorder.dao;

import java.util.List;

import com.gaonsoft.mcs.workorder.domain.WorkOrder;

public interface WorkOrderDAO {
	List<WorkOrder> selectAllWorkOrder();
	WorkOrder selectWorkOrderByNo(String no);
	List<WorkOrder> selectWorkOrdersByPeriod(String from, String to);
}
	 