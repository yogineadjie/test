package com.tkbasdat.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.tkbasdat.model.RatingModel;
import com.tkbasdat.dao.RatingMapper;

@Service
public class RatingServiceDatabase implements RatingService {

	@Autowired
	private RatingMapper ratingMapper;
	
	@Override
	public RatingModel selectRatingByIPAndUrl(String ip, String url) {
		return ratingMapper.selectRatingByIPAndUrl(ip, url);
	}

	@Override
	public void addRating(RatingModel rating) {
		ratingMapper.addRating(rating);
	}

	@Override
	public double selectAvgRatingByUrl(String url_berita) {
		return ratingMapper.selectAvgRatingByUrl(url_berita);
	}

}
