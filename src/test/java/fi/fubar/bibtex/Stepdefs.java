package fi.fubar.bibtex;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration 
public class Stepdefs {

    WebDriver driver;

    @Before
    public void setupTest() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @LocalServerPort
    private Integer port;

    @Given("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        logInWith("foo", "bar");
    }
//
//    @Given("^has navigated to the \"([^\"]*)\" page$")
//    public void has_navigated_to_the_page(String arg1) throws Throwable {
//        assertTrue(driver.getCurrentUrl().contains("references"));
//    }
//
//    @When("^the entry \"([^\"]*)\" is entered into the field \"([^\"]*)\"$")
//    public void the_entry_is_entered_into_the_field(String entry, String field) throws Throwable {
//        WebElement elem = driver.findElement(By.name(field));
//        elem.sendKeys(entry);
//    }
//
//    @When("^the form is submitted$")
//    public void the_form_is_submitted() throws Throwable {
//        WebElement elem = driver.findElement(By.name("submit"));
//        elem.submit();
//    }
//
//    @Then("^a reference to \"([^\"]*)\" is added\\.$")
//    public void a_reference_to_is_added(String ref) throws Throwable {
//        assertTrue(driver.getCurrentUrl().contains("references"));
//        assertTrue(driver.getPageSource().contains(ref));
//    }

    private void logInWith(String foo, String bar) throws InterruptedException {
        driver.get("http://localhost:" + port);
        assertTrue(driver.getPageSource().contains("Login with Username and Password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(foo);
        element = driver.findElement(By.name("password"));
        element.sendKeys(bar);
        driver.findElement(By.cssSelector("input[type=submit]")).click();
        Thread.sleep(1000l);
    }

}
