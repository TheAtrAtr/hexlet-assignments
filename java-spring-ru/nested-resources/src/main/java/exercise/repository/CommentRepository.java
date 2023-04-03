package exercise.repository;

import exercise.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    // BEGIN
    @Query
    Iterable<Comment> findAllByPostId(long id);

    @Query
    Optional<Comment> findByIdAndPostId(Long commentsid, Long postid);
    // END
}
