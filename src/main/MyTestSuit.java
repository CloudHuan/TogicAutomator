package main;

import Utils.Println;
import junit.framework.TestSuite;

public class MyTestSuit {
	
	public static TestSuite RunAllMetro(){
		new Println("运行测试集");
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestDemo.class);
		return suite;
	}
}
