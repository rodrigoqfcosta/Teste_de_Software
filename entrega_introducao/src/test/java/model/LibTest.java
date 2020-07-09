
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.jupiter.api.Test;
import model.App;

public class LibTest{
	
	@Test
	public void factorialTest1(){
		long factorialTest1 = CombinatoricsUtils.factorial(10);
		assertEquals(3628800, factorialTest1);
	}
	
	@Test
	public void factorialTest2(){
		long factorialTest2 = CombinatoricsUtils.factorial(5);
		assertEquals(120, factorialTest2);
	}
	
}