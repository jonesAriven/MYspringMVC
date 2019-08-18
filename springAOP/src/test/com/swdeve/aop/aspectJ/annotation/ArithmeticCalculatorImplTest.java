package test.com.swdeve.aop.aspectJ.annotation;

import com.swdeve.aop.aspectJ.annotation.ArithmeticCalculatorImpl;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ArithmeticCalculatorImpl Tester.
 *
 * @author <Authors name>
 * @since <pre>08/13/2019</pre>
 * @version 1.0
 */
public class ArithmeticCalculatorImplTest extends TestCase {
    public ArithmeticCalculatorImplTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(ArithmeticCalculatorImplTest.class);
    }

    @org.junit.Test
    public void testAop(){
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArithmeticCalculatorImpl arithmeticCalculator = act.getBean("arithmeticCalculatorImpl",ArithmeticCalculatorImpl.class);
        arithmeticCalculator.sum(1, 2);
    }
}
