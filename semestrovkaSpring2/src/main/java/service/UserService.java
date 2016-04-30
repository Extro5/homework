package service;

import model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.SignUpRepository;
import repository.UserAuthorityRepository;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private SignUpRepository signUpRepository;


    @Autowired
    private UserAuthorityRepository userAuthorityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return signUpRepository.findByLogin(login);
    }

    public void registerUser(UserForm userForm) {
        if (signUpRepository.findByLogin(userForm.getUsername()) != null) {
            throw new DuplicateKeyException("Duplicate key - login field.");
        }
        userForm.addAuthority(userAuthorityRepo.findByAuthority("ROLE_USER"));
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        signUpRepository.save(userForm);
    }
}
