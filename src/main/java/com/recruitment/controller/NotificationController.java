package com.recruitment.controller;

import com.recruitment.dto.request.NotificationRequest;
import com.recruitment.dto.response.NotificationResponse;
import com.recruitment.service.NotificationService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    ResponseEntity<List<NotificationResponse>> getNotifications(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.OK).body(notificationService.getNotifications(token));
    }

    @PostMapping("{id}")
    ResponseEntity<Void> createNotifications(@Valid @RequestBody NotificationRequest request, @PathVariable Long id) {
        notificationService.create(request, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
