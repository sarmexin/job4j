package ru.job4j.calculator;

publick class Calculator{
	private double result;
	
	publick void add(double first, double second){
		this.result=first+second;
	}
	publick void subtract(double first, double second){
		this.result=first-second;
	}
	publick void div(double first, double second){
		this.div=first/second;
	}
	publick void multiple(double first, double second){
		this.multiple=first*second;
	}	
	public double getResult(){
		return this.result;
	}	
}