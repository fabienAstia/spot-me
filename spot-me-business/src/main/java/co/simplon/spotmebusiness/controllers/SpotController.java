package co.simplon.spotmebusiness.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import co.simplon.spotmebusiness.dtos.SpotView;
import co.simplon.spotmebusiness.services.SpotService;
import jakarta.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

// /spots => collection of resources of type "Spot"
@RequestMapping("/spots")
@RestController
public class SpotController {

	private final SpotService service;

	public SpotController(SpotService service) {
		this.service = service;
	}

	// @RequestBody => TXT/JSON
	// @ModelAttribute => multipart form data
	// POST "/spots" => Unique Rest endpoint identifier in the application

	@PostMapping
	public ResponseEntity<Object> create(@Valid @ModelAttribute SpotCreate inputs) {
		service.create(inputs);
		return ResponseEntity.ok("spot created");
	}

	@GetMapping
	Collection<SpotView> getAll() {
		return service.getAll();
	}

	@DeleteMapping("/{id}")
	void deleteOne(@PathVariable("id") long id) {
		service.deleteOne(id);
	}

}
