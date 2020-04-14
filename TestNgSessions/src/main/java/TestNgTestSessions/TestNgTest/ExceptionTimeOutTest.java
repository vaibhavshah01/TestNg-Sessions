package TestNgTestSessions.TestNgTest;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
	// when some test case take longer than expected time then we use feature ' invocationTimeOut' to terminate that test case
	//when we know exception than we can handle with the feature ' expectedExeptions=numberFormatException.class'
	// in testNg we can handle the exception without using try catch block
	
//	@Test(invocationTimeOut=2)
	public void infintLoopTest() {
		int i = 1;
		while(i==1);
		System.out.println(i);
	}
	
	// expectedExceptions.class
	@Test(expectedExceptions=ArithmeticException.class)
	public void divison() {
		int i =9/0;
	}
	
	

}
