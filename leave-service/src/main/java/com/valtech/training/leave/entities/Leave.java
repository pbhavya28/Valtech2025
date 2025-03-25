package com.valtech.training.leave.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Leave {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "leave_seq")
	@SequenceGenerator(name = "leave_seq",sequenceName = "leave_seq",allocationSize = 1)
	private long id;
	
	private LocalDate fromDate;
	private LocalDate toDate;
	
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	
	@Enumerated(EnumType.STRING)
	private LeaveStatus leaveStatus;
	
	private String reason;
	private String comments;
	private long employeeId;
	
	public Leave() {}

	
	
	public Leave(long id, LocalDate forDate, LocalDate toDate, LeaveType leaveType, LeaveStatus leaveStatus,
			String reason, String comments, long employeeId) {
		this.id = id;
		this.fromDate = forDate;
		this.toDate = toDate;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.reason = reason;
		this.comments = comments;
		this.employeeId = employeeId;
	}
	
	public long leavesInDays() {
		return ChronoUnit.DAYS.between(fromDate, toDate);
	}

	public void checkLeaveApplicationAndUpdateStatus(LeaveMaster lm) {
		if(leaveType == LeaveType.CASUAL) {
			if (lm.getCasualLeaves() == 0) {
				rejectLeave("Casual leaves exhausted");
			}
			else {
				long diff = ChronoUnit.DAYS.between(fromDate, toDate);
				if(diff < 0) {
					comments = "Invalid 'from' and 'to' dates.";
				}
				if(diff>lm.getCasualLeaves()) {
					comments = "Available leaves are " + lm.getCasualLeaves()+".Applied for" +diff+" leaves";
				}
				else {
					comments = "Good to go.";
				}
//				check if fromdate is before today and reject it
			}
		}
		/////
		if(leaveType == LeaveType.SICK) {
			if (lm.getSickLeaves() == 0) {
				rejectLeave("Sick leaves exhausted");
			}
			else {
				long diff = ChronoUnit.DAYS.between(fromDate, toDate);
				if(diff < 0) {
					comments = "Invalid 'from' and 'to' dates.";
				}
				if(diff>lm.getSickLeaves()) {
					comments = "Available leaves are " + lm.getSickLeaves()+".Applied for" +diff+" leaves";
				}
				else {
					comments = "Good to go.";
				}
//				check if fromdate is before today and reject it
			}
		}
		///////
		if(leaveType == LeaveType.OTHERS) {
			if (lm.getOtherLeaves() == 0) {
				rejectLeave("Other leaves exhausted");
			}
			else {
				long diff = ChronoUnit.DAYS.between(fromDate, toDate);
				if(diff < 0) {
					comments = "Invalid 'from' and 'to' dates.";
				}
				if(diff>lm.getOtherLeaves()) {
					comments = "Available leaves are " + lm.getOtherLeaves()+".Applied for" +diff+" leaves";
				}
				else {
					comments = "Good to go.";
				}
//				check if fromdate is before today and reject it
			}
		}
	}


	public void rejectLeave(String comment) {
		leaveStatus = LeaveStatus.REJECTED;
		comments = comment;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate forDate) {
		this.fromDate = forDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}



	public void approveLeave(LeaveMaster byEmployeeId, long manager) {
		leaveStatus = LeaveStatus.APPROVED;
		if(comments == null) {comments = "";}
		comments += "Your leaves have been approved";
		
	}



	public void updateLeave(String comment) {
		comments += comment;
	}




	
}
