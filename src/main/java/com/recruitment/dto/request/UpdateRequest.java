package com.recruitment.dto.request;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {

    Long id;

    @NotEmpty(message = "name can not be null")
    String name;

    @NotEmpty(message = "surname can not be null")
    String surname;

    @NotEmpty(message = "mobile can not be null")
    String mobile;

    @NotEmpty(message = "email can not be null")
    String email;

    @NotEmpty(message = "github link can not be null")
    String github;

    @NotEmpty(message = "TechId can not be null")
    List<Long> techId;

    @NotEmpty(message = "userName can not be null")
    String userName;

    Boolean eng;

    Boolean az;

    Boolean tur;

    Boolean rus;

    Long addressId;
}
