package com.gaonsoft.mcs.equipment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gaonsoft.mcs.equipment.domain.Equipment;
import com.gaonsoft.mcs.equipment.domain.EquipmentKey;

@Transactional
@Repository
public class EquipmentDAOImpl implements EquipmentDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Equipment> getAllEquipments() {
		String hql = "FROM Equipment";
		return (List<Equipment>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Equipment getEquipmentById(EquipmentKey id) {
		// TODO Auto-generated method stub
		return null;
	}
}
