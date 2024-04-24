import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.saucedemo.com/");

        // Log in (replace username and password with valid credentials)
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // // Wait for inventory page to load
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
    }

    @Test
    public void addToCartAndCheckout() {
        // Add the first item to the cart
        WebElement firstItem = driver.findElement(By.cssSelector(".inventory_item:first-child"));
        firstItem.findElement(By.className("btn_inventory")).click();

        // Go to the cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Click on checkout
        driver.findElement(By.id("checkout")).click();

        // Fill in checkout information
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        // Click on continue
        driver.findElement(By.id("continue")).click();

        // Finish checkout
        driver.findElement(By.id("finish")).click();

        // // Wait for order confirmation
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-text")));

        // Print order confirmation
        System.out.println("Order completed successfully!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
