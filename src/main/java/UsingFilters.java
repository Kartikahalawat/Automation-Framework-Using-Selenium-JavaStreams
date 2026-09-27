import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UsingFilters {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

        // ------------------------------------------------------------
        // Search for "Rice" using the search field
        // ------------------------------------------------------------
        driver.findElement(By.id("search-field"))
                .sendKeys("Rice");

        // ------------------------------------------------------------
        // Capture all product names displayed in the table
        // ------------------------------------------------------------
        List<WebElement> veggies =
                driver.findElements(By.xpath("//tr/td[1]"));

        // ------------------------------------------------------------
        // Filter the list using Java Stream API
        // Keep only those products whose name contains "Rice"
        // ------------------------------------------------------------
        List<WebElement> filteredList = veggies.stream()
                .filter(veg -> veg.getText().contains("Rice"))
                .collect(Collectors.toList());

        // ------------------------------------------------------------
        // Verify that all displayed products match
        // the search/filter condition
        // ------------------------------------------------------------
        Assert.assertEquals(
                veggies.size(),
                filteredList.size(),
                "Search results contain products other than Rice."
        );

        // Close the browser
        driver.quit();
    }
}