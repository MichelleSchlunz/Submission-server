package com.submission.server.controller.response;

public class SubmissionResponse {

    private final String name;
    private String message = "Hello %s. A name has been submitted %s time%s since this app has been running.";


    public SubmissionResponse(String name, long count) {
        this.name = name;
        this.message = String.format(message, name == null? "":name, count, count > 1?"s":"");
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
