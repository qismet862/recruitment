package com.recruitment.service;


import com.recruitment.dto.request.NotificationRequest;
import com.recruitment.dto.response.NotificationResponse;
import com.recruitment.entity.NotificationEntity;
import com.recruitment.entity.UserEntity;
import com.recruitment.exception.CustomNotFoundException;
import com.recruitment.mapper.NotificationMapper;
import com.recruitment.repository.NotificationRepository;
import com.recruitment.repository.TokenRepository;
import com.recruitment.repository.UserRepository;
import com.recruitment.util.CurrentUser;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationMapper notificationMapper;

    private final NotificationRepository notificationRepository;

    private final TokenRepository tokenRepository;

    private final UserRepository userRepository;

    public List<NotificationResponse> getNotifications(String token) {
        var user = new CurrentUser(tokenRepository).currentUser(token);
        var notifications = notificationRepository.findByUser(user);
        return notificationMapper.toResponse(notifications);
    }

    public void create(NotificationRequest request, Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("User not found"));

        NotificationEntity notification = NotificationEntity.builder()
                .notification(request.getNotification())
                .user(user)
                .build();

        notificationRepository.save(notification);
    }
}
