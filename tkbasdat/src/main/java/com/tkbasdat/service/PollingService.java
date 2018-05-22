package com.tkbasdat.service;

import java.util.List;
import com.tkbasdat.model.OriginalPollingModel;
import com.tkbasdat.model.PollingBeritaModel;
import com.tkbasdat.model.PollingBiasaModel;
import com.tkbasdat.model.PollingModel;

public interface PollingService {
	List<PollingModel> selectAllPolling();
	void addPolling(OriginalPollingModel polling);
	int selectLastInsertedPolling();
	void addPollingDefault(PollingBiasaModel polling);
	void addPollingAdvanced(PollingBeritaModel polling);
}
