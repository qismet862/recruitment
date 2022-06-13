package com.recruitment.controller;

import com.recruitment.dto.request.LoginRequest;
import com.recruitment.dto.response.LoginResponse;
import com.recruitment.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok().body(authService.login(request));
    }

    @PostMapping("/logout")
    ResponseEntity<Void> logout(@RequestHeader(name = "Authorization") String token) {
        authService.logout(token);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
