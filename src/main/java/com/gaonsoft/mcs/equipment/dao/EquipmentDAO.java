package com.gaonsoft.mcs.equipment.dao;

import java.util.List;

import com.gaonsoft.mcs.equipment.domain.Equipment;
import com.gaonsoft.mcs.equipment.domain.EquipmentKey;

public interface EquipmentDAO {
	List<Equipment> getAllEquipments();
	Equipment getEquipmentById(EquipmentKey id);
}
	 