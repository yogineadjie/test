package com.tkbasdat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollingModel {
	
	private String polling_start;
	private String polling_end;
	private int total_responden;
	private String judul;
	private String topik;
}
