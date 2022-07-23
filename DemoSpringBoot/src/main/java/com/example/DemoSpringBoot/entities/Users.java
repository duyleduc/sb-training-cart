package com.example.DemoSpringBoot.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.DemoSpringBoot.validationz.PhoneNumberConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL PRIMARY KEY NOT NULL")
    private BigInteger id;

    @Column
    @NotEmpty(message = "first name is required")
    @Size(max = 8, message = "The length of first name must be between 1 and 8 characters.")
    private String firstName;

    @Column
    @NotEmpty(message = "last name is required")
    @Size(max = 64, message = "The length of last name must be between 1 and 64 characters.")
    private String lastName;

    @Column
    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
    @Size(max = 64, message = "The length of email not exceed 64 characters")
    private String email;

    @Column
    @PhoneNumberConstraint
    private String phone;

    @Column(updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Date createdDate;

    @Column
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Date updateDate;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @Column(columnDefinition = "boolean default false")
    private boolean isValidated;

}
