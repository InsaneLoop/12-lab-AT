import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update the path to your WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testUser", "testPassword");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dataTable")));

        TableHelper tableHelper = new TableHelper(tableElement);

        int rowCount = tableHelper.getRowCount();
        int colCount = tableHelper.getColumnCount();
        String cellData = tableHelper.getCellData(1, 1);

        System.out.println("Row count: " + rowCount);
        System.out.println("Column count: " + colCount);
        System.out.println("Cell data: " + cellData);

        driver.quit();
    }
}