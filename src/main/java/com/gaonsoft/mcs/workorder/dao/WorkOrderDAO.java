package com.gaonsoft.mcs.workorder.dao;

import java.sql.Timestamp;
import java.util.List;

import com.gaonsoft.mcs.workorder.domain.Production;
import com.gaonsoft.mcs.workorder.domain.WorkOrder;

public interface WorkOrderDAO {
	List<WorkOrder> selectAllWorkOrder();
	WorkOrder selectWorkOrderByNo(String no);
	List<WorkOrder> selectWorkOrdersByPeriod(String from, String to);
	List<Production> selectProductionByHistory(String toolId, Timestamp startDt);
}
	 