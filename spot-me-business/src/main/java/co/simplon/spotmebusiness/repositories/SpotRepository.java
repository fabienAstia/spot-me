package co.simplon.spotmebusiness.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.spotmebusiness.dtos.SpotView;
import co.simplon.spotmebusiness.entities.Spot;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Repository // Optional
public interface SpotRepository extends JpaRepository<Spot, Long> {

	Collection<SpotView> findAllProjectedBy();

	boolean existsByNameIgnoreCaseAndLngAndLat(String name, double lng, double lat);

	String findByName(@NotBlank @Size(max = 200) String name);

	boolean existsByNameAndLngAndLat(String name, double lng, double lat);
}
