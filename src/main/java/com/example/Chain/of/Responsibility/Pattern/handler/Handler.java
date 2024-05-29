package com.example.Chain.of.Responsibility.Pattern.handler;

import com.example.Chain.of.Responsibility.Pattern.dto.UserRequest;

public interface Handler {
    void setNext(Handler handler);

    void handleRequest(UserRequest request);

}
