package com.tkbasdat.model;

public class RatingModel {
	private String url_berita;
	private String ip_address;
	private double nilai;
	
	public void setUrlBerita(String url_berita) {
		this.url_berita = url_berita;
	}
	
	public String getUrlBerita() {
		return this.url_berita;
	}
	
	public void setIpAddress(String ip_address) {
		this.ip_address = ip_address;
	}
	
	public String getIpAddress() {
		return this.ip_address;
	}
	
	public void setNilai(double nilai) {
		this.nilai = nilai;
	}
	
	public double getNilai() {
		return this.nilai;
	}
}
