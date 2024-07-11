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

public class GlobalValidator implements ConstraintValidator<UniqueSpot, SpotCreate>, SpotRepository {

	@Autowired
	private SpotRepository repository;

	@Override
	public void initialize(UniqueSpot constraintAnnotation) {
	}

	@Override
	public boolean isValid(SpotCreate spot, ConstraintValidatorContext context) {
		if (!repository.existsByNameIgnoreCaseAndLngAndLat(spot.name(), spot.lng(), spot.lat())) {
			return true;
		}
		throw new GlobalErrors();
		// return false;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Spot> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Spot> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Spot> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Spot getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spot getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spot getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Spot> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Spot> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Spot> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spot> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spot> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Spot> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Spot> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Spot entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Spot> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Spot> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Spot> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Spot> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Spot> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Spot> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Spot> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Spot, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<SpotView> findAllProjectedBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsByNameAndLngAndLat(String name, double lng, double lat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String findByName(@NotBlank @Size(max = 200) String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsByNameIgnoreCaseAndLngAndLat(String name, double lng, double lat) {
		// TODO Auto-generated method stub
		return false;
	}

}
