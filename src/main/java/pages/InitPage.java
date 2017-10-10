package pages;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class InitPage {

    private final DriverManager driverManager = DriverManager.getInstance();

    public InitPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driverManager.getAndroidDriver()), this);
    }
}
