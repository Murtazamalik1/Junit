import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {
    static UserRegistration user;
    @BeforeAll
    public static void initiate(){
        user = new UserRegistration();
    }

    @Test
    public void givenTextWhenItContainsFirstCapsInFnameAndMinThreeAlphabetsShouldReturnTrue() {
        try {
            String actual = user.validFirstName.validate("MURtaza");
            String expected = "Valid";
            Assertions.assertSame(actual, expected);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid first Name", e.getMessage());
        }
    }
        @Test
        public void givenTextWhenItDoesNotContainsFirstCapsInFnameShouldReturnTrue() {
            try {
                String actual = user.validFirstName.validate("murtaza");
                String expected = "Valid";
                Assertions.assertSame(actual, expected);
            } catch (UserRegistrationException e) {
                Assertions.assertEquals("Enter Valid first Name", e.getMessage());
            }
        }
    @Test
    public void givenTextWhenItContainsFirstCapsInFnameButNotMinThreeCharShouldReturnTrue() {
        try {
            String actual = user.validFirstName.validate("Sr");
            String expected = "Valid";
            Assertions.assertSame(actual, expected);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid first Name", e.getMessage());
        }
    }

    @Test
    public void givenTextWhenItContainsFirstCapsInSnameAndMinThreeAlphabetsShouldReturnTrue() {

        try {
            String actual = user.validSecondName.validate("Rani");
            String expected = "Valid";
            Assertions.assertSame(actual, expected);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Second Name", e.getMessage());
        }
    }

    @Test
    public void givenTextWhenItDoesNotContainsFirstCapsInSnameShouldReturnFalse() {
        try {
            String actual = user.validSecondName.validate("rani");
            String expected = "Valid";
            Assertions.assertSame(actual, expected);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Second Name", e.getMessage());
        }
    }

    @Test
    public void givenTextWhenItContainsFirstCapsInSnameButNotMinThreeCharShouldReturnFalse() {
        try {
            String actual = user.validSecondName.validate("Su");
            String expected = "Valid";
            Assertions.assertSame(actual, expected);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Second Name", e.getMessage());
        }
    }


    @Test
    public void givenEmailWhenDoesNotContainsAtTheRateShouldReturnFalse() {
        try {
            String actualResult = user.validEmailId.validate("kuabc.yahoo.com");
            String expectedRes = "Valid";
            Assertions.assertEquals(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Email Id", e.getMessage());
        }
    }


    @Test
    public void givenEmailWhenAccordingToProperReqShouldReturnTrue() {
        try {
            String actualResult = user.validEmailId.validate("abc.xyz@bl.co.in");
            String expectedRes = "Valid";
            Assertions.assertEquals(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Email Id", e.getMessage());
        }
    }

    @Test
    public void givenMobileNumberWithSpaceAndProperNumberShouldReturnTrue() {
        try {
            String actualResult = user.validPhoneNumber.validate("91 9066939699");
            String expectedRes = "Valid";
            Assertions.assertSame(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Phone Number", e.getMessage());
        }

    }

    @Test
    public void givenMobileNumberWithoutSpaceAndProperNumberShouldReturnFalse() {
        try {
            String actualResult = user.validPhoneNumber.validate("919066939699");
            String expectedRes = "Valid";
            Assertions.assertSame(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Phone Number", e.getMessage());
        }
    }

    @Test
    public void givenMobileNumberWithSpaceButNotProperCountryCodeShouldReturnFalse() {
        try {
            String actualResult = user.validPhoneNumber.validate("819066939699");
            String expectedRes = "Valid";
            Assertions.assertSame(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Phone Number", e.getMessage());
        }
    }

    @Test
    public void givenPasswordWithoutAnUpperCaseShouldReturnFalse() {
        try {
            String actualResult = user.validPassword.validate("abccc@123");
            String expectedRes = "Valid";
            Assertions.assertSame(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Password", e.getMessage());
        }

    }

    @Test
    public void givenPasswordWithoutASpecialCharShouldReturnFalse() {
        try {
            String actualResult = user.validPassword.validate("abccc123");
            String expectedRes = "Valid";
            Assertions.assertSame(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Password", e.getMessage());
        }
    }

    @Test
    public void givenPasswordWithoutALowerCaseShouldReturnFalse() {
        try {
            String actualResult = user.validPassword.validate("AAA@123");
            String expectedRes = "Valid";
            Assertions.assertSame(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Password", e.getMessage());
        }
    }

    @Test
    public void givenPasswordWithoutMinNumOfCharShouldReturnFalse() {
        try {
            String actualResult = user.validPassword.validate("Ac@123");
            String expectedRes = "Valid";
            Assertions.assertSame(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Password", e.getMessage());
        }
    }

    @Test
    public void givenPasswordWithProperRequirementsShouldReturnTrue() {
        try {
            String actualResult = user.validPassword.validate("Abcd@123");
            String expectedRes = "Valid";
            Assertions.assertSame(actualResult, expectedRes);
        } catch (UserRegistrationException e) {
            Assertions.assertEquals("Enter Valid Password", e.getMessage());
        }
    }
}