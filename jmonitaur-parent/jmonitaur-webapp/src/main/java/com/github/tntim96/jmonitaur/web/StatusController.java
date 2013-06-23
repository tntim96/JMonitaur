package com.github.tntim96.jmonitaur.web;

import com.github.tntim96.jmonitaur.model.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatusController {

    @RequestMapping(value = {"/status"})
    public String status(ModelMap model) {
        model.put("status", new Status());
        model.put("message", "Hello");

        return "status";
    }
}