package com.tkbasdat.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tkbasdat.model.NarasumberModel;

@Mapper
public interface NarasumberMapper {
	
	 @Select("select nama, email, tempat, tanggal, no_hp, jumlah_berita,"
	         +"rerata_kata from narasumber where nama = #{nama}")
	    NarasumberModel selectNarasumber(@Param("nama") String nama);
	 
	 @Select("select nama,judul, topik, rerata_rating from narasumber_berita "
			 +"join narasumber on narasumber_berita.id_narasumber = narasumber.id join berita on "
			 +"narasumber_berita.url_berita = berita.url where nama = #{nama}")
	        List<NarasumberModel> selectBeritaNarasumber(@Param("nama") String nama);

}
