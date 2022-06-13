package com.recruitment.dto.request;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    @NotEmpty(message = "name can not be null")
    String name;

    @NotEmpty(message = "surname can not be null")
    String surname;

    @NotEmpty(message = "mobile can not be null")
    String mobile;

    @NotEmpty(message = "email can not be null")
    String email;

    String github;

    List<Long> techId;

    @NotEmpty(message = "username can not be null")
    String userName;

    String password;

    Boolean eng;

    Boolean az;

    Boolean tur;

    Boolean rus;

    Long addressId;
}
