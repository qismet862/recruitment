package com.recruitment.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminLoginResponse {
    Long id;

    String name;

    String surname;

    String userName;
}
