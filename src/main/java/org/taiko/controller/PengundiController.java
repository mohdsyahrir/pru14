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
		 
		 if(form.getNo_kp_carian() == ""){
			 form.setWarning("no_kp_null");
		 }else if(!(mp == null)){
			 model.addAttribute("pengundi",mp);
			 form.setWarning("Maklumat pengundi ini telah dikemaskini.");
			 c = getKategoriMp(mp, c);
			 form.setCategory(c);
		 }else if(!(p == null)) {
			 model.addAttribute("pengundi",p);
			 c = getKategori(p, c);
			 form.setCategory(c);
		 }else{
			 form.setWarning("Data_null");
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
			 form.setCategory(c.substring(9, 10));
			 model.addAttribute("pengundi",mp);
		 }else{
			 form.setNo_kp(p.getNoKp());
			 form.setAlamat(p.getAlamat());
			 form.setTel_no2(p.getTelNo2());
			 c = getKategori(p, c);
			 form.setCategory(c.substring(9, 10));
			 model.addAttribute("pengundi",p);
		 }
		
			model.addAttribute("pengundiForm",form);
			
		model.addAttribute("mode","false");
		return "pengundi";
	}
	
	
	@RequestMapping(value = "/tambah",  method = RequestMethod.POST)
	public String tambah(Model model,@ModelAttribute("pengundiForm")PengundiForm form) {
		 logger.info("tambah pengundi");
		MirrorPengundi mp = new MirrorPengundi(); 
		mp.setNoKp(form.getNo_kp_carian());
		model.addAttribute("mp",mp);
		return "tambahPengundi";
	}

	private String getKategori(Pengundi p, String c) {
		if(!(p.getCategoryA() == null))
			 c = "Kategori A : Pengundi Luar Hadir Program";
		 if(!(p.getCategoryB()== null))
			 c = "Kategori B : Pengundi Luar Tidak Hadir Program (Putih)";
		 if(!(p.getCategoryC() == null))
			 c = "Kategori C : Pengundi Luar Tiada Kerjasama (Hitam)";
		 if(!(p.getCategoryD() == null))
			 c = "Kategori D : Tidak Angkat Phone ";
		 if(!(p.getCategoryE() == null))
			 c = "Kategori E : No Tiada Dalam Service / Voice Messages ";
		 if(!(p.getCategoryF() == null))
			 c = "Kategori F : Belum Dapat Dihubungi (Tiada Phone No)";
		 if(!(p.getCategoryG() == null))
			 c = "Kategori G : Confirm Pengundi Dalam";
		 if(!(p.getCategoryH() == null))
			 c = "Kategori H : Tidak Dikenal Pasti";
		 if(!(p.getCategoryI() == null))
			 c = "Kategori I : Pengundi Awal";
		 if(!(p.getCategoryJ() == null))
			 c = "Kategori J : Pengundi Pos";
		 if(!(p.getCategoryK() == null))
			 c = "Kategori K : Bukan Pengundi Putrajaya";
		return c;
	}
	
	private String getKategoriMp(MirrorPengundi p, String c) {
		if(!(p.getCategoryA() == null))
			 c = "Kategori A : Pengundi Luar Hadir Program";
		 if(!(p.getCategoryB()== null))
			 c = "Kategori B : Pengundi Luar Tidak Hadir Program (Putih)";
		 if(!(p.getCategoryC() == null))
			 c = "Kategori C : Pengundi Luar Tiada Kerjasama (Hitam)";
		 if(!(p.getCategoryD() == null))
			 c = "Kategori D : Tidak Angkat Phone ";
		 if(!(p.getCategoryE() == null))
			 c = "Kategori E : No Tiada Dalam Service / Voice Messages ";
		 if(!(p.getCategoryF() == null))
			 c = "Kategori F : Belum Dapat Dihubungi (Tiada Phone No)";
		 if(!(p.getCategoryG() == null))
			 c = "Kategori G : Confirm Pengundi Dalam";
		 if(!(p.getCategoryH() == null))
			 c = "Kategori H : Tidak Dikenal Pasti";
		 if(!(p.getCategoryI() == null))
			 c = "Kategori I : Pengundi Awal";
		 if(!(p.getCategoryJ() == null))
			 c = "Kategori J : Pengundi Pos";
		 if(!(p.getCategoryK() == null))
			 c = "Kategori K : Bukan Pengundi Putrajaya";
		return c;
	}
	
	@RequestMapping(value = "/save",  method = RequestMethod.POST)
	public String save(Model model,@ModelAttribute("pengundiForm")PengundiForm form) {
		logger.info("simpan pengundi");
		MirrorPengundi mp = mph.findById(form.getNo_kp());
		 if(!(mp == null)){
			 mp.setTelNo2(form.getTel_no2());
			 mp.setAlamat(form.getAlamat());
			 setMpCategory(form, mp);
			 mph.merge(mp);
		 }else{
			 Pengundi p = ph.findById(form.getNo_kp());
			 mp = mph.mergePengundiToMirrorPengundi(p);
			 mp.setTelNo2(form.getTel_no2());
			 mp.setAlamat(form.getAlamat());
			 setMpCategory(form, mp);
			 mph.persist(mp);
		 }
		 String c = getKategoriMp(mp, "");
		 form.setCategory(c);
		model.addAttribute("pengundiForm", form);
		model.addAttribute("pengundi",mp);
		model.addAttribute("mode","true");
		model.addAttribute("saveKemaskini","true");
		return "pengundi";
	}
	
	
	@RequestMapping(value = "/saveBaru",  method = RequestMethod.POST)
	public String saveBaru(Model model,@ModelAttribute("mp")MirrorPengundi mp) {
		logger.info("simpan pengundi");
		String page = "";
		MirrorPengundi nmp = mp;
		setMpCategory(nmp, mp);
		try {
			mph.persist(nmp);
			model.addAttribute("save","true");
			model.addAttribute("mode","true");
			model.addAttribute("pengundiForm", new PengundiForm());
			page = "pengundi";
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("save","false");
			page = "tambahPengundi";
			model.addAttribute("mp",nmp);
			
		}
		return page;
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
	
	
	private void setMpCategory(MirrorPengundi nmp,MirrorPengundi mp) {
		if(mp.getCategoryA().equals("A")){
			nmp.setCategoryA("Y");
		}
		if(mp.getCategoryA().equals("B")){
			nmp.setCategoryB("Y");		
		}
		if(mp.getCategoryA().equals("C")){
			nmp.setCategoryC("Y");
		}
		if(mp.getCategoryA().equals("D")){
			nmp.setCategoryD("Y");
		}
		if(mp.getCategoryA().equals("E")){
			nmp.setCategoryE("Y");
		}
		if(mp.getCategoryA().equals("F")){
			nmp.setCategoryF("Y");
		}
		if(mp.getCategoryA().equals("G")){
			nmp.setCategoryG("Y");
		}
		if(mp.getCategoryA().equals("H")){
			nmp.setCategoryH("Y");
		}
		if(mp.getCategoryA().equals("I")){
			nmp.setCategoryI("Y");
		}
	}
	
	@RequestMapping(value = "/test",  method = RequestMethod.GET)
	public String test() {
//	List<MirrorPengundi> list = pengundiService.findAll();
		return "index";
	}
	

}
