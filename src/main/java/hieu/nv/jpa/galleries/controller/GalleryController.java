package hieu.nv.jpa.galleries.controller;

import hieu.nv.jpa.galleries.entity.Gallery;
import hieu.nv.jpa.galleries.service.GalleryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/galleries")
@RequiredArgsConstructor
public class GalleryController {

	private final GalleryService galleryService;

	@PostMapping
	public Gallery createGallery(@RequestBody Gallery gallery) {
		return galleryService.createGallery(gallery);
	}

	@GetMapping("/{id}")
	public Gallery getGallery(@PathVariable String id) {
		return galleryService.getGallery(id);
	}

	@GetMapping
	public List<Gallery> getAllGalleries() {
		return galleryService.getAllGalleries();
	}
}
