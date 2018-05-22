package com.tkbasdat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tkbasdat.model.NarasumberModel;
import com.tkbasdat.service.NarasumberService;

@Controller
public class NarasumberController {

	@Autowired
	NarasumberService narasumberDAO;

    @RequestMapping("/narasumber/{nama}")
    public String viewPath (Model model,
            @PathVariable(value = "nama") String nama)
    {
        NarasumberModel narasumber = narasumberDAO.selectNarasumber (nama);

        if (narasumber != null) {
            model.addAttribute ("narasumber", narasumber);
            return "view-profile";
        } else {
            model.addAttribute ("narasumber", narasumber);
            return "not-found";
        }
    }
    
    @RequestMapping("/narasumber/lihatberita/{nama}")
    public String viewBeritaPath (Model model,
            @PathVariable(value = "nama") String nama)
    {
        List<NarasumberModel> narasumber = narasumberDAO.selectBeritaNarasumber (nama);

        if (narasumber != null) {
            model.addAttribute ("narasumber", narasumber);
            return "view-profile-berita";
        } else {
            model.addAttribute ("narasumber", narasumber);
            return "not-found";
        }
    }

}
