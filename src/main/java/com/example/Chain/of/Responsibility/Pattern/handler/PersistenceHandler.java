package com.example.Chain.of.Responsibility.Pattern.handler;

import com.example.Chain.of.Responsibility.Pattern.dto.UserRequest;
import com.example.Chain.of.Responsibility.Pattern.mapper.UserMapper;

public class PersistenceHandler implements Handler {
    private final UserMapper userMapper;
    private Handler next;

    public PersistenceHandler(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(UserRequest request) {
        userMapper.insertUser(request.toUser());
        System.out.println("PersistenceHandler: User persisted.");
        if (next != null) {
            next.handleRequest(request);
        }
    }

}
