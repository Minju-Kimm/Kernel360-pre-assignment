package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

//    @NotNull
//    @NotEmpty
//    @NotBlank //비면 안 되는 값
    private String name;

    private String nickName;

    @Size(min = 1, max = 12) //pw -> 최소 1 ~ 최대 12자리
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @YearMonth
    private String yearMonth;

    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent // 현재 혹은 미래
    private LocalDateTime registerAt;

    @AssertTrue(message = "name 또는 nickname 은 존재해야 합니다.") //해당 리턴 값이 true일 때 실행이 되도록 하는 것
    public boolean isNameCheck() {

        if (Objects.nonNull(name) && !name.isBlank()) {
            return true;
        }

        if (Objects.nonNull(nickName) && !nickName.isBlank()) {
            return true;
        }

        return false;
    }
}
