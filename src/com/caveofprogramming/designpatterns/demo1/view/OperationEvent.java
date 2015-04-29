package com.caveofprogramming.designpatterns.demo1.view;

public class OperationEvent {
	private double term;
	private String op;
	
	public OperationEvent(String termString, String op) {
		this.term = Double.parseDouble(termString);
		this.op = op;		
	}

	public double getTerm() {
		return term;
	}

	public void setTerm(double term) {
		this.term = term;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

}
