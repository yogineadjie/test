package com.tkbasdat.model;

import java.sql.Timestamp;
import java.util.Date;

public class KomentarModel {
	private Date tanggal;
	private Timestamp jam;
	private String konten;
	private String nama_user;
	private String email_user;
	private String url_user;
	private String url_berita;
	
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	
	public Date getTanggal() {
		return this.tanggal;
	}
	
	public void setJam(Date tanggal) {
		this.tanggal = tanggal;
	}
	
	public Date getJam() {
		return this.tanggal;
	}
	
	public void setKonten(String konten) {
		this.konten = konten;
	}
	
	public String getKonten() {
		return this.konten;
	}
	
	public void setNamaUser(String nama_user) {
		this.nama_user = nama_user;
	}
	
	public String getNamaUser() {
		return this.nama_user;
	}
	
	public void setEmailUser(String email_user) {
		this.email_user = email_user;
	}
	
	public String getEmailUser() {
		return this.email_user;
	}
	
	public void setUrlUser(String url_user) {
		this.url_user = url_user;
	}
	
	public String getUrlUser() {
		return this.url_user;
	}
	
	public void setUrlBerita(String url_berita) {
		this.url_berita = url_berita;
	}
	
	public String getUrlBerita() {
		return this.url_berita;
	}
}
