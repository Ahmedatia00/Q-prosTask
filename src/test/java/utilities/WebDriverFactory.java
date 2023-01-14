//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    private static WebDriver _driver = null;

    public WebDriverFactory() {
    }

    public static WebDriver getDriver() {
        String browser = PropertyReader.getProperty("BROWSER");
        if (_driver == null) {
            String var1 = browser.toLowerCase();
            byte var2 = -1;
            switch(var1.hashCode()) {
                case -1361128838:
                    if (var1.equals("chrome")) {
                        var2 = 0;
                    }
                    break;
                case -849452327:
                    if (var1.equals("firefox")) {
                        var2 = 2;
                    }
                    break;
                case 1004944517:
                    if (var1.equals("headless-firefox")) {
                        var2 = 3;
                    }
                    break;
                case 1885279054:
                    if (var1.equals("headless-chrome")) {
                        var2 = 1;
                    }
            }

            switch(var2) {
                case 0:
                    WebDriverManager.chromedriver().setup();
                    _driver = new ChromeDriver(chromeOptions());
                    break;
                case 1:
                    WebDriverManager.chromedriver().setup();
                    _driver = new ChromeDriver(headlessChromeOptions());
                    break;
                case 2:
                    WebDriverManager.firefoxdriver().setup();
                    _driver = new FirefoxDriver();
                    break;
                case 3:
                    WebDriverManager.firefoxdriver().setup();
                    _driver = new FirefoxDriver(headlessFirefoxOptions());
                    break;
                default:
                    System.out.println("Invalid browser option");
                    System.exit(1);
            }
        }

        return _driver;
    }

    public static void stopDriver() {
        _driver.quit();
        _driver = null;
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.addArguments(new String[]{"--lang=de"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    private static ChromeOptions headlessChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments(new String[]{"windows-size=3000,2000"});
        return options;
    }

    private static FirefoxOptions headlessFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        return options;
    }
}
