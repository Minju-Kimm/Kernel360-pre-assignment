package com.example.rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {

    private String userName;

    private Integer userAge;

    private String email;

    private Boolean isKorean; //default -> false

    private UserRequest() {

    }


    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", email='" + email + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }
}
