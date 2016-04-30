package controllers;


import model.UserPost;
import model.UserPostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repository.PostRepository;
import service.PostService;

import java.util.Objects;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @InitBinder("userPost")
    protected void initUserPostBinder(WebDataBinder binder) {
        binder.setValidator(new UserPostValidator());
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String newPost(ModelMap map) {
        map.put("userPost", new UserPost());
        return "new_post";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String springHandlerPost(
            RedirectAttributes redirectAttributes,
            @Validated UserPost userPost,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "new_post";
        } else {
            postService.addNewPost(userPost);
            redirectAttributes.addFlashAttribute("message", "Пост был успешно добавлен");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("PC#newPost").build();
        }
    }


    @RequestMapping(value = "/pagination", method = RequestMethod.GET)
    public String pagination(ModelMap map, @RequestParam(required = false, value = "searchTerm") String searchTerm, Pageable pageable) {
        Page<UserPost> page;
        if ((Objects.equals(searchTerm, "")) || searchTerm == null) {
            page = postRepository.findAll(pageable);
        } else {
            page = postRepository.findAll(searchTerm, pageable);
        }
        map.addAttribute("page", page);
        return "all_post_pagination";
    }
}
