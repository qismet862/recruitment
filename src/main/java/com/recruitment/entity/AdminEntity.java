package com.recruitment.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "name must not be empty")
    String name;

    @NotEmpty(message = "surname must not be empty")
    String surname;

    String password;

    @NotEmpty(message = "userName must not be empty")
    String userName;

    @OneToMany(mappedBy = "admin")
    private List<AdminTokenEntity> tokenAdmins;
}
