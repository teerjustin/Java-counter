package com.teerjustin.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class controller {
	
	@RequestMapping("/")
	public String index(HttpSession session) {

		System.out.println("I HIT HERE");
		if (session.isNew()) {
			session.setAttribute("count", 0);
			return "index.jsp";
		}
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
			System.out.println(session.getAttribute("count"));
			return "index.jsp";
		}
		
		//null
		//or 1
		Integer count = (Integer) session.getAttribute("count");
		session.setAttribute("count", count + 1);		
		System.out.println(session.getAttribute("count"));

		return "index.jsp";
	}
	@RequestMapping("/invalidate")
	public String invalidate(HttpSession session) {
		session.invalidate();
		return "index.jsp";
	}
	
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer count = (Integer) session.getAttribute("count");
		System.out.println("************************" + count);
		if (count == null) {
			count = 1;
		}
		model.addAttribute("count", count);
		return "counter.jsp";
	}
	
}
