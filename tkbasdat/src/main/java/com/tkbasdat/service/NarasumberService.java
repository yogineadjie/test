package com.tkbasdat.service;

import java.util.List;

import com.tkbasdat.model.NarasumberModel;

public interface NarasumberService {

	NarasumberModel selectNarasumber (String nama);
	List<NarasumberModel> selectBeritaNarasumber (String nama);
	
	
}
