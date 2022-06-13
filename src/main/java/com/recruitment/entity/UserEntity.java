package com.recruitment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "name can not be null")
    String name;

    @NotEmpty(message = "surname can not be null")
    String surname;

    @NotEmpty(message = "mobile can not be null")
    String mobile;

    @NotEmpty(message = "email can not be null")
    String email;

    String github;

    String cvUrl;

    @NotEmpty(message = "name can not be null")
    String userName;

    String password;

    Boolean eng;

    Boolean az;

    Boolean tur;

    Boolean rus;

    @OneToMany(mappedBy = "user")
    private List<TokenEntity> tokenUsers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<NotificationEntity> notificationUsers;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "technology_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    List<TechnologyEntity> technologyId;

    @OneToMany(mappedBy = "user")
    List<TaskEntity> task;

    @ManyToOne
    AddressEntity address;
}
