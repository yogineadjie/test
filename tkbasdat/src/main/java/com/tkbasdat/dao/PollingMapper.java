package com.tkbasdat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tkbasdat.model.OriginalPollingModel;
import com.tkbasdat.model.PollingBeritaModel;
import com.tkbasdat.model.PollingBiasaModel;
import com.tkbasdat.model.PollingModel;

@Mapper
public interface PollingMapper {
	
	@Select("select * from polling p join polling_berita b on p.id = b.id_polling join berita r on b.url_berita = r.url")
	        List<PollingModel> selectAllPolling();
	
	@Insert("insert into polling (id,polling_start,polling_end,total_responden) values (default,#{polling_start},#{polling_end},#{total_responden})")
	void addPolling(OriginalPollingModel polling);
	
	@Select("select max(id) from polling")
	int selectLastInsertedPolling();
	
	@Insert("insert into polling_biasa (id_polling,url,deskripsi) values (#{id_polling},#{url},#{deskripsi})")
	void addPollingDefault(PollingBiasaModel polling);
	
	@Insert("insert into polling_berita (id_polling,url_berita) values (#{id_polling},#{url_berita})")
	void addPollingAdvanced(PollingBeritaModel polling);
}
