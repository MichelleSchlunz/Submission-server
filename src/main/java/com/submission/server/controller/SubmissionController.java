package com.submission.server.controller;

import com.submission.server.controller.request.SubmissionRequest;
import com.submission.server.controller.response.SubmissionResponse;
import com.submission.server.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @CrossOrigin(origins = "*")
    @PostMapping("/submissions")
    public SubmissionResponse postSubmission(@RequestBody SubmissionRequest submission){
        return submissionService.submit(submission);
    }

}
