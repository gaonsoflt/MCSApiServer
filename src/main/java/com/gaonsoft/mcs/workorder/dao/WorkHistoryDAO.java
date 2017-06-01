package com.gaonsoft.mcs.workorder.dao;

import java.util.List;

import com.gaonsoft.mcs.workorder.domain.WorkHistory;

public interface WorkHistoryDAO {
	WorkHistory createWorkHistory(WorkHistory history);
	List<WorkHistory> selectAllWorkHistories();
	WorkHistory selectWorkHistoryBySeq(long seq);
	WorkHistory selectLatestWorkHistoryByToolId(String toolId);
}
	 