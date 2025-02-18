package com.valtecht.training.simple.interest;
import com.valtech.training.arithmetic.Operation;

public class SimpleInterest {

	public int compute(int princ, int rate, int time) {
		int product = Operation.MUL.perform(princ*rate,time);
		return Operation.DIV.perform(product,100);
		
	}
}
