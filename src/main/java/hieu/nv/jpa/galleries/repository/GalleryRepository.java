package hieu.nv.jpa.galleries.repository;

import hieu.nv.jpa.galleries.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, String> {
}