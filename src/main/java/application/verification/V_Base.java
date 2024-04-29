package application.verification;

import org.testng.Assert;

public class V_Base {

    public void verifyEqual(String expected, String actual){
        try{
            Assert.assertEquals(expected,actual);
        }
        catch (Exception ex){
            System.out.println("Assertion failed expected: "+expected+" found "+actual);
        }
    }

    public void verifyConditionIsTrue(boolean condition){
        try{
            Assert.assertTrue(condition);
        }
        catch (Exception ex){
            System.out.println("Assertion failed expected: condition is false ");
        }
    }

}
