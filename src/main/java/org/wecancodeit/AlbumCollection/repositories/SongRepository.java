package org.wecancodeit.AlbumCollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.AlbumCollection.model.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

}
