package com.example.demo.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TunisianTaxIdValidator implements ConstraintValidator<TunisianTaxId,String> {


    private static final int NUMBER = 0;
    private static final int CONTROL = 1;
    private static final int VAT = 2;
    private static final int CATEGORY = 3;
    private static final int ESTABLISHMENT = 4;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // Let @NotNull handle null inputs
        if (value == null) {
            return true;
        }

        if (!value.matches("^\\d{7}/[A-HJ-NP-TV-Z]/[ABDPN]/[MCPNE]/\\d{3}$")){
            return false;
        }

        String parts[] = value.split("/");
        if (parts.length != 5) {
            return false;
        }

        String category = parts[3];
        String establishment = parts[4];

        if (!establishment.equals("000") && !category.equals("E")){
            return false ;
        }

        return true;

    }
}
