import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.FirstInfoPage;
import pages.RegistrationPage;
import utils.DriverManager;
import java.net.MalformedURLException;


public class CheckRegistrationPhoneNumberTest {

    private FirstInfoPage firstInfoPage;
    private RegistrationPage registrationPage;

    @Test (groups = "actualCountryCode")
    public void checkActualCountryByCountryCode() throws MalformedURLException, InterruptedException {

        firstInfoPage = new FirstInfoPage();
        firstInfoPage.clickToAlertButtonOk();
        registrationPage = firstInfoPage.clickToAgreeWithRules();
        registrationPage.setValueOfContryCodePhoneNumber();
        String country = registrationPage.getCountryValue();
        Assert.assertEquals( country, "Italia");
    }

    @Test(groups = "correctMessage", dependsOnGroups = "actualCountryCode")
    public void checkMessage()
    {
        registrationPage.clickToConfirmationButton();
        String message = registrationPage.getMessageInformation();
        Assert.assertEquals(message,"Please enter your phone number.");
    }

    @Test(groups = "incorrectPhoneNumber", dependsOnGroups = "correctMessage")
    public void checkPhoneNumber()
    {
        registrationPage.setFieldOfPhoneNumber();
        registrationPage.clickToConfirmationButton();
        String message = registrationPage.getMessageInformation();
        Assert.assertTrue(message.contains("too long"));
    }

    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().quit();
    }
}
