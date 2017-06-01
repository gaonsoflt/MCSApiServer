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
		// using queryDSL
//		JPAQuery query = new JPAQuery(entityManager);
//		QWorkHistory history = QWorkHistory.workHistory;
//		QWorkHistory subhis = new QWorkHistory("sub");
//		QProduction production = new QProduction("sub2");
//		WorkHistory result = query.from(history)
//				.where(history.toolId.eq(toolId)
//						.and(history.startDt.eq(new JPASubQuery().from(subhis).where(subhis.toolId.eq(toolId)).unique(subhis.startDt.max()))))
//				.uniqueResult(history);
//		logger.info("find history: \n" + result);
//		
//		List<Production> p = query.from(production)
//				.where(production.id.compSeq.eq(history.compSeq)
//						.and(production.id.toolId.eq(history.toolId))
//						.and(production.productionDt.goe(history.startDt)))
//				.list(production);
//		result.setProduction(p);
//		logger.info("find production: \n" + p);
//		logger.info("find history with production: \n" + result);
//		
//		return result;
		
		// use JSQL
//		String hql = "FROM WorkHistory as w WHERE w.toolId = ? ORDER BY w.startDt DESC";
//		String hql = "FROM WorkHistory as w JOIN FETCH w.production p WHERE w.toolId = ? AND p.productionDt >= w.startDt ORDER BY w.startDt DESC";
//		String hql = "FROM WorkHistory as w WHERE w.toolId = ? AND w.production.productionDt >= w.startDt ORDER BY w.startDt DESC";
//		String hql = "FROM (WorkHistory as w WHERE w.toolId JOIN FETCH w.production p WHERE w.toolId = ? AND p.productionDt >= w.startDt ORDER BY w.startDt DESC";
		String hql = "FROM WorkHistory as w WHERE w.toolId = :toolId AND w.startDt = (SELECT MAX(ww.startDt) FROM WorkHistory ww WHERE ww.toolId = :toolId)";
		List<WorkHistory> result = (List<WorkHistory>)entityManager.createQuery(hql)
				.setParameter("toolId", toolId)
				.getResultList();
//		logger.info(result);
		final WorkHistory w = result.get(0);
		logger.info("find history: \n" + w);
		return result.get(0);
	}
}
