package com.submission.server.service;

import com.submission.server.controller.request.SubmissionRequest;
import com.submission.server.controller.response.SubmissionResponse;
import com.submission.server.resource.Submissions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubmissionServiceTests {

    @Test
    public void test(){
        SubmissionRequest request = new SubmissionRequest();
        request.setName("Michelle");

        SubmissionService service = new SubmissionService(new Submissions());
        SubmissionResponse response = service.submit(request);

        Assert.assertEquals("Michelle", response.getName());
        Assert.assertEquals("Hello Michelle. A name has been submitted 1 time since this app has been running.", response.getMessage());

        response = service.submit(request);
        Assert.assertEquals("Michelle", response.getName());
        Assert.assertEquals("Hello Michelle. A name has been submitted 2 times since this app has been running.", response.getMessage());
    }
}
