package com.gaonsoft.mcs.workcenter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gaonsoft.mcs.workcenter.domain.WorkCenter;
import com.gaonsoft.mcs.workcenter.domain.WorkCenterKey;

@Transactional
@Repository
public class WorkCenterrDAOImpl implements WorkCenterrDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkCenter> getAllWorkCenters() {
		String hql = "FROM WorkCenter";
		return (List<WorkCenter>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public WorkCenter getWorkCenterById(WorkCenterKey id) {
		return entityManager.find(WorkCenter.class, id);
	}
}
