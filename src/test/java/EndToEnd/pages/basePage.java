package EndToEnd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class basePage {

    protected WebDriver driver;
    private JavascriptExecutor jse;

    public basePage(WebDriver driver) {
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        if (driver != null) {
            this.driver = driver;
        } else {
            this.driver = new ChromeDriver();
        }
    }

    public void start(String URL) {
        driver.navigate().to(URL);
        driver.manage().window().maximize();

    }

    public void close() {
        driver.quit();
    }

    public void click(Object o) {
        try {
            if (o instanceof By) {
                click(driver.findElement((By) o));
            } else if (o instanceof WebElement) {
                click((WebElement) o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeys(Object o, String values){
        try {
            if (o instanceof By) {
                driver.findElement((By) o).sendKeys(values);
            } else if (o instanceof WebElement) {
                ((WebElement) o).sendKeys(values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void click(WebElement element) {
        try {
            jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, " + element.getLocation().y + ")");
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollToEnd() {
        boolean move = true;
        jse = (JavascriptExecutor) driver;
        long lastHeight = (Long) jse.executeScript("return document.body.scrollHeight");

        try {
            while (move) {
                jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);
                long newHeight = (Long) jse.executeScript("return document.body.scrollHeight");

                if (newHeight == lastHeight)
                    move = false;

                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {

        }

    }

    public void waitSeconds(long seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void waitTime(final int millisegundos) {
        try {
            Thread.sleep(millisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveCursor(WebElement element) {
        Actions action = new Actions(driver);

        action.moveToElement(element).build().perform();
    }

    public void moveCursorToClick(WebElement element) {
        Actions action = new Actions(driver);

        action.moveToElement(element).click().build().perform();
    }

    public void scrollEasy() {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("scrollBy(0,3000)");
    }

    public void scrollToElement(WebElement element) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
}
