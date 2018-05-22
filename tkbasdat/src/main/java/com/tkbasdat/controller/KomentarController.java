package com.tkbasdat.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tkbasdat.model.KomentarModel;
import com.tkbasdat.model.NarasumberModel;
import com.tkbasdat.service.KomentarService;
import com.tkbasdat.service.NarasumberService;

@Controller
public class KomentarController {
	@Autowired
    KomentarService komentarDAO;
	
	@Autowired
	NarasumberService narasumberDAO;
	
	@RequestMapping("/komentar")
    public String showFormKomentar (Model model,
    		@RequestParam(value="url", required = true) String url) {
		model.addAttribute("title","Give comment!");
		model.addAttribute ("url", url);
        return "comment";
    }
	
	@RequestMapping("/komentar/submit")
    public String submitKomentar (Model model,
    		@RequestParam(value="url", required=false) String url,
    		@RequestParam(value="komentar", required=false) String komentar) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		NarasumberModel user = narasumberDAO.selectNarasumber(auth.getName());		
		KomentarModel komentarObj = new KomentarModel();
		
		komentarObj.setUrlBerita(url);
		komentarObj.setKonten(komentar);
		komentarObj.setTanggal(new Date());
		komentarObj.setJam(new Timestamp(System.currentTimeMillis()));
		komentarObj.setEmailUser(user.getEmail());
		komentarObj.setNamaUser(user.getNama());
		komentarObj.setUrlUser("/narasumber/"+user.getNama());
		
		komentarDAO.addKomentar(komentarObj);
		
		model.addAttribute("title","Thanks for your comment");
		
		return "success";
    }
	
}
