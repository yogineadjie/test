package com.tkbasdat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkbasdat.dao.PollingMapper;
import com.tkbasdat.model.OriginalPollingModel;
import com.tkbasdat.model.PollingBeritaModel;
import com.tkbasdat.model.PollingBiasaModel;
import com.tkbasdat.model.PollingModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PollingServiceDatabase implements PollingService{
	
	public PollingServiceDatabase () {}
	
	public PollingServiceDatabase(PollingMapper pollingMapper) {
		this.pollingMapper = pollingMapper;
	}
	
	@Autowired
    private PollingMapper pollingMapper;

	@Override
    public List<PollingModel> selectAllPolling()
    {     
        return pollingMapper.selectAllPolling();
    }

	@Override
	public void addPolling(OriginalPollingModel polling) {
		pollingMapper.addPolling(polling);
	}

	@Override
	public void addPollingDefault(PollingBiasaModel polling) {
		pollingMapper.addPollingDefault(polling);
	}

	@Override
	public void addPollingAdvanced(PollingBeritaModel polling) {
		pollingMapper.addPollingAdvanced(polling);
	}

	@Override
	public int selectLastInsertedPolling() {
		return pollingMapper.selectLastInsertedPolling();
	}


}
