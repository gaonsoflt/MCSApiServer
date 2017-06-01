package com.gaonsoft.mcs.workorder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.gaonsoft.mcs.workorder.domain.WorkHistory;

@Transactional
@Repository
public class WorkHistoryDAOImpl implements WorkHistoryDAO {
    protected Log logger = LogFactory.getLog(WorkHistoryDAOImpl.class);

	@PersistenceContext	
	private EntityManager entityManager;
 
	@Override
	public WorkHistory createWorkHistory(WorkHistory history) {
		history.setWorkHisSeq(null);
		entityManager.persist(history);
		return history;
	}

	@Override
	public WorkHistory selectWorkHistoryBySeq(long seq) {
		return entityManager.find(WorkHistory.class, seq);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkHistory> selectAllWorkHistories() {
		return (List<WorkHistory>)entityManager.createQuery("FROM WorkHistory").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public WorkHistory selectLatestWorkHistoryByToolId(String toolId) {
//		String hql = "FROM WorkHistory as w WHERE w.toolId = ? ORDER BY w.startDt DESC";
//		String hql = "FROM WorkHistory as w JOIN FETCH w.production p WHERE w.toolId = ? AND p.productionDt >= w.startDt ORDER BY w.startDt DESC";
//		String hql = "FROM WorkHistory as w WHERE w.toolId = ? AND w.production.productionDt >= w.startDt ORDER BY w.startDt DESC";
//		String hql = "FROM (WorkHistory as w WHERE w.toolId JOIN FETCH w.production p WHERE w.toolId = ? AND p.productionDt >= w.startDt ORDER BY w.startDt DESC";
		String hql = "FROM WorkHistory as w WHERE w.toolId = ? AND w.startDt = (SELECT MIN(ww.startDt) FROM WorkHistory ww WHERE ww.toolId = ?)";
		List<WorkHistory> result = (List<WorkHistory>)entityManager.createQuery(hql)
				.setParameter(1, toolId)
				.setParameter(2, toolId)
				.getResultList();
		logger.info(result);
		
		return result.get(0);
	}
}
