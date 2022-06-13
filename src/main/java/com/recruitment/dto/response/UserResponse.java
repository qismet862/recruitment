package com.recruitment.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    Long id;
    String name;
    String surname;
    String mobile;
    String email;
    String userName;
}
