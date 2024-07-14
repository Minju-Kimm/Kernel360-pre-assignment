package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = { PhoneNumberValidator.class }) //어떤 클래스로 검증할거냐
@Target({ ElementType.FIELD }) //변수에게 적용할 것
@Retention(RetentionPolicy.RUNTIME) //실행 중일 때 적용할 것
public @interface PhoneNumber {
    String message() default "핸드폰 번호 양식에 맞지 않습니다. ex) 000-0000-0000";
    String regexp() default "^\\d{2,3}-\\d{3,4}-\\d{4}$"; //default 정규식

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
