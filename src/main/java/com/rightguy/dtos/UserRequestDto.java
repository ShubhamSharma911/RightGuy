package com.rightguy.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRequestDto {

    @NotNull(message = "can not be null")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 10, max = 10, message = "Mobile Number mube be correct")
    private String mobileNumber;

    @NotNull(message = "Address is required")
    private String address;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "userType is required")
    private String userType;

    public @NotNull(message = "can not be null")
    String getName() {
        return name;
    }

    public void setName(@NotNull(message = "can not be null") String name) {
        this.name = name;
    }

    public @Email(message = "Invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid email format") String email) {
        this.email = email;
    }

    public @Size(min = 10, max = 10, message = "Mobile Number mube be correct") String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@Size(min = 10, max = 10, message = "Mobile Number mube be correct") String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public @NotNull(message = "Address is required") String getAddress() {
        return address;
    }

    public void setAddress(@NotNull(message = "Address is required") String address) {
        this.address = address;
    }

    public @NotBlank(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

}
