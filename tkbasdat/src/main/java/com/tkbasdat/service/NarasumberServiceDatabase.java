package com.tkbasdat.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkbasdat.service.NarasumberServiceDatabase;
import com.tkbasdat.dao.NarasumberMapper;
import com.tkbasdat.model.NarasumberModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class NarasumberServiceDatabase implements NarasumberService {
	
	public NarasumberServiceDatabase() {}

	public NarasumberServiceDatabase(NarasumberMapper narasumberMapper) {
		this.narasumberMapper = narasumberMapper;
	}
	
    @Autowired
    private NarasumberMapper narasumberMapper;


    @Override
    public NarasumberModel selectNarasumber(String nama)
    {
     
        return narasumberMapper.selectNarasumber(nama);
    }
    
    @Override
    public List<NarasumberModel> selectBeritaNarasumber(String nama)
    {
     
        return narasumberMapper.selectBeritaNarasumber(nama);
    }
}
