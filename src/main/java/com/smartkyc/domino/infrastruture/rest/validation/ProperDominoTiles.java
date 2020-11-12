package com.smartkyc.domino.infrastruture.rest.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ProperDominoTilesValidator.class)
public @interface ProperDominoTiles {
    String message() default "{com.smartkyc.domino.infrastruture.rest.validation.ProperDominoTiles.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}