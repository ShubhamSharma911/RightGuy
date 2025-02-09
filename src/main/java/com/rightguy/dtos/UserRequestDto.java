package com.rightguy.dtos;

import com.rightguy.enums.Specialization;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class UserRequestDto {

    @NotNull(message = "can not be null")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 10, max = 10, message = "Mobile Number mube be correct")
    private String mobileNumber;

    @NotNull(message = "Address is required")
    private String address;

    @NotNull(message = "Specialization is required")
    private String specialization;

    @NotBlank(message = "Password is required")
    public String password;

}
