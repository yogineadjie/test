package com.tkbasdat.service;

import java.util.List;
import com.tkbasdat.model.KomentarModel;

public interface KomentarService {
	List<KomentarModel> selectAllKomentarByUrl(String url);
	void addKomentar(KomentarModel komentar);
}
