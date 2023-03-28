import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;

@RunWith(Parameterized.class)
    public class UserRegistrationParameterizedTest {

        private final String email;
        private final String expectedResult;
        private UserRegistration read;

        public UserRegistrationParameterizedTest(String email, String expectedResult) {
            this.email = email;
            this.expectedResult = expectedResult;
        }

        @Before
        public void init() {
            read = new UserRegistration();
        }

        @Parameterized.Parameters
        public static Collection emailInput() {
            return Arrays
                    .asList(new Object[][] { { "abhi@@yahoo.com", "Valid" }, { "abc.xyz@bl.co.india", "Valid" },
                            { "abc.xyz$bl.co.in", "Valid" }, { "abc.xyz@bl.co.in", "Valid" } });
        }

        @Test
        public void testEmail() {
            assertEquals(expectedResult, read.validEmailId(email));
        }
}
