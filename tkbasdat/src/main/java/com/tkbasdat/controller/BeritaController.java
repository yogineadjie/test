package com.tkbasdat.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tkbasdat.model.BeritaModel;
import com.tkbasdat.model.KomentarModel;
import com.tkbasdat.model.OriginalBeritaModel;
import com.tkbasdat.service.BeritaService;
import com.tkbasdat.service.KomentarService;

@Controller
public class BeritaController {
	
	@Autowired
	BeritaService beritaDAO;
	
	@Autowired
    KomentarService komentarDAO;
	
	@RequestMapping("/berita")
	public String berita(Model model) {
		
		List<BeritaModel> berita= beritaDAO.selectAllBerita();
		model.addAttribute("berita",berita);
		return "viewAllBerita";
	}
	
	@RequestMapping("/berita/detail/{url}")
    public String viewPath (Model model,
            @PathVariable(value = "url") String url)
    {
        BeritaModel berita = beritaDAO.selectBerita(url);

        if (berita != null) {
        		List<KomentarModel> komentars = komentarDAO.selectAllKomentarByUrl(berita.getUrl());
            model.addAttribute ("berita", berita);
            model.addAttribute("komentars",komentars);
            model.addAttribute("title",berita.getJudul());
            return "viewBerita";
        } else {
            model.addAttribute ("berita", berita);
            return "not-found";
        }
    }
	
	@RequestMapping("/berita/create")
    public String showFormCreateBerita (Model model) {
		model.addAttribute("title","New Berita");
        return "addBerita";
    }
	
	@RequestMapping("/berita/create/submit")
    public String submitAddBerita (Model model,
    		@RequestParam(value="judul", required=false) String judul,
    		@RequestParam(value="url", required=false) String url,
    		@RequestParam(value="topik", required=false) String topik,
    		@RequestParam(value="jumlahKata", required=false) int jumlahKata,
    		@RequestParam(value="universitas", required=false) int idUniversitas) {
		if(beritaDAO.selectBeritaByUrl(url) == null) {
			OriginalBeritaModel beritaObj = new OriginalBeritaModel();
			beritaObj.url = url;
			beritaObj.judul = judul;
			beritaObj.topik = topik;
			beritaObj.jumlah_kata = jumlahKata;
			beritaObj.id_universitas = idUniversitas;
			beritaObj.created_at = new Date();
			beritaObj.updated_at = new Date();
			beritaObj.rerata_rating = 0.0;
			
			beritaDAO.addBerita(beritaObj);
			
			model.addAttribute("title","Thanks for creating new berita!");
			return "success";
		} else {
			model.addAttribute("title","Sorry, but url inserted already exists!");
			return "success";
		}
    }
}
