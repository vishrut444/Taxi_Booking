package com.vishrut.TaxiBooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bookingform")
public class BookingForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cannot be empty!")
    @NotBlank(message = "Name cant be blank")//if someone put blank spaces
    @Size(min = 3, max = 20,message = "Invalid name length!")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Name must contain only alphabet!")
    @Column(length = 30)
    private String name;

    @NotEmpty(message = "Source cannot be empty!")
    @NotBlank(message = "Source cant be blank")
    @Size(min = 2, max = 100,message = "Invalid Source length!")
    @Column(length = 100)
    private String source;

    @NotEmpty(message = "e-Mail cannot be empty!")
    @NotBlank(message = "e-Mail cant be blank")
    @Size(min = 5, max = 20,message = "Invalid e-mail length!")
    @Column(length = 20)
    private String email;

    @NotEmpty(message = "Destination cannot be empty!")
    @NotBlank(message = "Destination cant be blank")
    @Size(min = 4, max = 100,message = "Invalid Destination length!")
    @Column(length = 100)
    private String destination;

    @NotNull(message = "Time cannot be empty!")
    private LocalTime time;

    @NotNull(message = "date cannot be empty!")
    private LocalDate date;

    @NotEmpty(message = "Comfort cannot be empty!")
    @Size(min = 2, max = 20,message = "Invalid Comfort length!")
    @Column(length = 20)
    private String comfort;

    @Min(value = 1,message = "Minimum one adult is required!")
    @Max(value = 4,message = "Maximum 4 adults can ride")
    private int adult;

    @Max(value = 3,message = "Maximum 3 children can ride!")
    private int children;

    @NotEmpty(message = "Message cannot be empty")
    @NotBlank(message = "Message cannot be blank")
    @Size(min = 4, max = 100,message = "Invalid message length!")
    @Column(length = 100)
    private String message;
}
