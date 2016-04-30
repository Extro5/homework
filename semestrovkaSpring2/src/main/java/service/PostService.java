package service;


import model.UserForm;
import model.UserPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import repository.PostRepository;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public void addNewPost(UserPost userPost) {
        UserForm userForm = (UserForm) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userPost.setLogin(userForm.getLogin());
        postRepository.save(userPost);
    }
}
