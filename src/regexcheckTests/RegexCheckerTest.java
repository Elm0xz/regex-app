package regexcheckTests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Przemyslaw_Etz on 2016-12-12.
 */
public class RegexCheckerTest {

    private final String testRegexText = "xxx";
    private final String testStringText = "yyy";

    @Test
    public void testRegexCheck() {
        assertEquals(testRegexText, testStringText);
    }
}
