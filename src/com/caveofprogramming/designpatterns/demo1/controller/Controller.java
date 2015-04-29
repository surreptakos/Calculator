package com.caveofprogramming.designpatterns.demo1.controller;

import com.caveofprogramming.designpatterns.demo1.view.CalculationEvent;
import com.caveofprogramming.designpatterns.demo1.view.CalculationListener;
import com.caveofprogramming.designpatterns.demo1.view.OperationEvent;
import com.caveofprogramming.designpatterns.demo1.view.OperationListener;
import com.caveofprogramming.designpatterns.demo1.view.View;

public class Controller implements CalculationListener, OperationListener {
	private View view;
	private double term1;
	private double term2;
	private double answer;
	private boolean term1Set = false;
	private boolean term2Set = false;
	private String op;
	
	public Controller(View view) {
		this.view = view;
	}

	@Override
	public void calculationPerformed(CalculationEvent event) {
		if(op != null && term1Set && term2Set) {
			switch(op) {
			case "+":
				answer = term1 + term2;
				break;
			case "-":
				answer = term1 - term2;
				break;
			case "x":
				answer = term1 * term2;
				break;
			case "/":
				answer = term1 / term2;
				break;
			default:
				System.out.println("Invalid op: " + op);
				answer = 0;
				break;
			}
		} else if (term1Set) {
			answer = term1;
		} else if (term2Set) {
			answer = term2;
		} else {
			//what???
			System.out.println("You goofed.");
			answer = 0;
		}
			
				
		view.setAnswerField(answer + "");
		op = null;
		term1Set = false;
		term2Set = false;
	}

	@Override
	public void operationPerformed(OperationEvent event) {
		//op = event.getOp();
		
		if(event.getOp().equals("=")) {
			System.out.println("Here!");
			term2 = event.getTerm();
			term2Set = true;
		} else {
			op = event.getOp();
			term1 = event.getTerm();
			term1Set = true;
		}
	}
	
	
}
