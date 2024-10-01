package hieu.nv.jpa.galleries.service;

import hieu.nv.jpa.galleries.entity.Gallery;

import java.util.List;

public interface GalleryService {
	Gallery createGallery(Gallery gallery);

	Gallery getGallery(String id);

	List<Gallery> getAllGalleries();
}
