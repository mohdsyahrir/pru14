package org.taiko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.taiko.dao.PengundiDao;
import org.taiko.form.PengundiForm;

@Controller
public class PengundiController {
	
	
	@Autowired PengundiDao dao;
	private static final Logger logger = LoggerFactory.getLogger(PengundiController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String pengundi(Model model) {
		logger.info("Page pengundi");
		model.addAttribute("pengundiForm",new PengundiForm());
		model.addAttribute("mode","true");
		return "pengundi";
	}
	
	@RequestMapping(value = "/cari",  method = RequestMethod.POST)
	public String cari(Model model,@ModelAttribute("pengundiForm")PengundiForm form) {
		 logger.info("cari pengundi");
		model.addAttribute("pengundiForm",dao.getPengundiByNoKp(form.getNo_kp()));
		model.addAttribute("mode","true");
		return "pengundi";
	}
	
	@RequestMapping(value = "/kemaskini",  method = RequestMethod.POST)
	public String kemaskini(Model model,@ModelAttribute("pengundiForm")PengundiForm form) {
		 logger.info("kemaskini pengundi");
		model.addAttribute("pengundiForm",dao.getPengundiByNoKp(form.getNo_kp()));
		model.addAttribute("mode","false");
		return "pengundi";
	}
	
	@RequestMapping(value = "/save",  method = RequestMethod.POST)
	public String save(Model model,@ModelAttribute("pengundiForm")PengundiForm form) {
		logger.info("kemaskini pengundi");
		 
		dao.save(form); 
		model.addAttribute("pengundiForm", dao.getPengundiByNoKp(form.getNo_kp()));
		model.addAttribute("mode","true");
		return "pengundi";
	}
	

}
