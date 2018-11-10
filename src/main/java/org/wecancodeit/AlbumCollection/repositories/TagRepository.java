package org.wecancodeit.AlbumCollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.AlbumCollection.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

}