package com.valtech.training.leave.services;

import java.util.List;

import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.EmployeeVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;

public interface LeaveService {

	List<LeaveMasterVO> getAllLeaveMasters();

	LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO vo);

	LeaveMasterVO getLeaveMaster(long id);

	List<LeaveVO> getAllLeaves();

	LeaveVO getLeave(long id);

	LeaveVO saveOrUpdateLeave(LeaveVO vo);

	List<LeaveVO> getLeavesByEmployees(long emp);

	LeaveVO update(LeaveVO vo, long id);

	LeaveVO applyLeave(LeaveVO vo);

//	LeaveVO approveLeave(LeaveVO vo, long managerId);

	LeaveVO approveLeave(ApproveLeaveVO vo);

	EmployeeVO getManager(long employeeId);

}