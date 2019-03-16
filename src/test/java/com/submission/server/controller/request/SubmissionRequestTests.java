package com.submission.server.controller.request;

import com.submission.server.exception.BadRequestException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubmissionRequestTests {

    private BadRequestException exceptionThrown;
    private SubmissionRequest request;

    @Before
    public void beforeTest(){
        exceptionThrown = null;
        request = new SubmissionRequest();
    }

    @Test
    public void test_ValidateName_Null(){
        try{
            request.validateName();
        }catch (BadRequestException bre){
            exceptionThrown = bre;
        }
        Assert.assertEquals("Please provide your name", exceptionThrown.getMessage());
    }

    @Test
    public void test_ValidateName_Empty(){
        request.setName("");
        try{
            request.validateName();
        }catch (BadRequestException bre){
            exceptionThrown = bre;
        }
        Assert.assertEquals("Please provide your name", exceptionThrown.getMessage());
    }

    @Test
    public void test_ValidateName(){
        request.setName("Michelle");
        try{
            request.validateName();
        }catch (BadRequestException bre){
            exceptionThrown = bre;
        }
        Assert.assertNull(exceptionThrown);
        Assert.assertEquals("Michelle", request.getName());
    }
}
