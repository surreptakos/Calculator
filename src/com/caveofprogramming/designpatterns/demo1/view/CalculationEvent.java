package com.caveofprogramming.designpatterns.demo1.view;


public class CalculationEvent {
	private double term1;
	private double term2;
	private String operator;

	public CalculationEvent(String calcString, String opString) {
		if (calcString == null || opString == null) {
			System.out.println("calcString and/or opString is null.");
			System.out.println("calcString: " + calcString);
			System.out.println("opString: " + opString);
		} else {
		
			System.out.println(calcString);
			System.out.println(opString);
		
			this.operator = opString;
			
			if (calcString.length() > 0)
			{
				if(operator.length() == 0) {
					term1 = Double.parseDouble(calcString);
					this.operator = "=";
				} else {
					int firstTermEnd = calcString.indexOf(opString);
					if (firstTermEnd != -1) {
						term1 = Double.parseDouble(calcString.substring(0, firstTermEnd));
						term2 = Double.parseDouble(calcString.substring(firstTermEnd + 1, calcString.length()));
					} else {
						System.out.println("Couldn't find operator in calcString.");
					}
		
				}
			
			} else {
				System.out.println("calcString is empty.");
			}
		}
	}

	public double getTerm1() {
		return term1;
	}

	public void setTerm1(double term1) {
		this.term1 = term1;
	}

	public double getTerm2() {
		return term2;
	}

	public void setTerm2(double term2) {
		this.term2 = term2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
	
}

