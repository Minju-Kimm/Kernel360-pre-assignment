package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import com.example.validation.validator.YearMonthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = { YearMonthValidator.class }) //어떤 클래스로 검증할거냐
@Target({ ElementType.FIELD }) //변수에게 적용할 것
@Retention(RetentionPolicy.RUNTIME) //실행 중일 때 적용할 것
@NotBlank //비어있으면 안 된다
public @interface YearMonth {
    String message() default "출생 년도와 달을 양식에 맞추어 입력해주세요. ex) 2000-01";
    String regexp() default "^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])$"; //default 정규식

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
