package com.gaonsoft.mcs.workorder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.gaonsoft.mcs.workorder.domain.WorkOrder;

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
}
