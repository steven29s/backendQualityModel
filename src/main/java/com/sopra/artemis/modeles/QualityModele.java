package com.sopra.artemis.modeles;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class QualityModele {

	@Id
	public String id;
	
	public String nom;
	
	public Map<String,String> qualityHeader;
	
	List<Instruction> instructions;
	
	
	public QualityModele(String nom, Map<String,String> qualityHeader,List<Instruction> instructions) {
		this.nom=nom;
		this.qualityHeader=qualityHeader;
		this.instructions=instructions;
	}

	@Override
	public String toString() {
		return String.format("QualityModele[id='%s',nom='%s', qualityHeader='%s', instructions='%s'", id,nom, qualityHeader,instructions);
	}
	
}
