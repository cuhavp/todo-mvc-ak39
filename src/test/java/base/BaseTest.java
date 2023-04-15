package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    @AfterMethod
    protected void captureScreenWhenFail(ITestResult iTestResult)
    {
        if(!iTestResult.isSuccess()){
           Browser.captureScreen(iTestResult.getMethod().getMethodName());
        }
    }
}
