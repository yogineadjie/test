package com.tkbasdat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;

import com.tkbasdat.model.BeritaModel;
import com.tkbasdat.model.OriginalBeritaModel;

@Mapper
public interface BeritaMapper {

	@Select("select * from berita b join narasumber_berita s on b.url = s.url_berita join narasumber n on n.id = s.id_narasumber")
    List<BeritaModel> selectAllBerita();
	
	@Select("select * from berita b join narasumber_berita s on b.url = s.url_berita join narasumber n on n.id = s.id_narasumber join universitas u on u.id = n.id_universitas where b.judul= #{judul}")
    BeritaModel selectBerita(@Param("judul") String judul);
	
	@Select("select * from berita where url = #{url}")
    OriginalBeritaModel selectBeritaByUrl(@Param("url") String url);
	
	@Insert("insert into berita (url,judul,topik,created_at,updated_at,jumlah_kata,rerata_rating,id_universitas) values (#{url},#{judul},#{topik},#{created_at},#{updated_at},#{jumlah_kata},#{rerata_rating},#{id_universitas})")
	void addBerita(OriginalBeritaModel berita);
	
	@Update("UPDATE berita SET rerata_rating = #{rerata_rating} WHERE url = #{url}")
    void updateRerataRating(@Param("rerata_rating") double rerata_rating, @Param("url") String url);
}
