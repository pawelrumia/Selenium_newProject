package runner;

import com.JavaSelenium.tests.TestPage;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JUnitTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestPage.class);

        System.out.println("Total number of tests " + result.getRunCount());
        System.out.println("Total number of tests failed " + result.getFailureCount());

        for(Failure failure : result.getFailures())
        {
            //This will print message only in case of failure
            System.out.println(failure.getMessage());
        }
    }
}
