package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * RetryAnnotationTransformer
 *
 * Automatically attaches RetryAnalyzer to every @Test method at runtime.
 * This means you never have to write:
 *     @Test(retryAnalyzer = RetryAnalyzer.class)
 * on any individual test — it is applied globally via testng.xml.
 */
public class RetryAnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
