package org.wecancodeit.AlbumCollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.AlbumCollection.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
