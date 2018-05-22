package com.tkbasdat.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tkbasdat.model.KomentarModel;
import com.tkbasdat.dao.KomentarMapper;

@Service
public class KomentarServiceDatabase implements KomentarService {
	
	@Autowired
	private KomentarMapper komentarMapper;

	@Override
	public List<KomentarModel> selectAllKomentarByUrl(String url) {
		return komentarMapper.selectAllKomentarByUrl(url);
	}

	@Override
	public void addKomentar(KomentarModel komentar) {
		komentarMapper.addKomentar(komentar);
	}

}
