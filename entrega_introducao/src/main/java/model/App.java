
package model;

import org.apache.commons.math3.util.CombinatoricsUtils;

public class App{
	
	public static void main(String[] args) {
		long factorial = CombinatoricsUtils.factorial(10);
		System.out.print("Fatorial 10! = ");
		System.out.println(factorial);    
	}
	
}