package org.wecancodeit.AlbumCollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.AlbumCollection.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {

}
