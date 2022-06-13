package com.recruitment.dto.response;

import com.recruitment.entity.TechnologyEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsResponse {
    Long id;
    String name;
    String surname;
    String mobile;
    String email;
    String github;
    List<TechnologyEntity> technology;
    String cvUrl;
    String userName;
    Boolean eng;
    Boolean az;
    Boolean tur;
    Boolean rus;
    List<TaskResponse> task;
    AddressResponse address;
}
