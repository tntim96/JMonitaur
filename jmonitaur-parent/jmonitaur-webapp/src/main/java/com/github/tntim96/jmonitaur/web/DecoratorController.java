package com.github.tntim96.jmonitaur.web;

import com.opensymphony.module.sitemesh.RequestConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DecoratorController {
    @RequestMapping("/decorators/{name:[^\\.]+}.ftl")
    public String decorator(@PathVariable String name, ModelMap map, HttpServletRequest request) {
        map.put("page", request.getAttribute(RequestConstants.PAGE));
        return "decorators/" + name;
    }
}