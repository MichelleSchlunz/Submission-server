package com.submission.server.controller;

import com.submission.server.controller.request.SubmissionRequest;
import com.submission.server.controller.response.SubmissionResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SubmissionControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test_SubmissionController_Success(){
        SubmissionRequest submissionRequest = new SubmissionRequest();
        submissionRequest.setName("Michelle");

        HttpEntity<SubmissionRequest> request = new HttpEntity<>(submissionRequest, null);

        ResponseEntity<SubmissionResponse> response = this.restTemplate.
                postForEntity("http://localhost:" + port + "/submissions/", request, SubmissionResponse.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void test_SubmissionController_BadRequest(){
        SubmissionRequest submissionRequest = new SubmissionRequest();

        HttpEntity<SubmissionRequest> request = new HttpEntity<>(submissionRequest, null);

        ResponseEntity<SubmissionResponse> response = this.restTemplate.
                postForEntity("http://localhost:" + port + "/submissions/", request, SubmissionResponse.class);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
