import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableSorting {
    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all webelements into new list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        //capture text of all webelements into new(original) list
        List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        //sort on the original list of step-3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        Assert.assertEquals(originalList, sortedList);

    }
}
