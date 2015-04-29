package com.caveofprogramming.designpatterns.demo1.view;


public class CalculationEvent {
	private double term1;
	private double term2;
	private String operator;

	public CalculationEvent(String calcString) {
		System.out.println(calcString);
		
		if (calcString.length() > 0)
		{
			int firstTermEnd = calcString.indexOf(' ');
			if (firstTermEnd != -1) {
				term1 = Double.parseDouble(calcString.substring(0, firstTermEnd));
			} else {
				
			}
	}
}
