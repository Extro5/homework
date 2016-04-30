package repository;

import model.UserAuthority;
import org.springframework.data.repository.CrudRepository;


public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Integer> {


    UserAuthority findByAuthority(String role_user);

}
