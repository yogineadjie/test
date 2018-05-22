package com.tkbasdat.service;

import com.tkbasdat.model.RatingModel;

public interface RatingService {
	RatingModel selectRatingByIPAndUrl(String ip, String url);
	void addRating(RatingModel rating);
	double selectAvgRatingByUrl(String url_berita);
}
