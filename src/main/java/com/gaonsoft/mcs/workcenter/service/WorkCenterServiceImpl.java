package com.gaonsoft.mcs.workcenter.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaonsoft.mcs.workcenter.dao.WorkCenterrDAO;
import com.gaonsoft.mcs.workcenter.domain.WorkCenter;

@Service
public class WorkCenterServiceImpl implements WorkCenterService {

    protected Log logger = LogFactory.getLog(WorkCenterServiceImpl.class);
    
	@Autowired
	private WorkCenterrDAO wcDAO;
	
	@Override
	public List<WorkCenter> getAllWorkCenters() {
		return wcDAO.getAllWorkCenters();
	}
}