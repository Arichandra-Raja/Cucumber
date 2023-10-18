package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    private static boolean headlessMode = false; // Default to false

    public static void setHeadlessMode(boolean headless) {
        headlessMode = headless;
    }

    public static boolean isHeadlessMode() {
        return headlessMode;
    }

    public static WebDriver initializeDriver() {
        if (driver.get() == null) { 
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if (headlessMode) {
                options.addArguments("--headless");
            }

            driver.set(new ChromeDriver(options));

            driver.get().manage().window().maximize();
            wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(10)));
        }  
        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            wait.remove();
        }
    }
}
