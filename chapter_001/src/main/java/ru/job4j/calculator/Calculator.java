package ru.job4j.calculator;

public class Calculator {
	private double result;
	
	public void add(double first, double second) {
		this.result = first + second;
	}
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	public void div(double first, double second) {
		this.div = first / second;
	}
	public void multiple(double first, double second) {
		this.multiple = first * second;
	}	
	public double getResult() {
		return this.result;
	}	
}