package utils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager {

    private AndroidDriver androidDriver;
    private static DriverManager instance;
    private final String URL_ADDRESS = "http://10.6.102.43:4814/wd/hub";

    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null)
                    instance = new DriverManager();
            }
        }
        return instance;
    }

    private void createDriver() {
        try {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformVersion","5.1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.whatsapp");
        capabilities.setCapability("appActivity","com.whatsapp.registration.EULA");

        File file = new File ("src\\main\\resources\\app\\WhatsApp.apk");
        capabilities.setCapability("app", file.getAbsolutePath());
        androidDriver = new AndroidDriver(new URL(URL_ADDRESS), capabilities);

        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Illegal URL address: " + URL_ADDRESS, e);
        }
    }

    public AndroidDriver getAndroidDriver()
    {
        if (androidDriver == null) {
            createDriver();
        }
        return androidDriver;
    }

    public void quit() {
        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        }
    }
}
