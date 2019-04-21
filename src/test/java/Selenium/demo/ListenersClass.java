package Selenium.demo;

import java.util.Set;

import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getTestClass().getName() +" "+ result.getTestName()+" started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getTestClass().getName() +" "+ result.getTestName()+" success");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getTestClass().getName() +" "+ result.getTestName()+" failure");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getTestClass().getName() +" "+ result.getTestName()+" failure");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestNGMethod[] it=context.getAllTestMethods();
		for(ITestNGMethod i:it) {
			System.out.println(i.getMethodName());
		}
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		IResultMap it=context.getPassedTests();
		Set<ITestResult> i=it.getAllResults();
		for(ITestResult r:i) {
			System.out.println(r.getTestClass().getName());
		}
	}

}
