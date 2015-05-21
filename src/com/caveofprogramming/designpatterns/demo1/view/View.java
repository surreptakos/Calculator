package com.caveofprogramming.designpatterns.demo1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener {
	
	
	public static final char ADD_OP = '+';
	public static final char SUBTRACT_OP = '-';
	public static final char MULTIPLY_OP = '*';
	public static final char DIVIDE_OP = '/';

	private JButton equalsButton;
	private JButton clearButton;
	private JButton addButton;
	private JButton subtractButton;
	private JButton divideButton;
	private JButton multiplyButton;
	private JButton decimalButton;
	private JButton zeroButton;
	private JButton oneButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton sixButton;
	private JButton sevenButton;
	private JButton eightButton;
	private JButton nineButton;
	
	private JTextField calcField;
	private JLabel answerField;
	
	private String opString = "";


	private CalculationListener calculationListener;

	public View() {
		super("My Calculator");

		equalsButton = new JButton("=");
		clearButton = new JButton("C");
		addButton = new JButton(String.valueOf(ADD_OP));
		subtractButton = new JButton(String.valueOf(SUBTRACT_OP));
		divideButton = new JButton(String.valueOf(DIVIDE_OP));
		multiplyButton = new JButton(String.valueOf(MULTIPLY_OP));
		decimalButton = new JButton(".");
		zeroButton = new JButton("0");
		oneButton = new JButton("1");
		twoButton = new JButton("2");
		threeButton = new JButton("3");
		fourButton = new JButton("4");
		fiveButton = new JButton("5");
		sixButton = new JButton("6");
		sevenButton = new JButton("7");
		eightButton = new JButton("8");
		nineButton = new JButton("9");
		
		calcField = new JTextField(10);
		answerField = new JLabel("");

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 5;
		gc.gridy = 1;
		add(calcField, gc);
		
		gc.gridx = 5;
		gc.gridy = 2;
		add(answerField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(sevenButton, gc);

		gc.gridx = 2;
		gc.gridy = 1;
		add(eightButton, gc);
		
		gc.gridx = 3;
		gc.gridy = 1;
		add(nineButton, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(fourButton, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(fiveButton, gc);
		
		gc.gridx = 3;
		gc.gridy = 2;
		add(sixButton, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(oneButton, gc);
		
		gc.gridx = 2;
		gc.gridy = 3;
		add(twoButton, gc);
		
		gc.gridx = 3;
		gc.gridy = 3;
		add(threeButton, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		add(zeroButton, gc);
		
		gc.gridx = 2;
		gc.gridy = 4;
		add(equalsButton, gc);
		
		gc.gridx = 3;
		gc.gridy = 4;
		add(clearButton, gc);
		
		gc.gridx = 4;
		gc.gridy = 1;
		add(addButton, gc);
		
		gc.gridx = 4;
		gc.gridy = 2;
		add(subtractButton, gc);
		
		gc.gridx = 4;
		gc.gridy = 3;
		add(multiplyButton, gc);
		
		gc.gridx = 4;
		gc.gridy = 4;
		add(divideButton, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		add(decimalButton, gc);

		equalsButton.addActionListener(this);
		clearButton.addActionListener(this);
		addButton.addActionListener(this);
		subtractButton.addActionListener(this);
		multiplyButton.addActionListener(this);
		decimalButton.addActionListener(this);
		divideButton.addActionListener(this);
		zeroButton.addActionListener(this);
		oneButton.addActionListener(this);
		twoButton.addActionListener(this);
		threeButton.addActionListener(this);
		fourButton.addActionListener(this);
		fiveButton.addActionListener(this);
		sixButton.addActionListener(this);
		sevenButton.addActionListener(this);
		eightButton.addActionListener(this);
		nineButton.addActionListener(this);
		
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton)e.getSource();
		String buttonText = buttonPressed.getText();
		String calcText = calcField.getText();
		
		if(buttonPressed.equals(equalsButton)) {
			fireCalculationEvent(new CalculationEvent(calcText, opString));
			//opString = "";
		} else if (isOperator(buttonText)){
			//it's an operator
			//adding a comment to make a commit for beeminder bc I was working late and then lifted and helped Ana and got into a fight with her and yay
			//will grab what's in the answer field if there's something already there
			if (answerField.getText() != "") {
				calcField.setText(answerField.getText());
				calcText = calcField.getText();
				setAnswerField("");
			}

			if(calcText.length() > 0)
			{
				opString = buttonText;
				calcField.setText(calcText + buttonText);
			}
			
		} else if (isInteger(buttonText) || buttonPressed.equals(decimalButton)) {
			if (answerField.getText() != "") {
				pressClearButton();
				calcText = "";
			}
			calcField.setText(calcText + buttonText);			
		} else if (buttonPressed.equals(clearButton)) {
			pressClearButton();
		}
		
	}

	public void setCalculationListener(CalculationListener calculationListener) {
		this.calculationListener = calculationListener;
	}
	
	public void fireCalculationEvent(CalculationEvent event) {
		if (calculationListener != null) {
			calculationListener.calculationPerformed(event);
		}
	}
	
	public void setAnswerField(String s) {
		answerField.setText(s);
	}
	
	public void pressClearButton() {
		calcField.setText("");
		setAnswerField("");
		opString = "";	
	}
	
	public boolean isOperator(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length != 1) {
			return false;
		}
		
		char op = str.charAt(0);
		
		if (op == SUBTRACT_OP || op == ADD_OP || op == MULTIPLY_OP || op == DIVIDE_OP) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c <= '/' || c >= ':') {
				return false;
			}
		}
		return true;
	}

}
