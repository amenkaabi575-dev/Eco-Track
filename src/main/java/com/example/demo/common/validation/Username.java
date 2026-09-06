package com.example.demo.common.validation;

import com.example.demo.common.validation.UsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameValidator.class)
public @interface Username {

    String message() default "Username may contain only letters, numbers, dots, underscores, and hyphens";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}