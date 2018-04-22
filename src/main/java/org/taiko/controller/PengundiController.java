package org.taiko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.taiko.dao.MirrorPengundiHome;
import org.taiko.dao.PengundiDao;
import org.taiko.dao.PengundiHome;
import org.taiko.entity.MirrorPengundi;
import org.taiko.entity.Pengundi;
import org.taiko.form.PengundiForm;
import org.taiko.service.PengundiService;

@Controller
public class PengundiController {
	
	
	@Autowired PengundiDao dao;
	@Autowired PengundiHome ph;
	@Autowired private MirrorPengundiHome mph;
	@Autowired private PengundiService pengundiService;
//	@Autowired private Repo repo;
	
	private static final Logger logger = LoggerFactory.getLogger(PengundiController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String menu() {
		logger.info("Page menu");
		return "index";
	}
	
	@RequestMapping(value = "/carianPengundi",  method = RequestMethod.GET)
	public String carianPengundi(Model model) {
		logger.info("Page carian pengundi");
		model.addAttribute("pengundiForm", new PengundiForm());
		model.addAttribute("mode","true");
		return "pengundi";
	}
	
	@RequestMapping(value = "/senaraiPengundi",  method = RequestMethod.GET)
	public String senaraiPengundi() {
		logger.info("Page senarai Pengundi");
		
		return "senaraiPengundi";
	}
	
	@RequestMapping(value = "/cari",  method = RequestMethod.POST)
	public String cari(Model model,@ModelAttribute("pengundiForm")PengundiForm form) {
		 logger.info("cari pengundi");
		 Pengundi p = ph.findById(form.getNo_kp_carian());
		 MirrorPengundi mp = mph.findById(form.getNo_kp_carian());
		 String c = "";
		 if(!(mp == null)){
			 model.addAttribute("pengundi",mp);
			 form.setWarning("Maklumat pengundi ini telah dikemaskini.");
			 c = getKategoriMp(mp, c);
			 form.setCategory(c);
		 }else{
			 model.addAttribute("pengundi",p);
			 c = getKategori(p, c);
			 form.setCategory(c);
		 }
			
		model.addAttribute("pengundiForm",form);
		model.addAttribute("mode","true");
		return "pengundi";
	}
	
	@RequestMapping(value = "/kemaskini",  method = RequestMethod.POST)
	public String kemaskini(Model model,@ModelAttribute("pengundiForm")PengundiForm form) {
		 logger.info("kemaskini pengundi");
		 Pengundi p = ph.findById(form.getNo_kp_carian());
		 MirrorPengundi mp = mph.findById(form.getNo_kp_carian());
		 String c = "";
		 if(!(mp == null)){
			 form.setNo_kp(mp.getNoKp());
			 form.setAlamat(mp.getAlamat());
			 form.setTel_no2(mp.getTelNo2());
			 c = getKategoriMp(mp, c);
			 form.setCategory(c);
			 model.addAttribute("pengundi",p);
		 }else{
			 form.setNo_kp(p.getNoKp());
			 form.setAlamat(p.getAlamat());
			 form.setTel_no2(p.getTelNo2());
			 c = getKategori(p, c);
			 form.setCategory(c);
			 model.addAttribute("pengundi",p);
		 }
		
			model.addAttribute("pengundiForm",form);
			
		model.addAttribute("mode","false");
		return "pengundi";
	}

	private String getKategori(Pengundi p, String c) {
		if(!(p.getCategoryA() == null))
			 c = "A";
		 if(!(p.getCategoryB()== null))
			 c = "B";
		 if(!(p.getCategoryC() == null))
			 c = "C";
		 if(!(p.getCategoryD() == null))
			 c = "D";
		 if(!(p.getCategoryE() == null))
			 c = "E";
		 if(!(p.getCategoryF() == null))
			 c = "F";
		 if(!(p.getCategoryG() == null))
			 c = "G";
		 if(!(p.getCategoryH() == null))
			 c = "H";
		 if(!(p.getCategoryI() == null))
			 c = "I";
		return c;
	}
	
	private String getKategoriMp(MirrorPengundi p, String c) {
		if(!(p.getCategoryA() == null))
			 c = "A";
		 if(!(p.getCategoryB()== null))
			 c = "B";
		 if(!(p.getCategoryC() == null))
			 c = "C";
		 if(!(p.getCategoryD() == null))
			 c = "D";
		 if(!(p.getCategoryE() == null))
			 c = "E";
		 if(!(p.getCategoryF() == null))
			 c = "F";
		 if(!(p.getCategoryG() == null))
			 c = "G";
		 if(!(p.getCategoryH() == null))
			 c = "H";
		 if(!(p.getCategoryI() == null))
			 c = "I";
		return c;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/save",  method = RequestMethod.POST)
	public String save(Model model,@ModelAttribute("pengundiForm")PengundiForm form) {
		logger.info("simpan pengundi");
		
		Pengundi p = ph.findById(form.getNo_kp());
		MirrorPengundi mp = mph.mergePengundiToMirrorPengundi(p);
		 
		mp.setTelNo2(form.getTel_no2());
		mp.setAlamat(form.getAlamat());
		setMpCategory(form, mp);
		 if(!(mp == null)){
			 mph.merge(mp);
		 }else{
			 mph.persist(mp);
			 
		 }
		model.addAttribute("pengundiForm", form);
		model.addAttribute("pengundi",mp);
		model.addAttribute("mode","true");
		return "pengundi";
	}

	private void setMpCategory(PengundiForm form, MirrorPengundi mp) {
		if(form.getCategory().equals("A")){
			mp.setCategoryA("Y");
		}
		if(form.getCategory().equals("B")){
			mp.setCategoryB("Y");		
		}
		if(form.getCategory().equals("C")){
			mp.setCategoryC("Y");
		}
		if(form.getCategory().equals("D")){
			mp.setCategoryD("Y");
		}
		if(form.getCategory().equals("E")){
			mp.setCategoryE("Y");
		}
		if(form.getCategory().equals("F")){
			mp.setCategoryF("Y");
		}
		if(form.getCategory().equals("G")){
			mp.setCategoryG("Y");
		}
		if(form.getCategory().equals("H")){
			mp.setCategoryH("Y");
		}
		if(form.getCategory().equals("I")){
			mp.setCategoryI("Y");
		}
	}
	
	@RequestMapping(value = "/test",  method = RequestMethod.GET)
	public String test() {
//	List<MirrorPengundi> list = pengundiService.findAll();
		return "index";
	}
	

}
