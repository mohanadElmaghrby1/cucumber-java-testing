import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.*;
import com.mohannad.model.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.github.tomakehurst.wiremock.client.WireMock.*;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * created by mohannad  on 12/02/20
 */
public class LoginStepdefs {

    private List<User> existingUsers;
    WebDriver driver;

    @Given("the following user exist in the system")
    public void theFollowingUserExsistInTheSystem(DataTable existingUsers) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KMCL9403\\Desktop\\drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("I login with my credentials")
    public void iLoginWithMyCredentials(DataTable emailAndPAssword) {
        driver.get("http://localhost:4200/login");
        driver.findElement(By.id("username")).sendKeys("amisbah.ext@orange.com");
        driver.findElement(By.id("password")).sendKeys("1234567890");
        driver.findElement(By.id("button")).click();
    }

    @Then("I should login to the application and see a welcome message")
    public void iShouldLoginToTheApplicationAndSeeAWelcomeMessage( DataTable emailAndPAssword) {
        WebElement WelcomeMessage=null;
        try {
            WelcomeMessage = driver.findElement(By.id("welcomemessage"));
            Assert.assertEquals(true, WelcomeMessage.isDisplayed());
        }catch (Exception e){
            Assert.fail();
        }
    }

    @When("I login with my invalid credentials")
    public void iLoginWithInvalidCredentials(DataTable emailAndPAssword) {
        driver.get("http://localhost:4200/login");
        driver.findElement(By.id("username")).sendKeys("oob.ext@orange.co");
        driver.findElement(By.id("password")).sendKeys("2112");
        driver.findElement(By.id("button")).click();
    }

    @Then("I should get invalid email or password alert message")
    public void iShouldGetAlertMessage( ) {
        WebElement alertMessage=null;
        try {
            alertMessage = driver.findElement(By.id("alert-message"));
            Assert.assertEquals(true, alertMessage.isDisplayed());
        }catch (Exception e){
            Assert.fail();
        }
    }


    @After
    public void closeBrowser(){
        driver.close();
    }

    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }
}
