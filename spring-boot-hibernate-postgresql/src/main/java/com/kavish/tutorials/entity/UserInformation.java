package com.kavish.tutorials.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Data
/**This class will represent a row in the database table.
 * The primary key is specified by the @Id annotation
 * In this case, userId is the primary key and the table will have userId,LastName,FirstName,Address and
 * City as columns.**/
public class UserInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    public Integer userId;

    public String lastName;
    public String firstName;
    public String address;
    public String city;

}
