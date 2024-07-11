package co.simplon.spotmebusiness.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Constraint(validatedBy = GlobalValidator.class)
public @interface UniqueSpot {

	String message() default "SpotUnique";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
