import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class TestAddElement {
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
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TestAdd() {
        WebElement buttonAddElement = driver.findElement(By.xpath("//button[text()='Add Element']"));

        List<WebElement> buttonDeleteElement = driver.findElements(By.xpath("//button[text()='Add Element']"));
        buttonAddElement.click();

        buttonDeleteElement = driver.findElements(By.xpath("//button[text()='Delete']"));

        Assert.assertEquals(buttonDeleteElement.size(), 1);

        buttonAddElement.click();
        buttonAddElement.click();

        buttonDeleteElement = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(buttonDeleteElement.size(), 3 );


        softAssert.assertAll();

}}

