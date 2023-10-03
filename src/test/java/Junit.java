import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Junit {
    String link = "https://www.digitalunite.com/practice-webform-learners";
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    @Test
    public void submission() throws InterruptedException {
        driver.get(link);
        driver.findElement(By.id("edit-name")).sendKeys("Ratul Hasan");

        driver.findElement(By.id("edit-number")).sendKeys("01401245563");

        driver.findElement(By.cssSelector("[for = \"edit-agnew-20-30\"]")).click();


        driver.findElement(By.id("edit-date")).sendKeys("09,27,2001");
        driver.findElement(By.id("edit-email")).sendKeys("ratul2001@gmail.com");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I'm a SQA engineer");

        WebElement fileInput = driver.findElement(By.id("edit-uploadocument-upload"));
        fileInput.sendKeys(".src/test/resources/gallery-1.jpg");


        JavascriptExecutor sc= (JavascriptExecutor) driver;
        sc.executeScript("window.scrollTo(0,1300)");

        Thread.sleep(200);

        driver.findElement(By.id("edit-age")).click();

        WebElement submit = driver.findElement(By.id("edit-submit"));
               submit.click();






        String actual = driver.findElement(By.id("block-pagetitle-2")).getText();
        Assertions.assertEquals("Thank you for your submission!", actual);
    }


}
