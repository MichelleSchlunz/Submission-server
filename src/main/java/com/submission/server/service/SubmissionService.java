package com.submission.server.service;

import com.submission.server.exception.BadRequestException;
import com.submission.server.controller.request.SubmissionRequest;
import com.submission.server.controller.response.SubmissionResponse;
import com.submission.server.resource.Submissions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class SubmissionService {

    private Submissions submissions;

    public SubmissionService(Submissions submissions){
        this.submissions = submissions;
    }

    @ResponseStatus(HttpStatus.CREATED)
    public SubmissionResponse submit(SubmissionRequest submission) throws BadRequestException {
        submission.validateName();
        return new SubmissionResponse(submission.getName(), submissions.incrementAndGet());
    }

}
