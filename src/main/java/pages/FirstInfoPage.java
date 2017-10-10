package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FirstInfoPage extends InitPage {

    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement buttonAlertOk;

    @AndroidFindBy(id = "com.whatsapp:id/eula_accept")
    private AndroidElement buttonRulesAgree;

    public void clickToAlertButtonOk()
    {
        buttonAlertOk.click();
    }

    public RegistrationPage clickToAgreeWithRules()
    {
        buttonRulesAgree.click();
        return new RegistrationPage();
    }
}
