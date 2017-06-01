package com.gaonsoft.mcs.workorder.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.gaonsoft.mcs.workorder.domain.Production;
import com.gaonsoft.mcs.workorder.domain.QProduction;
import com.gaonsoft.mcs.workorder.domain.QWorkHistory;
import com.gaonsoft.mcs.workorder.domain.WorkOrder;
import com.mysema.query.jpa.impl.JPAQuery;

@Transactional
@Repository
public class WorkOrderDAOImpl implements WorkOrderDAO {
    protected Log logger = LogFactory.getLog(WorkOrderDAOImpl.class);

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkOrder> selectAllWorkOrder() {
		String hql = "FROM WorkOrder";
		return (List<WorkOrder>)entityManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public WorkOrder selectWorkOrderByNo(String no) {
		String hql = "FROM WorkOrder as o WHERE o.workOrderNo = ?";
		List<WorkOrder> result = (List<WorkOrder>)entityManager.createQuery(hql).setParameter(1,  no).getResultList();
		if(result.isEmpty()) {
			return new WorkOrder();
		}
		return result.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkOrder> selectWorkOrdersByPeriod(String from, String to) {
		logger.info("from[" + from.toString() + "]/to[" + to.toString() + "]");
		String hql = "FROM WorkOrder as o WHERE o.workOrderDate BETWEEN ? AND ?";
		return (List<WorkOrder>)entityManager.createQuery(hql)
				.setParameter(1, from)
				.setParameter(2, to)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Production> selectProductionByHistory(String toolId, Timestamp startDt) {
//		String hql = "FROM Production as p WHERE p.id.toolId = :toolId AND p.productionDt >= :startDt";
//		List<Production> p = (List<Production>)entityManager.createQuery(hql)
//				.setParameter("toolId", toolId)
//				.setParameter("startDt", startDt)
//				.getResultList();
		JPAQuery query = new JPAQuery(entityManager);
		QProduction production = new QProduction("production");
		List<Production> p = query.from(production)
		.where(production.toolId.eq(toolId)
				.and(production.productionDt.goe(startDt)))
		.list(production);
		return p;
	}
}
