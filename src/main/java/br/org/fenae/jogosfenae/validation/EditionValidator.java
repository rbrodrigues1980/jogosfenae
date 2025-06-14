package br.org.fenae.jogosfenae.validation;

import br.org.fenae.jogosfenae.entity.Edition;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EditionValidator implements ConstraintValidator<EditionValid, Edition> {
    @Override
    public boolean isValid(Edition edition, ConstraintValidatorContext context) {
        if (edition == null) {
            return true;
        }

        boolean valid = true;
        context.disableDefaultConstraintViolation();

        LocalDateTime start = edition.getStartDateTime();
        LocalDateTime end = edition.getEndDateTime();
        if (start != null && end != null && start.isAfter(end)) {
            context.buildConstraintViolationWithTemplate("{validation.edition.start.before.end}")
                    .addPropertyNode("startDateTime").addConstraintViolation();
            valid = false;
        }

        LocalDate bornFrom = edition.getBornFrom();
        LocalDate bornUntil = edition.getBornUntil();
        if (bornFrom != null && bornUntil != null && bornFrom.isAfter(bornUntil)) {
            context.buildConstraintViolationWithTemplate("{validation.edition.birth.range}")
                    .addPropertyNode("bornFrom").addConstraintViolation();
            valid = false;
        }

        return valid;
    }
}
