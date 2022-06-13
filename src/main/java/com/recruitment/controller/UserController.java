package com.recruitment.controller;

import com.recruitment.dto.request.AdminUpdateRequest;
import com.recruitment.dto.request.UpdateRequest;
import com.recruitment.dto.request.UserRequest;
import com.recruitment.dto.response.LoginResponse;
import com.recruitment.dto.response.UserDetailsResponse;
import com.recruitment.dto.response.UserResponse;
import com.recruitment.service.UserService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    ResponseEntity<Void> signup(@Valid UserRequest userRequest,
                                @RequestPart("file") MultipartFile file) {
        userService.signup(userRequest, file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<LoginResponse> update(@Valid UpdateRequest updateRequest,
                                         @RequestPart("file") MultipartFile file,
                                         @PathVariable Long id,
                                         @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(updateRequest, file, id, token));
    }

    @PutMapping("/admin/{id}")
    ResponseEntity<Void> updateByAdmin(@Valid @RequestBody AdminUpdateRequest request,
                                       @PathVariable Long id) {
        userService.updateByAdmin(request, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping("{id}")
    ResponseEntity<UserDetailsResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }
}
