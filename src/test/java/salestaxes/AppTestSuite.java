package salestaxes;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AppTestSuite  extends TestSuite{
    
    static public Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(AppTest.class);
        return suite;
    }
    
}
