package com.tkbasdat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkbasdat.dao.BeritaMapper;
import com.tkbasdat.model.BeritaModel;
import com.tkbasdat.model.NarasumberModel;
import com.tkbasdat.model.OriginalBeritaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeritaServiceDatabase implements BeritaService {

public BeritaServiceDatabase () {}
	
	public BeritaServiceDatabase(BeritaMapper beritaMapper) {
		this.beritaMapper = beritaMapper;
	}
	
	@Autowired
    private BeritaMapper beritaMapper;

	@Override
    public List<BeritaModel> selectAllBerita()
    {
     
        return beritaMapper.selectAllBerita();
    }
	
	 @Override
	    public BeritaModel selectBerita(String judul)
	    {
	     
	        return beritaMapper.selectBerita(judul);
	    }

	@Override
	public OriginalBeritaModel selectBeritaByUrl(String url) {
		return beritaMapper.selectBeritaByUrl(url);
	}

	@Override
	public void addBerita(OriginalBeritaModel berita) {
		beritaMapper.addBerita(berita);
	}

	@Override
	public void updateRerataRating(double rerata_rating, String url) {
		beritaMapper.updateRerataRating(rerata_rating, url);
	}
}
