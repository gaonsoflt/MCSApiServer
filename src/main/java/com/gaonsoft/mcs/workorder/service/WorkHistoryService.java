package com.gaonsoft.mcs.workorder.service;

import java.util.List;

import com.gaonsoft.mcs.workorder.domain.WorkHistory;

public interface WorkHistoryService {
	WorkHistory saveWorkHistory(WorkHistory history);

	WorkHistory getWorkHistoryBySeq(Long seq);

	List<WorkHistory> getAllWorkHistories();

	WorkHistory getLatestWorkHistoryByToolId(String toolId);
}