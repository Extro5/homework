package controllers;

import aspects.AnnoLogging;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyController {

    @AnnoLogging
    @RequestMapping(value = "/idea", method = RequestMethod.GET)
    public String viewIdea(ModelMap map) {
        return "idea";
    }



    @AnnoLogging
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String viewAbout(ModelMap map) {
        return "about";
    }


}