package com.solomon.springcrm.Response;

public class CustomerErrorResponse {


    // Generate the fields
    private int status;

    private String message;

    private long timeStamp;

    // Generate the getters and setters


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    // Generate the constructors


    public CustomerErrorResponse() {
    }

    public CustomerErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    // Generate the toString method


    @Override
    public String toString() {
        return "CustomerErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
