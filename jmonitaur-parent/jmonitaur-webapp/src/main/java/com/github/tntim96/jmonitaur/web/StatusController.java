package com.github.tntim96.jmonitaur.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.github.tntim96.jmonitaur.model.Status;


public class StatusController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String,Object> model = new HashMap<String,Object>();
		model.put( "status", new Status() );
		model.put( "message", "Hello" );
		
		return new ModelAndView("status", model);
	}
}