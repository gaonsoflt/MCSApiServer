package com.gaonsoft.mcs.workorder.dao;

import java.sql.Timestamp;
import java.util.List;

import com.gaonsoft.mcs.workorder.domain.Production;

public interface ProductionDAO {
	List<Production> selectAllProduction();
	List<Production> selectProductionByWorkOrder(Long compSeq, String toolId, Timestamp productionDt);
}
	 