package co.simplon.spotmebusiness.services;

import java.io.File;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

import co.simplon.spotmebusiness.exceptions.HandlerErrors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import co.simplon.spotmebusiness.dtos.SpotView;
import co.simplon.spotmebusiness.entities.Spot;
import co.simplon.spotmebusiness.exceptions.FileSizeException;
import co.simplon.spotmebusiness.exceptions.FileTypeException;
import co.simplon.spotmebusiness.exceptions.GlobalErrors;
import co.simplon.spotmebusiness.repositories.SpotRepository;
import co.simplon.spotmebusiness.validation.FileSize;

import static java.util.Objects.isNull;

@Service
public class SpotService {

	@Value("${spotmebusiness.uploads.dest}")
	private String uploadsDest;

	private final SpotRepository spots;

	public SpotService(SpotRepository spots) {
		this.spots = spots;
	}

	public void create(SpotCreate inputs) {
		if (spots.existsByNameIgnoreCaseAndLngAndLat(inputs.name(), inputs.lng(), inputs.lat())) {
			throw new GlobalErrors();
		} else if (!isNull(inputs.image())) {
			if (inputs.image().getSize() > FileSize.TWO_MB) {
				throw new FileSizeException();
			} else if (!isValidType(inputs)) {
				throw new FileTypeException();
			}
		}
		Spot entity = new Spot();
		entity.setName(inputs.name());
		entity.setDescription(inputs.description());
		entity.setLat(inputs.lat());
		entity.setLng(inputs.lng());

		MultipartFile image = inputs.image();
		if (image != null) {
			String imageId = buildImageId(image);
			storeImage(image, imageId);
			entity.setImageId(imageId);
		}
		spots.save(entity);
	}

	private boolean isValidType(SpotCreate inputs) {
		String imageName = inputs.image().getOriginalFilename();
		System.out.println("imageName =" + imageName);
		int index = imageName.lastIndexOf(".");
		String ext = imageName.substring(index, imageName.length());
		String[] validTypes = { ".jpeg", ".jpg", ".gif", ".png" };

		boolean isValid = false;
		for (String validType : validTypes) {
			if (ext.equals(validType)) {
				isValid = true;
				break;
			}
		}
		return isValid;
	}

	private String buildImageId(MultipartFile image) {
		UUID uuid = UUID.randomUUID();
		String name = image.getOriginalFilename();
		int index = name.lastIndexOf('.');
		String ext = name.substring(index, name.length());
		return uuid + ext;
	}

	private void storeImage(MultipartFile image, String imageId) {
		try {
			String dest = String.format("%s/%s", uploadsDest, imageId);
			File file = new File(dest);
			image.transferTo(file);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public Collection<SpotView> getAll() {
		return spots.findAllProjectedBy();
	}

	public void deleteOne(long id) {
		spots.deleteById(id);

	}

}
