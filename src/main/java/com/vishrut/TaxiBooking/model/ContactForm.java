package com.vishrut.TaxiBooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "contactform")
public class ContactForm {
    //keep field name as sam as that in input in contacts.html

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name Cannot be Empty!")//name field cannot be empty
    @Size(min= 2, max=30,message = "Invalid name Size!")//size of name if not in range then message
    @Column(length = 30)
    private String name;

    @NotEmpty(message = "Email cannot be Empty!")
    @Size(min=10, max = 20,message = "Invalid Email size!")
    @Column(length = 20)
    private String email;

    @NotNull(message = "Phone number cannot be Empty!")
    @Min(value = 1000000000, message = "Phone number must be of 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be of 10 digits")
    @Column(length = 10)
    private Long phone;

    @NotEmpty(message = "Message cannot be Empty!")
    @Size(min=3, max = 200,message = "Invalid Message size!")
    @Column(length = 200)
    private String message;
}
