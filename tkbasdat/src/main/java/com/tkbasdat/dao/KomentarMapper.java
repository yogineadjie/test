package com.tkbasdat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.tkbasdat.model.KomentarModel;

@Mapper
public interface KomentarMapper {
	@Select("select * from komentar where url_berita = #{url}")
    List<KomentarModel> selectAllKomentarByUrl(@Param("url") String url);
	
	@Insert("insert into komentar (id,tanggal,jam,konten,nama_user,email_user,url_user,url_berita) values (default,#{tanggal},#{jam},#{konten},#{nama_user},#{email_user},#{url_user},#{url_berita})")
	void addKomentar(KomentarModel komentar);
}
