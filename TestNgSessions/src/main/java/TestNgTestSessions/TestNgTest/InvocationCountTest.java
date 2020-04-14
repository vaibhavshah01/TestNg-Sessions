package TestNgTestSessions.TestNgTest;

import org.testng.annotations.Test;

public class InvocationCountTest {

	// if we want to generate same test case multiple time we use 'invocationCount=5'
	
	@Test(invocationCount=5)
	public void sum() {
		int a =10;
		int b =20;
		int c = a+b;
		System.out.println("Sum is =="+ c);
	}
}
