package org.wecancodeit.AlbumCollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.AlbumCollection.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

}
