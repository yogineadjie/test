package com.tkbasdat.model;

import com.tkbasdat.model.NarasumberModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NarasumberModel {
	
	private int id;
	private String nama;
	private String email;
	private String tempat;
	private String tanggal;
	private String no_hp;
	private int jumlah_berita;
	private int rerata_kata;
	private int id_universitas;
	private String judul;
	private String topik;
	private double rerata_rating;
	
	

}
