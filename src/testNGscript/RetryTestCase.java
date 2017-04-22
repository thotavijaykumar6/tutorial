package testNGscript;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryTestCase implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 5;

    int x=2;
    int y=4;
    public boolean retry(ITestResult result) {

        if (retryCount <= maxRetryCount+1) {
            retryCount++;
            return true;
        }
        return false;
    }

    @Test(priority =0, retryAnalyzer = RetryTestCase.class, alwaysRun = true)
    public void a() {
        Assert.assertEquals(true, true); // ListenerTest fails
    }
    
    @Test(priority =1, retryAnalyzer = RetryTestCase.class, alwaysRun = true)
    public void testGenX() {
        Assert.assertEquals(x++, y); // ListenerTest fails
    }

    @Test(priority =2, retryAnalyzer = RetryTestCase.class, alwaysRun = true)
    public void z() {
        Assert.assertEquals(true, true); // ListenerTest fails
    }
    
    
}