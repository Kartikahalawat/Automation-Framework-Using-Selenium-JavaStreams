import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

        // ------------------------------------------------------------
        // STEP 1: Click on the first column header to sort the table
        // ------------------------------------------------------------
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // ------------------------------------------------------------
        // STEP 2: Capture all elements from the first column
        // ------------------------------------------------------------
        List<WebElement> elementsList =
                driver.findElements(By.xpath("//tr/td[1]"));

        // ------------------------------------------------------------
        // STEP 3: Extract text from each WebElement
        // and store it in the original list
        // ------------------------------------------------------------
        List<String> originalList = elementsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        // ------------------------------------------------------------
        // STEP 4: Sort the original list and create a new sorted list
        // ------------------------------------------------------------
        List<String> sortedList = originalList.stream()
                .sorted()
                .collect(Collectors.toList());

        // ------------------------------------------------------------
        // STEP 5: Compare the original list with the sorted list
        // to verify that the table is sorted correctly
        // ------------------------------------------------------------
        Assert.assertTrue(
                originalList.equals(sortedList),
                "The table is not sorted correctly."
        );

        // List to store the price of the required vegetable/product
        List<String> price;

        // ------------------------------------------------------------
        // STEP 6: Search for "Rice" in the first column.
        // If Rice is not found on the current page, click Next
        // and continue searching on the next page.
        // ------------------------------------------------------------
        do {

            // Capture all rows from the first column
            List<WebElement> rows =
                    driver.findElements(By.xpath("//tr/td[1]"));

            // Find the row containing "Rice" and retrieve its price
            price = rows.stream()
                    .filter(s -> s.getText().contains("Rice"))
                    .map(WebTableSorting::getPriceVeggie)
                    .collect(Collectors.toList());

            // Print the price of Rice if found
            price.forEach(System.out::println);

            // If Rice is not found, click the Next button
            if (price.size() < 1) {
                driver.findElement(
                        By.cssSelector("[aria-label='Next']")
                ).click();
            }

        } while (price.size() < 1);

        // Close the browser
        driver.quit();
    }

    /**
     * Retrieves the price of a product from the next column
     * of the same table row.
     *
     * @param productElement WebElement representing the product name
     * @return Price of the product
     */
    private static String getPriceVeggie(WebElement productElement) {

        // Locate the price cell using the next sibling <td>
        String priceValue = productElement
                .findElement(By.xpath("following-sibling::td[1]"))
                .getText();

        return priceValue;
    }
}