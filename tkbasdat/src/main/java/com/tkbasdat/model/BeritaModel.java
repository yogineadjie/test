package com.tkbasdat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeritaModel {
	
	private String nama;
	private String url;
	private String judul;
	private String topik;
	private String created_at;
	private String updated_at;
	private String rerata_rating;
	private String provinsi;
	
}
