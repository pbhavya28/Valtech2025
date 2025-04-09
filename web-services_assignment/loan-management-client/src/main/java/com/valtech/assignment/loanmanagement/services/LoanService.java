package com.valtech.assignment.loanmanagement.services;

import java.util.List;

import com.valtech.assignment.loanmanagement.vos.LoanVO;

public interface LoanService {

	LoanVO saveLoan(LoanVO lvo);

	LoanVO getLoan(int id);

	List<LoanVO> getAllLoans();
	
	LoanVO applyForLoan(LoanVO lvo);

}