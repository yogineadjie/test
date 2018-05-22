package com.tkbasdat.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tkbasdat.model.RatingModel;
import com.tkbasdat.service.BeritaService;
import com.tkbasdat.service.RatingService;

@Controller
public class RatingController {
	@Autowired
    RatingService ratingDAO;
	
	@Autowired
	BeritaService beritaDAO;
	
	@RequestMapping("/rating")
    public String showFormRating (Model model,
    		@RequestParam(value="url", required = true) String url,
    		HttpServletRequest request) {
		RatingModel rating = ratingDAO.selectRatingByIPAndUrl(request.getRemoteAddr(), url);
		
		if(rating == null) {
			model.addAttribute("title","Rate the News!");
			model.addAttribute ("url", url);
	        return "rating";
		} else {
			model.addAttribute("title","No spamming please!");
			return "success";
		}
		
    }
	
	@RequestMapping("/rating/submit")
    public String submitRating (Model model,
    		@RequestParam(value="url", required=false) String url,
    		HttpServletRequest request,
    		@RequestParam(value="nilai", required=false) double nilai) {
		
		RatingModel ratingObj = new RatingModel();
		ratingObj.setUrlBerita(url);
		ratingObj.setIpAddress(request.getRemoteAddr());
		ratingObj.setNilai(nilai);
		
		ratingDAO.addRating(ratingObj);
		
		beritaDAO.updateRerataRating(ratingDAO.selectAvgRatingByUrl(url), url);
		
		model.addAttribute("title","Thanks for your rating");
		return "success";
    }
}
