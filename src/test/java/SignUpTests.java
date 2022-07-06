import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;


    public class SignUpTests {
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
            driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }


        @Test
        public void SignUpPositiveTest() {
            WebElement firstNameInput = driver.findElement(By.name("first_name"));
            firstNameInput.sendKeys("test");

            WebElement lastNameInput = driver.findElement(By.name("last_name"));
            lastNameInput.sendKeys("testov");

            WebElement emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("test@test.by");

            WebElement password1Input = driver.findElement(By.name("password1"));
            password1Input.sendKeys("12345");

            WebElement password2Input = driver.findElement(By.name("password2"));
            password2Input.sendKeys("12345");

            WebElement RegisterButton = driver.findElement(By.cssSelector("[value=\"Register\"]"));
            RegisterButton.click();

            softAssert.assertTrue(driver.findElement(By.name("keyword")).isDisplayed(),
                    "Account is created! should be displayed");
            softAssert.assertAll();
        }

        @Test
        public void SignUpNegativeTest() {
            WebElement firstNameInput = driver.findElement(By.name("first_name"));
            firstNameInput.sendKeys("test1");

            WebElement lastNameInput = driver.findElement(By.name("last_name"));
            lastNameInput.sendKeys("testov");

            WebElement emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("test@test.by");

            WebElement password1Input = driver.findElement(By.name("password1"));
            password1Input.sendKeys("12345");

            WebElement password2Input = driver.findElement(By.name("password2"));
            password2Input.sendKeys("12345");

            WebElement RegisterButton = driver.findElement(By.cssSelector("[value=\"Register\"]"));
            RegisterButton.click();

            softAssert.assertTrue(driver.findElement(By.cssSelector("[value=\"Register\"]")).isDisplayed(),
                    "Registr button should not be displayed");

            WebElement errorMessage = driver.findElement(By.className("error_message"));
               softAssert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
              String EXPECTED_ERROR_MESSAGE_TEXT = "Oops, error on page. Some of your fields have invalid data or email was previously used";
              softAssert.assertEquals(errorMessage.getText(),EXPECTED_ERROR_MESSAGE_TEXT,
                       "Error message should be displayed");

            softAssert.assertAll();
        }

        @Test
        public void SignUpSecondNegativeTest() {
            WebElement firstNameInput = driver.findElement(By.name("first_name"));
            firstNameInput.sendKeys("");

            WebElement lastNameInput = driver.findElement(By.name("last_name"));
            lastNameInput.sendKeys("");

            WebElement emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("");

            WebElement password1Input = driver.findElement(By.name("password1"));
            password1Input.sendKeys("");

            WebElement password2Input = driver.findElement(By.name("password2"));
            password2Input.sendKeys("");

            WebElement RegisterButton = driver.findElement(By.cssSelector("[value=\"Register\"]"));
            RegisterButton.click();

            softAssert.assertTrue(driver.findElement(By.cssSelector("[value=\"Register\"]")).isDisplayed(),
                    "Registr button should not be displayed");



            softAssert.assertAll();
        }

    }


