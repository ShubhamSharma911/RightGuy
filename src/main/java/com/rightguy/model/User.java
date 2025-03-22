package com.rightguy.model;

import com.rightguy.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String address;

    private UserType userType; // "Provider" or "Requester"

    @Column(nullable = false)
    private String password;

    private User(UserBuilder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;
        this.address = builder.address;
        this.userType = builder.userType;
        this.password = builder.password;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }


    public static class UserBuilder {
        private String name;
        private String email;
        private String mobileNumber;
        private String address;
        private UserType userType;
        private String password;

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
