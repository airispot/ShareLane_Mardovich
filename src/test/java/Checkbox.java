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


public class Checkbox {
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
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
     @Test
        public void selectCheckBoxTest () {


         WebElement CheckBoxAB = driver.findElement(By.cssSelector("[type=checkbox]"));


         List<WebElement> CheckBox = driver.findElements(By.cssSelector("[type=checkbox]"));
         CheckBox.get(0).isSelected();
         CheckBox.get(1).isSelected();


        //WebElement CheckBoxA = driver.findElement(By.cssSelector(""));

        Assert.assertFalse(driver.findElement(By.cssSelector("[type=checkbox]")).isSelected());




        softAssert.assertAll();

     }}

