package controllers;

import dao.UserDao;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repository.PostRepository;
import repository.SignUpRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


@Controller
public class MyController {


    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;


    @Autowired
    private UserDao userDao;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private SignUpRepository signUpRepository;

    @RequestMapping("/change")
    public String change(@RequestParam String locale) {
        String[] localeData = locale.split("_");
        localeResolver.setLocale(request, response, new Locale(localeData[0], localeData[1]));
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("MC#viewIdea").build();
    }


    @InitBinder("userForm")
    protected void initUserFormBinder(WebDataBinder binder) {
        binder.setValidator(new UserFormValidator());
    }

    @InitBinder("userLogin")
    protected void initUserLoginBinder(WebDataBinder binder) {
        binder.setValidator(new UserLoginValidator());
    }

    @InitBinder("userPost")
    protected void initUserPostBinder(WebDataBinder binder) {
        binder.setValidator(new UserPostValidator());
    }


    @RequestMapping(value = "/idea", method = RequestMethod.GET)
    public String viewIdea(ModelMap map) {
        return "idea";
    }


    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String viewAbout(ModelMap map) {
        return "about";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String newUser(ModelMap map) {
        map.put("userForm", new UserForm());
        return "user_form";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String springHandler(
            RedirectAttributes redirectAttributes,
            @Validated UserForm userForm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "user_form";
        } else {
            signUpRepository.save(userForm);

            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">UserForm \"" + userForm.getLogin() + "\" has been added successfully</span>");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("MC#newUser").build();
        }

    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUser(ModelMap map) {
        map.put("userLogin", new UserLogin());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String springHandlerLogin(
            RedirectAttributes redirectAttributes,
            @Validated UserLogin userLogin,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "login";
        } else {
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Login \"" + userLogin.getEmail() + "\" has been added successfully</span>");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("MC#loginUser").build();
        }

    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String newPost(ModelMap map) {
        map.put("userPost", new UserPost());
        return "postUsers";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String springHandlerPost(
            RedirectAttributes redirectAttributes,
            @Validated UserPost userPost,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "postUsers";
        } else {
            postRepository.save(userPost);

            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Post \"" + userPost.getTopic() + "\" has been added successfully</span>");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("MC#newPost").build();
        }

    }


    @RequestMapping(value = "/pagination/{pageNumber}", method = RequestMethod.GET)
    public String pagination(ModelMap map, @PathVariable Integer pageNumber) {
        // map.put("userForm", new UserForm());
        //  postRepository.findAll(pageNumber);
//        private final BlogPostRepository blogPostRepository;
//
//        @Override
//
//        public Page<BlogPost> getAllPublishedPosts(Pageable pageable) {
//
//            Page<BlogPost> blogList = blogPostRepository.findByPublishedIsTrueOrderByPublishedTimeDesc(pageable);
//
//            return blogList;

        //  }

        //PagingAndSortingRepository<UserPost, Long> repository =  postRepository;
        // Page<UserPost> users = repository.findAll(new PageRequest(1, 20));
        return "pagination";
    }
}