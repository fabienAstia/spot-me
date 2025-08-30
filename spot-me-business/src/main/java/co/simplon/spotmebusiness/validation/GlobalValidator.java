package co.simplon.spotmebusiness.validation;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import co.simplon.spotmebusiness.dtos.SpotView;
import co.simplon.spotmebusiness.entities.Spot;
import co.simplon.spotmebusiness.exceptions.GlobalErrors;
import co.simplon.spotmebusiness.repositories.SpotRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GlobalValidator implements ConstraintValidator<UniqueSpot, SpotCreate> {

	@Autowired
	private SpotRepository repository;

	@Override
	public void initialize(UniqueSpot constraintAnnotation) {
	}

	@Override
	public boolean isValid(SpotCreate spot, ConstraintValidatorContext context) {
		if (spot.name() == null || spot.lng() == null || spot.lat() == null){
			return true;
		}
		if (!repository.existsByNameIgnoreCaseAndLngAndLat(spot.name(), spot.lng(), spot.lat())) {
			return true;
		}
		throw new GlobalErrors();
	}
}
