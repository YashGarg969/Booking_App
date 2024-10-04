package com.example.Booking_App.domain;

import com.example.Booking_App.converter.DateConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "username cannot be blank")
    @Column(name = "username" ,
            nullable = false ,
            unique = true)
    private String username;

    @Size(min = 8,
            message = "minimum length of password should be 8 characters")
    @Column(name = "password" ,
            nullable = false)
    private String password;

    @Column(name = "confirmPassword" ,
            nullable = false)
    private String confirmPassword;

    @Column(name = "role" ,
            nullable = false)
    private String role;

    @Column(name = "createdOn")
    @Convert(converter = DateConverter.class)
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "lastModifiedOn")
    @Convert(converter = DateConverter.class)
    @UpdateTimestamp
    private Date lastModifiedOn;

    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BookingDetails> bookingDetails = new ArrayList<>();

}