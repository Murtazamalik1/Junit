import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    public String validFirstName(String fName) throws UserRegistrationException  {
        Pattern pattern = Pattern.compile("^[A-Z]{3}[a-z]{1,10}");

        Matcher match = pattern.matcher(fName);
        if (match.matches())
            return "Valid";
        else
            throw new UserRegistrationException("Enter Valid first Name");
    }

    public String validSecondName(String sName) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^[a-z]{2,10}[A-Z]{3}$");
        Matcher match = pattern.matcher(sName);
        if (match.matches())
            return "Valid";
        else
            throw new UserRegistrationException("Enter Valid last Name");
    }

    public String validEmailId(String email) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^[a-z0-9]{1,20}([_.+-][a-z0-9]+)?@[a-z0-9]+.[a-z]{2,3}(.[a-z]{2})?$");

        Matcher match = pattern.matcher(email);
        if (match.matches())
            return "Valid";
        else
            throw new UserRegistrationException("Enter Valid Email Id");
    }

    public String validPhoneNumber(String phoneNumber) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^91\s[6-9][0-9]{9}$");

        Matcher match = pattern.matcher(phoneNumber);
        if (match.matches())
            return "Valid";
        else
            throw new UserRegistrationException("Enter Valid Phone Number");
    }
    public String validPassword(String password) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=])?.{8,}$");
        Matcher match = pattern.matcher(password);
        if (match.matches())
            return "Valid";
        else
            throw new UserRegistrationException("Enter Valid Password");
    }
}
