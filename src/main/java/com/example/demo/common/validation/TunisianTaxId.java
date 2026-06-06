package com.example.demo.common.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TunisianTaxIdValidator.class)
public @interface TunisianTaxId {

    String message() default "Invalid Tax ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
