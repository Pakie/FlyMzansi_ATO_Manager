package com.pakie.flymzansi_ato_manager.web.dto;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

public class UserRegistrationDto {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;
    private String matchingPassword;

    public UserRegistrationDto(String firstName, String lastName, String email, String password, String matchingPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    public UserRegistrationDto() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() { return matchingPassword; }

    public void setMatchingPassword(String matchingPassword) { this.matchingPassword = matchingPassword; }
}
