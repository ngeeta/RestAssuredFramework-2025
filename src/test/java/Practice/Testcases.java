package Practice;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class Testcases extends TestListener {
@Test	
public void getPassMethod(Method m) {
	extentTest=extentReports.createTest(m.getName());
	int a=10;
	int b=20;
	extentTest.info("value of a "+a);
	extentTest.info("value of b "+b);
	int c=a+b;
	Assert.assertEquals(c, 30);
	extentTest.info("value of c "+c);

	System.out.println("Pass");
}

@Test	
public void getFailMethod(Method m) {
	extentTest=extentReports.createTest(m.getName());
	int a=25;
	int b=1000;
	extentTest.info("value of a "+a);
	extentTest.info("value of b "+b);
	Assert.assertEquals(a, b);

	System.out.println("fail");
}
}
