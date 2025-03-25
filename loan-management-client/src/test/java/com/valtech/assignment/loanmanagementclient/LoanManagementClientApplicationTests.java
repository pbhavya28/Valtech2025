package com.valtech.assignment.loanmanagementclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.assignment.loanmanagement.entities.Loan;
import com.valtech.assignment.loanmanagement.entities.Loan.LoanType;
import com.valtech.assignment.loanmanagement.entities.Loan.Status;
import com.valtech.assignment.loanmanagement.webservices.LoanServiceWS;


@SpringBootTest
class LoanManagementClientApplicationTests {

	@Autowired
	private LoanServiceWS loanServiceWS;
	

	@Test
	void contextLoads() {

//		loanServiceWS.applyForLoan(new Loan("Arya Shah", 00420, 2, LoanType.CAR, "Cycle", 2000,
//			8000, 3000, Status.APPLIED));
//		loanServiceWS.applyForLoan(new Loan("Siddhi Patel", 00422, 200, LoanType.HOME, "Car", 20000,
//				7000, 30000, Status.APPLIED));
//		loanServiceWS.applyForLoan(new Loan("Indrajeet Khatri", 1234,900, LoanType.CAR, "Bike", 90000,
//				100000, 30000, Status.APPLIED));
//		loanServiceWS.applyForLoan(new Loan("Shantha Kumar", 9876, 700, LoanType.HOME, "Home", 180000,
//					200000, 51000, Status.APPLIED));
		System.out.println(loanServiceWS.getAllLoans());
	}

}
