package com.tkbasdat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.tkbasdat.model.RatingModel;

@Mapper
public interface RatingMapper {
	@Select("select * from rating where ip_address = #{ip} and url_berita = #{url}")
    RatingModel selectRatingByIPAndUrl(@Param("ip") String ip, @Param("url") String url);
	
	@Insert("insert into rating (url_berita,ip_address,nilai) values (#{url_berita},#{ip_address},#{nilai})")
	void addRating(RatingModel rating);
	
	@Select("select avg(nilai) from rating where url_berita = #{url_berita}")
    double selectAvgRatingByUrl(@Param("url_berita") String url_berita);
}
