package com.recruitment.dto.request;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NotificationRequest {
    @NotEmpty(message = "notification must not be null or empty")
    String notification;
}
