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

	private JButton equalsButton;
	private JButton addButton;
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
	
	private double term1;
	private double term2;
	private boolean term1Set = false;
	private boolean term2Set = false;


	private CalculationListener calculationListener;
	private OperationListener operationListener;

	public View() {
		super("My Calculator");

		equalsButton = new JButton(" = ");
		addButton = new JButton(" + ");
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
		answerField = new JLabel("Output here");

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 4;
		gc.gridy = 1;
		add(calcField, gc);
		
		gc.gridx = 4;
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
		
		gc.gridx = 1;
		gc.gridy = 5;
		add(addButton, gc);

		equalsButton.addActionListener(this);
		addButton.addActionListener(this);
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
		
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton)e.getSource();
		String buttonText = buttonPressed.getText();
		String calcText = calcField.getText();
		
		if(buttonPressed.equals(equalsButton)) {
			//fireOperationEvent(new OperationEvent(calcText, "="));
			fireCalculationEvent(new CalculationEvent(calcText));
		} else {
			//it's a number
			calcField.setText(calcText + buttonText);
		}
		
	}

	public void setCalculationListener(CalculationListener calculationListener) {
		this.calculationListener = calculationListener;
	}
	
	public void setOperationListener(OperationListener operationListener) {
		this.operationListener = operationListener;
	}

	public void fireCalculationEvent(CalculationEvent event) {
		if (calculationListener != null) {
			calculationListener.calculationPerformed(event);
		}
	}
	
	public void fireOperationEvent(OperationEvent event) {
		if (operationListener != null) {
			operationListener.operationPerformed(event);
		}
	}
	
	public void setAnswerField(String s) {
		answerField.setText(s);
	}

}
