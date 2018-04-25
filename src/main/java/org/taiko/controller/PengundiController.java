package org.taiko.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.taiko.dao.MirrorPengundiHome;
import org.taiko.dao.PengundiHome;
import org.taiko.dao.PinKodHome;
import org.taiko.entity.MirrorPengundi;
import org.taiko.entity.Pengundi;
import org.taiko.entity.PinKod;
import org.taiko.form.PengundiForm;

@Controller
public class PengundiController {
	
	
	@Autowired PengundiHome ph;
	@Autowired private MirrorPengundiHome mph;
	@Autowired private PinKodHome pkh;
	
	private static final Logger logger = LoggerFactory.getLogger(PengundiController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String menu(Model model, HttpSession sesion) {
		logger.info("Page menu");
		PengundiForm form = new PengundiForm();
		form.setMethodName("menu");
		model.addAttribute("pengundiForm", form);
		model.addAttribute("pinKod", sesion.getAttribute("pinKod"));
		model.addAttribute("sah", true);
		logger.info((String) sesion.getAttribute("pinKod"));
		return "index";
	}
	
	@RequestMapping(value = "/pengesahan",  method = RequestMethod.POST)
	public String pengesahan(Model model,HttpSession sesion,@ModelAttribute("pengundiForm")PengundiForm form) {
		logger.info("Pengesahan");
		logger.info(form.getPinKod());
		PinKod pk = pkh.findById(1);
		if(form.getPinKod().equals(pk.getPin())){
			model.addAttribute("sah", true);
			sesion.setAttribute("pinKod", pk.getPin());
		}else{
			model.addAttribute("sah", false);
			sesion.setAttribute("pinKod", null);
		}
		if(form.getMethodName().equals("menu")){
			return menu(model,sesion);
		}else if(form.getMethodName().equals("carianPengundi")){
			return carianPengundi(model,sesion);
		}else if(form.getMethodName().equals("tambah")){
			return tambah(model,form);
		}else{
			return null;
		}
		
		 
	}
	
	@RequestMapping(value = "/carianPengundi",  method = RequestMethod.GET)
	public String carianPengundi(Model model,HttpSession sesion) {
		logger.info("Page carian pengundi");
		model.addAttribute("mode","true");
		PengundiForm form = new PengundiForm();
		form.setMethodName("carianPengundi");
		model.addAttribute("pengundiForm", form);
		model.addAttribute("sah", true);
		model.addAttribute("pinKod", sesion.getAttribute("pinKod"));
		return "pengundi";
	}
	
	@RequestMapping(value = "/senaraiPengundi",  method = RequestMethod.GET)
	public String senaraiPengundi() {
//		List<Pengundi> pengundiL =  ph.findAll();
		List<MirrorPengundi> mpl = mph.findAll();
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
			 form.setNegeri(mp.getNegeri());
		 }else{
			 form.setNo_kp(p.getNoKp());
			 form.setAlamat(p.getAlamat());
			 form.setTel_no2(p.getTelNo2());
			 form.setNegeri(p.getNegeri());
			 c = getKategori(p, c);
			 form.setCategory(c.substring(9, 10));
			 model.addAttribute("pengundi",p);
		 }
		model.addAttribute("negeriL",listNegeri());	
		model.addAttribute("pengundiForm",form);
		model.addAttribute("mode","false");
		return "pengundi";
	}
	
	
	@RequestMapping(value = "/tambah",  method = RequestMethod.POST)
	public String tambah(Model model,@ModelAttribute("pengundiForm")PengundiForm form) {
		 logger.info("tambah pengundi");
		MirrorPengundi mp = new MirrorPengundi(); 
		mp.setNoKp(form.getNo_kp_carian());
		form.setMethodName("tambah");
		model.addAttribute("mp",mp);
		model.addAttribute("negeriL",listNegeri());	
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
			 mp.setNegeri(form.getNegeri());
			 setMpCategory(form, mp);
			 mph.merge(mp);
		 }else{
			 Pengundi p = ph.findById(form.getNo_kp());
			 mp = mph.mergePengundiToMirrorPengundi(p);
			 mp.setTelNo2(form.getTel_no2());
			 mp.setAlamat(form.getAlamat());
			 mp.setNegeri(form.getNegeri());
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
			PengundiForm form = new PengundiForm();
			form.setWarning("Maklumat pengundi ini telah dikemaskini.");
			String c = getKategoriMp(mp, "");
		    form.setCategory(c);
		    form.setNo_kp_carian(mp.getNoKp());
			model.addAttribute("pengundiForm", form);
			model.addAttribute("save","true");
			model.addAttribute("mode","true");
			model.addAttribute("pengundi",mp);
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
		}else{
			mp.setCategoryA(null);
		}
		if(form.getCategory().equals("B")){
			mp.setCategoryB("Y");		
		}else{
			mp.setCategoryB(null);
		}
		if(form.getCategory().equals("C")){
			mp.setCategoryC("Y");
		}else{
			mp.setCategoryC(null);
		}
		if(form.getCategory().equals("D")){
			mp.setCategoryD("Y");
		}else{
			mp.setCategoryD(null);
		}
		if(form.getCategory().equals("E")){
			mp.setCategoryE("Y");
		}else{
			mp.setCategoryE(null);
		}
		if(form.getCategory().equals("F")){
			mp.setCategoryF("Y");
		}else{
			mp.setCategoryF(null);
		}
		if(form.getCategory().equals("G")){
			mp.setCategoryG("Y");
		}else{
			mp.setCategoryG(null);
		}
		if(form.getCategory().equals("H")){
			mp.setCategoryH("Y");
		}else{
			mp.setCategoryH(null);
		}
		if(form.getCategory().equals("I")){
			mp.setCategoryI("Y");
		}else{
			mp.setCategoryI(null);
		}
		if(form.getCategory().equals("J")){
			mp.setCategoryJ("Y");
		}else{
			mp.setCategoryJ(null);
		}
		if(form.getCategory().equals("K")){
			mp.setCategoryK("Y");
		}else{
			mp.setCategoryK(null);
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
		if(mp.getCategoryA().equals("J")){
			nmp.setCategoryJ("Y");
		}
		if(mp.getCategoryA().equals("K")){
			nmp.setCategoryK("Y");
		}
	}
	
	public List<String> listNegeri(){
		List<String> negeriL = new ArrayList<String>();
		negeriL.add("JOHOR");
		negeriL.add("KEDAH");
		negeriL.add("KELANTAN");
		negeriL.add("KUALA LUMPUR");
		negeriL.add("LABUAN");
		negeriL.add("MELAKA");
		negeriL.add("NEGERI SEMBILAN");
		negeriL.add("PAHANG");
		negeriL.add("PERAK");
		negeriL.add("PERLIS");
		negeriL.add("PULAU PINANG");
		negeriL.add("PUTRAJAYA");
		negeriL.add("SABAH");
		negeriL.add("SARAWAK");
		negeriL.add("SELANGOR");
		negeriL.add("TERENGGANU");
		return negeriL;
		}
	}
