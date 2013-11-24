/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dan
 */
@Controller
public class SampleController {
	
	@RequestMapping("home")
	public String loadHomePage(Model m){
		m.addAttribute("name", "Dan");
		return "home";
	}
}
