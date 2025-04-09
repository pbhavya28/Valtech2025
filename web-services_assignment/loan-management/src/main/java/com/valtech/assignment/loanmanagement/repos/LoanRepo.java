package com.valtech.assignment.loanmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.assignment.loanmanagement.entities.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {

}
