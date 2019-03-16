package com.submission.server.controller.request;

import com.submission.server.exception.BadRequestException;

public class SubmissionRequest {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validateName() throws BadRequestException {
        //Assuming no maximum length on name
        if(name == null || name.isEmpty()){
            throw new BadRequestException("Please provide your name");
        }
    }
}
