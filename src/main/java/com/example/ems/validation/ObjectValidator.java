package com.example.ems.validation;


import com.example.ems.configuration.ObjectNotValidException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator <T>{

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    @Autowired
    private final Validator validator = factory.getValidator();

    public void validate(T ObjectTOValidate){
        Set<ConstraintViolation<T>> Violation = validator.validate(ObjectTOValidate);
        if (!Violation.isEmpty()){
            var errorMessages = Violation
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
            throw new ObjectNotValidException(errorMessages);
        }

    }
}
