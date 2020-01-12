package com.sopra.artemis.modeles;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class QualityModele implements Serializable {

	@Id
	public String id;

	public String nom;

	public Map<String, String> qualityHeader;

	List<Instruction> instructions;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Map<String, String> getQualityHeader() {
		return qualityHeader;
	}

	public void setQualityHeader(Map<String, String> qualityHeader) {
		this.qualityHeader = qualityHeader;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public QualityModele(String nom, Map<String, String> qualityHeader, List<Instruction> instructions) {
		this.nom = nom;
		this.qualityHeader = qualityHeader;
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return String.format("QualityModele[id='%s',nom='%s', qualityHeader='%s', instructions='%s'", id, nom,
				qualityHeader, instructions);
	}

}
