package analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count = 0;
	int retryLimit = 3; // how many times failed test wants to run

	@Override
	public boolean retry(ITestResult result) {  // ITestResult is class which describes the result of a test
		// TODO Auto-generated method stub
		if (count < retryLimit) {
			count++;
			return true;   // returns true if the test method has to be retried
		}
		return false;    // otherwise false
	}

}
