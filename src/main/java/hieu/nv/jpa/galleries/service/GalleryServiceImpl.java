package hieu.nv.jpa.galleries.service;

import hieu.nv.jpa.galleries.entity.ArtStyle;
import hieu.nv.jpa.galleries.entity.Gallery;
import hieu.nv.jpa.galleries.entity.Painting;
import hieu.nv.jpa.galleries.repository.GalleryRepository;
import hieu.nv.jpa.galleries.repository.PaintingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {

	private final GalleryRepository galleryRepository;
	private final PaintingRepository paintingRepository;

	@Override
	@Transactional
	public Gallery createGallery(Gallery gallery) {
		ArtStyle artStyle1 = new ArtStyle("Art Style 1");
		ArtStyle artStyle2 = new ArtStyle("Art Style 2");
		ArtStyle artStyle3 = new ArtStyle("Art Style 3");
		galleryRepository.save(gallery);
		Painting painting1 = new Painting();
		painting1.setTitle("Painting 1");
		painting1.setArtist("Artist 1");
		painting1.setStyle(artStyle1);
		painting1.setGallery(gallery);

		Painting painting2 = new Painting();
		painting2.setTitle("Painting 2");
		painting2.setArtist("Artist 2");
		painting2.setStyle(artStyle2);
		painting2.setGallery(gallery);

		Painting painting3 = new Painting();
		painting3.setTitle("Painting 3");
		painting3.setArtist("Artist 3");
		painting3.setStyle(artStyle3);
		painting3.setGallery(gallery);

		paintingRepository.save(painting1);
		paintingRepository.save(painting2);
		paintingRepository.save(painting3);
		return gallery;
	}

	@Override
	public Gallery getGallery(String id) {
		return galleryRepository.findById(id).orElse(null);
	}

	@Override
	public List<Gallery> getAllGalleries() {
		return galleryRepository.findAll();
	}
}
