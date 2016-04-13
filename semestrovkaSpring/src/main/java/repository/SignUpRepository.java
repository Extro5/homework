package repository;

import model.UserForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SignUpRepository extends CrudRepository<UserForm, Integer> {
}
