package com.dmilut.webbankapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotEmpty(message = "First name is required")
    @Column(name = "firstname")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Column(name = "lastname")
    private String lastName;

    @Column(nullable = true, name = "email")
    private String email;

}
