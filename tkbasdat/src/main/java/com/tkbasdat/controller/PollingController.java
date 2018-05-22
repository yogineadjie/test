package com.tkbasdat.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tkbasdat.model.OriginalBeritaModel;
import com.tkbasdat.model.OriginalPollingModel;
import com.tkbasdat.model.PollingBeritaModel;
import com.tkbasdat.model.PollingBiasaModel;
import com.tkbasdat.model.PollingModel;
import com.tkbasdat.service.PollingService;

@Controller
public class PollingController {
	
	@Autowired
	PollingService pollingDAO;
	
	 @RequestMapping("/polling/lihat")
	    public String viewPolling(Model model)
	    {
	        List<PollingModel> polling = pollingDAO.selectAllPolling();

	        if (polling != null) {
	            model.addAttribute ("polling", polling);
	            return "view-polling";
	        } else {
	            model.addAttribute ("polling", polling);
	            return "not-found";
	        }
	    }
	 
	 
	 @RequestMapping("/polling/create-default")
	 public String showFormCreateDefaultPolling (Model model) {
		 model.addAttribute("title","New Default Polling");
	     return "addPollingDefault";
	 }
	 
	 @RequestMapping("/polling/create-advanced")
	 public String showFormCreateAdvancedPolling (Model model) {
		 model.addAttribute("title","New Polling for Berita");
	     return "addPollingBerita";
	 }
	 
	 @RequestMapping("/polling/create/submit-default")
	 public String submitCreateDefaultPolling (Model model,
	    		@RequestParam(value="desc", required=false) String desc,
	    		@RequestParam(value="startDate", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
	    		@RequestParam(value="endDate", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
		 	
		 	OriginalPollingModel pollingObj = new OriginalPollingModel();
		 	pollingObj.polling_start = startDate;
		 	pollingObj.polling_end = endDate;
		 	pollingObj.total_responden = 0;
		 	
		 	pollingDAO.addPolling(pollingObj);
		 	
		 	PollingBiasaModel pBiasaObj = new PollingBiasaModel();
		 	pBiasaObj.deskripsi = desc;
		 	pBiasaObj.url = "ai.google.com";
		 	pBiasaObj.id_polling = pollingDAO.selectLastInsertedPolling();
		 	
		 	pollingDAO.addPollingDefault(pBiasaObj);
		 	
		 	model.addAttribute("title","Thanks for creating new polling!");
			return "success";
	}
	 
	 @RequestMapping("/polling/create/submit-advanced")
	 public String submitCreateAdvancedPolling (Model model,
	    		@RequestParam(value="url", required=false) String url,
	    		@RequestParam(value="startDate", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
	    		@RequestParam(value="endDate", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
		 	
		 	OriginalPollingModel pollingObj = new OriginalPollingModel();
		 	pollingObj.polling_start = startDate;
		 	pollingObj.polling_end = endDate;
		 	pollingObj.total_responden = 0;
		 	
		 	pollingDAO.addPolling(pollingObj);
		 	
		 	PollingBeritaModel pBeritaObj = new PollingBeritaModel();
		 	pBeritaObj.id_polling = pollingDAO.selectLastInsertedPolling();
		 	pBeritaObj.url_berita = url;
		 	
		 	
		 	pollingDAO.addPollingAdvanced(pBeritaObj);
		 	
		 	model.addAttribute("title","Thanks for creating new polling!");
			return "success";
	}
}
