package com.example.demo.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password,String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = password.chars()
                .anyMatch(Character::isUpperCase);

        boolean hasLowerCase = password.chars()
                .anyMatch(Character::isLowerCase);

        boolean hasDigit = password.chars()
                .anyMatch(Character::isDigit);

        boolean hasSpecialCharacter = password.chars()
                .anyMatch(ch -> !Character.isLetterOrDigit(ch));

        return hasUpperCase
                && hasLowerCase
                && hasDigit
                && hasSpecialCharacter;
    }
}
