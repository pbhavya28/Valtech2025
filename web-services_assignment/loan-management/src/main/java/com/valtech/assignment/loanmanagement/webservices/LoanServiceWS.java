package com.valtech.assignment.loanmanagement.webservices;

import java.util.List;

import javax.jws.WebService;

import com.valtech.assignment.loanmanagement.entities.Loan;
import com.valtech.assignment.loanmanagement.vos.LoanVO;

@WebService
public interface LoanServiceWS {

	Loan createLoan(Loan loan);

	Loan getLoan(int id);

	List<Loan> getAllLoans();
	
	Loan applyForLoan(Loan loan);

}