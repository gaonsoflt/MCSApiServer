package com.gaonsoft.mcs.equipment.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaonsoft.mcs.equipment.dao.EquipmentDAO;
import com.gaonsoft.mcs.equipment.domain.Equipment;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    protected Log logger = LogFactory.getLog(EquipmentServiceImpl.class);
    
	@Autowired
	private EquipmentDAO eqDAO;
	
	@Override
	public List<Equipment> getAllEquipments() {
		return eqDAO.getAllEquipments();
	}
} 