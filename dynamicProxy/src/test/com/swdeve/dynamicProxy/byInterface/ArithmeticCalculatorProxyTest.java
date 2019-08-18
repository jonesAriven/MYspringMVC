package test.com.swdeve.dynamicProxy.byInterface;

import com.swdeve.dynamicProxy.byInterface.ArithmeticCalculator;
import com.swdeve.dynamicProxy.byInterface.ArithmeticCalculatorImpl;
import com.swdeve.dynamicProxy.byInterface.ArithmeticCalculatorProxy;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.util.Properties;

/**
 * ArithmeticCalculatorProxy Tester.
 *
 * @author <Authors name>
 * @since <pre>08/11/2019</pre>
 * @version 1.0
 */
public class ArithmeticCalculatorProxyTest extends TestCase {
    public ArithmeticCalculatorProxyTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetProxy() throws Exception {
        //将动态生成的代理类保存下来，生成的class文件在和当前的代理类同目录
//        Properties properties = System.getProperties();
//        properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //目标对象
        ArithmeticCalculator arith = new ArithmeticCalculatorImpl();
        //获取代理对象
        Object obj = new ArithmeticCalculatorProxy(arith).getProxy();
        //转回具体类型
        ArithmeticCalculator arithProxy = (ArithmeticCalculator)obj;
        arithProxy.sum(1, 2);
    }

    public static Test suite() {
        return new TestSuite(ArithmeticCalculatorProxyTest.class);
    }
}
