package com.gaonsoft.mcs.workcenter.dao;

import java.util.List;

import com.gaonsoft.mcs.workcenter.domain.WorkCenter;
import com.gaonsoft.mcs.workcenter.domain.WorkCenterKey;

public interface WorkCenterrDAO {
	List<WorkCenter> getAllWorkCenters();
	WorkCenter getWorkCenterById(WorkCenterKey id);
}
	