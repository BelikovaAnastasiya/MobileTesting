package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegistrationPage extends InitPage {

    @AndroidFindBy(id = "com.whatsapp:id/registration_cc")
    private AndroidElement fieldOfCountryCodeInPhoneNumber;

    @AndroidFindBy(id = "com.whatsapp:id/registration_phone")
    private AndroidElement fieldOfPhoneNumber;

    @AndroidFindBy(id = "com.whatsapp:id/registration_country")
    private  AndroidElement nameOfSelectedCountryByCountryCode;

    @AndroidFindBy(id = "com.whatsapp:id/registration_submit")
    private AndroidElement confirmationButton;

    @AndroidFindBy(id = "android:id/message")
    private AndroidElement messageWindow;

    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement buttonToCloseMessageWindow;

    public void setValueOfContryCodePhoneNumber()
    {
        fieldOfCountryCodeInPhoneNumber.click();
        fieldOfCountryCodeInPhoneNumber.clear();
        fieldOfCountryCodeInPhoneNumber.sendKeys("39");
    }

    public String getCountryValue()
    {
        return nameOfSelectedCountryByCountryCode.getText();
    }

    public void clickToConfirmationButton()
    {
        confirmationButton.click();
    }

    public String getMessageInformation()
    {
        String message = messageWindow.getText();
        buttonToCloseMessageWindow.click();
        return message;
    }

    public void setFieldOfPhoneNumber()
    {
        fieldOfPhoneNumber.sendKeys("12345678912");
    }
}
