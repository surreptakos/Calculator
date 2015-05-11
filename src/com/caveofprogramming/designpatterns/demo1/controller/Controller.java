package com.caveofprogramming.designpatterns.demo1.controller;

import com.caveofprogramming.designpatterns.demo1.view.CalculationEvent;
import com.caveofprogramming.designpatterns.demo1.view.CalculationListener;
import com.caveofprogramming.designpatterns.demo1.view.View;

public class Controller implements CalculationListener {
	private View view;
	private double term1;
	private double term2;
	private double answer;
	private String op;
	
	public Controller(View view) {
		this.view = view;
	}

	@Override
	public void calculationPerformed(CalculationEvent event) {
		
		term1 = event.getTerm1();
		term2 = event.getTerm2();
		op = event.getOperator();
		
		if(op != null) {
			switch(op) {
			case "+":
				answer = term1 + term2;
				break;
			case "-":
				answer = term1 - term2;
				break;
			case "*":
				answer = term1 * term2;
				break;
			case "/":
				answer = term1 / term2;
				break;
			case "=":
				answer = term1;
				break;
			default:
				System.out.println("Invalid op: " + op);
				answer = 0;
				break;
			}
		} else {
			//op is null
			System.out.println("Op is null");
			answer = 0;
		}
			
				
		view.setAnswerField(answer + "");
	}
}
