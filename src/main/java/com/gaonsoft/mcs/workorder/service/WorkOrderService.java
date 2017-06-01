package com.gaonsoft.mcs.workorder.service;

import java.util.List;

import com.gaonsoft.mcs.workorder.domain.WorkOrder;

public interface WorkOrderService {
	 List<WorkOrder> getAllWorkOrders();
	 WorkOrder getWorkOrderByNo(String no);
	 List<WorkOrder> getWorkOrdersByPeriod(String from, String to);
}
 