import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import info.maigo.lab.wc.ContentTypeTest;
import info.maigo.lab.wc.GetRequestTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ContentTypeTest.class,
    GetRequestTest.class,
})

public class AllTests {
    // the class remains empty,
    // used only as a holder for the above annotations
}

