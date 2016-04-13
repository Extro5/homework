package repository;

import model.UserPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<UserPost, Integer> {
    Page<UserPost> fndAlltoPage(Pageable pageable);

}
