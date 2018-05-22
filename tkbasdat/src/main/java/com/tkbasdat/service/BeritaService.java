package com.tkbasdat.service;

import java.util.List;
import com.tkbasdat.model.BeritaModel;
import com.tkbasdat.model.OriginalBeritaModel;

public interface BeritaService {
	List<BeritaModel> selectAllBerita();
	BeritaModel selectBerita(String judul);
	OriginalBeritaModel selectBeritaByUrl(String url);
	void addBerita(OriginalBeritaModel berita);
	void updateRerataRating(double rerata_rating, String url);
}
