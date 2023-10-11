package be.digitalcity.spring.airport.validation.validator;

import be.digitalcity.spring.airport.validation.constraint.Even;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EvenValidator implements ConstraintValidator<Even, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value % 2 == 0;
    }
}
