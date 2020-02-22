import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.*;
import com.mohannad.model.User;
import io.cucumber.datatable.DataTable;
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

    WireMockServer wireMockServer;

//    @Rule
//    public WireMockRule wireMockRule = new WireMockRule(8090);

    @Given("the following user exist in the system")
    public void theFollowingUserExsistInTheSystem(DataTable existingUsers) throws IOException {
//        this.existingUsers=validUsers;
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        // Mock server
//        WireMockServer wireMockServer = new WireMockServer(options().port(8080));
//        wireMockServer.start();
//        configureFor("localhost", wireMockServer.port());
//        stubFor(get(urlEqualTo("/api/login"))
//                .withHeader("content-type", equalTo("application/json"))
//                .withRequestBody(containing("testing-framework"))
//                .willReturn(aResponse().withStatus(200)));

//        HttpGet request = new HttpGet("http://localhost:8080/login/api");
//        request.addHeader("accept", "application/json");
//        HttpResponse httpResponse = httpClient.execute(request);
//        String responseString = convertResponseToString(httpResponse);

//        assertThat(responseString, containsString("testing-framework"));
//        verify(getRequestedFor(urlEqualTo("/api/login"))
//                .withHeader("accept", equalTo("application/json")));

//        configureFor("localhost", wireMockServer.port());
//        stubFor(get(urlEqualTo("/api/login"))
//                .withHeader("Accept", equalTo("text/xml"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "text/xml")
//                        .withBody("<response>Some content</response>")));

//        wireMockRule.stubFor(post(urlEqualTo("/some/url"))
//                .withRequestBody(containing("BODY"))
//                .withHeader("NoSuchHeader", equalTo("This better not be here"))
//                .willReturn(aResponse().withStatus(200)));
////
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpResponse response = client.execute(new HttpGet("http://localhost:8090/api/login"));
//        int statusCode = response.getStatusLine().getStatusCode();
//        assertThat(statusCode, equalTo(HttpStatus.SC_OK));

        System.setProperty("webdriver.gecko.driver", "/home/mohannad/Downloads/driver/geckodriver");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @When("I login with my credentials")
    public void iLoginWithMyCredentials(DataTable emailAndPAssword) {
        driver.get("http://localhost:4200/login");
        driver.findElement(By.id("username")).sendKeys("hammad@gmail.com");
        driver.findElement(By.id("password")).sendKeys("abcd12");
        driver.findElement(By.id("button")).click();
    }

    @Then("I should login to the application and see a welcome message")
    public void iShouldLoginToTheApplicationAndSeeAWelcomeMessage() {
        WebElement WelcomeMessage = driver.findElement(By.className("icon-rx"));
        Assert.assertEquals(true, WelcomeMessage.isDisplayed());


    }

//    @When("I input  <email> and <password>")
//    public void iInputEmailAndPassword() {
//        throw new io.cucumber.java.PendingException();
//
//    }
//
//    @Then("I should get <invalidmessage>")
//    public void iShouldGetInvalidmessage() {
//        throw new io.cucumber.java.PendingException();
//
//    }
//
//    @And("I should not be logged in")
//    public void iShouldNotBeLoggedIn() {
//        throw new io.cucumber.java.PendingException();
//
//    }
//
//    @When("a user attempts to access the application without login")
//    public void aUserAttemptsToAccessTheApplicationWithoutLogin() {
//        throw new io.cucumber.java.PendingException();
//
//    }
//
//    @Then("I should be redirected to login")
//    public void iShouldBeRedirectedToLogin() {
//        throw new io.cucumber.java.PendingException();
//
//    }
//
//    @And("I should get {string}")
//    public void iShouldGet(String arg0) {
//        throw new io.cucumber.java.PendingException();
//    }

//    @After
//    public void closeBrowser(){
//        driver.close();
//    }

    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }
}
