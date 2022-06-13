package com.recruitment.util;

import com.recruitment.entity.UserEntity;
import com.recruitment.repository.TokenRepository;


public class CurrentUser {
    private final TokenRepository tokenRepository;

    public CurrentUser(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public UserEntity currentUser(String token) {
        token = token.substring(7);
        UserEntity user = tokenRepository.findById(token).get().getUser();
        return user;
    }
}
