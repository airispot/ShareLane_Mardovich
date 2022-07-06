import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownTest extends BaseTest {

    WebDriver driver;
    SoftAssert softAssert;
    @BeforeClass
    public void setUp() {
        softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void selectDropdownTest() {
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByIndex(1);
        select.selectByValue("2");
        select.selectByVisibleText("Option 1");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        List<WebElement> allOptions =  select.getOptions();
        List <String> allOptionNames = allOptions.stream().map(option -> option.getText()).collect(Collectors.toList());

        List <String> allOptionNames1 = new ArrayList<>();
        for (WebElement option: allOptions) {
            allOptionNames1.add(option.getText());
        }
        List<String> expectedOptionNames = new ArrayList<>();
        expectedOptionNames.add("Please select an option");
        expectedOptionNames.add("Option 1");
        expectedOptionNames.add("Option 2");
        Assert.assertEquals(allOptionNames, expectedOptionNames);
    }


}