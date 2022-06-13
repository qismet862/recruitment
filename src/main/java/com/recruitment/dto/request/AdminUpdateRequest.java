package com.recruitment.dto.request;


import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AdminUpdateRequest {
//    Long id;

    @NotEmpty(message = "name can not be null")
    String name;

    @NotEmpty(message = "surname can not be null")
    String surname;

    @NotEmpty(message = "userName can not be null")
    String userName;
}
