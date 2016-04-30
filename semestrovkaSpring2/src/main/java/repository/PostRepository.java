package repository;

import model.UserPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<UserPost, Integer> {

    @Query("Select pt from UserPost pt where pt.topic = :searchTerm")
    Page<UserPost> findAll(@Param("searchTerm") String searchTerm, Pageable pageable);

}
