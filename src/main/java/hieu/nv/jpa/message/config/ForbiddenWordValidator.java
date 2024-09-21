package hieu.nv.jpa.message.config;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class ForbiddenWordValidator implements ConstraintValidator<NoForbiddenWords, String> {

    private final List<String> forbiddenWords = new ArrayList<>();

    @Override
    public void initialize(NoForbiddenWords constraintAnnotation) {
        forbiddenWords.addAll(List.of("forbidden", "word"));
    }

    @Override
    public boolean isValid(String payload, ConstraintValidatorContext context) {
        return forbiddenWords.stream().noneMatch(payload::contains);
    }

}
