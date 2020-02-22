//import com.mohannad.StringSum;
//import com.mohannad.exceptions.AhmedMisbahException;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
///**
// * created by mohannad  on 09/02/20
// */
//public class StringSumTest {
//
//    @Test
//    public void testHappyValue()throws AhmedMisbahException{
//        String firstValue= "1";
//        String secondValue= "2";
//        long sum = StringSum.sum(firstValue , secondValue);
//        long expectedResult = 3l;
//        Assert.assertEquals(expectedResult, sum);
//    }
//
//    @Test
//    public void testHappyValueWithZero()throws AhmedMisbahException{
//        String firstValue= "0";
//        String secondValue= "2";
//        long sum = StringSum.sum(firstValue , secondValue);
//        long expectedResult = 2l;
//        Assert.assertEquals(expectedResult, sum);
//    }
//
//    @Test
//    public void testHappyValueWithOnlyZeros()throws AhmedMisbahException{
//        String firstValue= "0";
//        String secondValue= "0";
//        long sum = StringSum.sum(firstValue , secondValue);
//        long expectedResult = 0l;
//        Assert.assertEquals(expectedResult, sum);
//    }
//
//
//    @Test(expected=Exception.class)
//    public void testHappyValueWithAveryLongNumber()throws AhmedMisbahException{
//        String firstValue= "0";
//        String secondValue= "10000000000000000000000000000000000000000";
//        StringSum.sum(firstValue , secondValue);
//    }
//
//    @Test
//    public void testValueWithAveryNegativeNumbers(){
//        String firstValue= "0";
//        String secondValue= "-5";
//        String expectedErrorMEssage = "this is not a number";
//        try{
//            StringSum.sum(firstValue , secondValue);
//            Assert.fail();
//        }catch (AhmedMisbahException exception){
//            Assert.assertEquals(expectedErrorMEssage , exception.getMessage());
//        }
//    }
//
//    @Test
//    public void testValueWithAveryNegativeDecimalNumbers(){
//        String firstValue= "-.5";
//        String secondValue= "5";
//        String expectedErrorMEssage = "this is not a number";
//        try{
//            StringSum.sum(firstValue , secondValue);
//            Assert.fail();
//        }catch (AhmedMisbahException exception){
//            Assert.assertEquals(expectedErrorMEssage , exception.getMessage());
//        }
//    }
//
//    @Test
//    public void testValueWithChars(){
//        String firstValue= "ab";
//        String secondValue= "5";
//        String expectedErrorMEssage = "this is not a number";
//        try{
//            StringSum.sum(firstValue , secondValue);
//            Assert.fail();
//        }catch (AhmedMisbahException exception){
//            Assert.assertEquals(expectedErrorMEssage , exception.getMessage());
//        }
//    }
//}
