import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.IOException;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        Result result = JUnitCore.runClasses(PriorityQueueTest.class);
        for (Failure failure : result.getFailures()) {
            throw new IOException(failure.toString());
        }
    }
}
