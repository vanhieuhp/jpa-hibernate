package hieu.nv.jpa.movies.projection;

import org.springframework.beans.factory.annotation.Value;
public interface MovieSmallProjection {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.title}")
    String getTitle();
}
