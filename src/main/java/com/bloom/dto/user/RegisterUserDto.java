package com.bloom.dto.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class RegisterUserDto {

    @NotNull @NotBlank
    @Email(message = "Invalid email address")
    private String emailAddress;;

    @NotNull @NotBlank
    private String displayName;

    @NotNull @NotBlank
    private String username;

    @NotNull @NotBlank
    private String password;

    @NotNull @PastOrPresent
    private LocalDate dateOfBirth;

    public RegisterUserDto() {
    }

    public RegisterUserDto(String emailAddress, String displayName, String username, String password, LocalDate dateOfBirth) {
        this.emailAddress = emailAddress;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "emailAddress='" + emailAddress + '\'' +
                ", displayName='" + displayName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
