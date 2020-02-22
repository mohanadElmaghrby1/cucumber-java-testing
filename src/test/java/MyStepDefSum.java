//import com.mohannad.StringSum;
//import com.mohannad.exceptions.AhmedMisbahException;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//
///**
// * created by mohannad  on 11/02/20
// */
//public class MyStepDefSum {
//
//    long sum;
//    boolean flag = false;
//
//    @When("I input numbers {string} and {string}")
//    public void iInputNumbersAnd(String firstnum, String seconNum) {
//        try {
//            sum = StringSum.sum(firstnum,seconNum);
//        } catch (AhmedMisbahException e) {
//            e.printStackTrace();
//            flag = true;
//        }
//    }
//
//    @Then("I should get the result {long}")
//    public void iShouldGetTheResult(long result) {
//        Assert.assertEquals(result , sum);
//    }
//
//
//    @Then("I should get an error")
//    public void iShouldGetAnError() {
//        Assert.assertTrue(flag);
//    }
//
//}
