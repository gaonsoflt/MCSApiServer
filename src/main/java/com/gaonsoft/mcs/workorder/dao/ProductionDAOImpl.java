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

@Transactional
@Repository
public class ProductionDAOImpl implements ProductionDAO {
    protected Log logger = LogFactory.getLog(ProductionDAOImpl.class);

	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Production> selectAllProduction() {
		String hql = "FROM Production";
		return (List<Production>)entityManager.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Production> selectProductionByWorkOrder(Long compSeq, String toolId, Timestamp productionDt) {
//		ProductionKey key = new ProductionKey(compSeq, toolId, productionDt);
		return (List<Production>) entityManager.createQuery(
				"FROM Production as p WHERE p.compSeq = ? AND p.toolId = ? AND p.productionDt >= ? BY p.productionDt DESC")
				.setParameter(1,  compSeq)
				.setParameter(2,  toolId)
				.setParameter(3,  productionDt)
				.getResultList();
	}
}
