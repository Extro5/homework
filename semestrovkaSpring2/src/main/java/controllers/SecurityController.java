package controllers;


import model.UserForm;
import model.UserFormValidator;
import model.UserLogin;
import model.UserLoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserService;

@Controller
public class SecurityController {


    @Autowired
    private UserService userService;


    @InitBinder("userForm")
    protected void initUserFormBinder(WebDataBinder binder) {
        binder.setValidator(new UserFormValidator());
    }

    @InitBinder("userLogin")
    protected void initUserLoginBinder(WebDataBinder binder) {
        binder.setValidator(new UserLoginValidator());
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String newUser(ModelMap map) {
        map.put("userForm", new UserForm());
        return "sign_up";
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String springHandler(
            RedirectAttributes redirectAttributes,
            @Validated UserForm userForm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "sign_up";
        } else {
            userService.registerUser(userForm);
            redirectAttributes.addFlashAttribute("message", "Пользователь успешно зарегистрирован.");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#newUser").build();
        }

    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap map, @RequestParam(required = false) String error, @ModelAttribute("loginForm") UserLogin userLogin, BindingResult result) {
        map.put("error", error);
        return "login";
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/loginerror", method = RequestMethod.GET)
    public String loginError(ModelMap map, @RequestParam(required = false) String error, @ModelAttribute("loginForm") UserLogin userLogin, BindingResult result) {
        map.put("error", "К сожалению, такой пользователь не найден");
        return "login";
    }

    @RequestMapping(value = "/loginerror", method = RequestMethod.POST)
    public String springHandlerLogin(
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute("loginForm") UserLogin userLogin,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "login";
        } else {
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("PC#newPost").build();
        }

    }

}
