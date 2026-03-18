package com.kavish.tutorials.dao;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile")
    private String mobile;

}
