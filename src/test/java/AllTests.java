import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import info.maigo.lab.wc.ContentTypeTest;
import info.maigo.lab.wc.GetRequestTest;
import info.maigo.lab.wc.HeadersTest;
import info.maigo.lab.wc.ResponseTest;
import info.maigo.lab.wc.StringUtilsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ContentTypeTest.class,
    GetRequestTest.class,
    HeadersTest.class,
    ResponseTest.class,
    StringUtilsTest.class,
})

public class AllTests {
    // the class remains empty,
    // used only as a holder for the above annotations
}

