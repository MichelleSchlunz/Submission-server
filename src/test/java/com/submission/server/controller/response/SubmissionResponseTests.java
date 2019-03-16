package com.submission.server.controller.response;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubmissionResponseTests {

    @Test
    public void test_Validate(){
        SubmissionResponse response = new SubmissionResponse("Michelle", 1);

        Assert.assertEquals("Michelle", response.getName());
        Assert.assertEquals("Hello Michelle. A name has been submitted 1 time since this app has been running.", response.getMessage());

        response = new SubmissionResponse(null, 2);

        Assert.assertEquals(null, response.getName());
        Assert.assertEquals("Hello . A name has been submitted 2 times since this app has been running.", response.getMessage());

        response = new SubmissionResponse("", 10);

        Assert.assertEquals("", response.getName());
        Assert.assertEquals("Hello . A name has been submitted 10 times since this app has been running.", response.getMessage());
    }

}
