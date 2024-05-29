package com.example.Chain.of.Responsibility.Pattern.handler;

import com.example.Chain.of.Responsibility.Pattern.dto.UserRequest;

public class ValidationHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(UserRequest request) {
        if (isValid(request)) {
            System.out.println("ValidationHandler: Request is valid.");
            if (next != null) {
                next.handleRequest(request);
            }
        } else {
            System.out.println("ValidationHandler: Request is invalid.");
        }

    }

    private boolean isValid(UserRequest request) {
        // Implement validation logic

        return true;
    }

}
