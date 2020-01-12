package com.sopra.artemis.modeles;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class Instruction implements Serializable {

	public String typeInstruction;

	public String ordreLancement;

	public Map<String, String> parametresInstruction;

	public String getTypeInstruction() {
		return typeInstruction;
	}

	public void setTypeInstruction(String typeInstruction) {
		this.typeInstruction = typeInstruction;
	}

	public String getOrdreLancement() {
		return ordreLancement;
	}

	public void setOrdreLancement(String ordreLancement) {
		this.ordreLancement = ordreLancement;
	}

	public Map<String, String> getParametresInstruction() {
		return parametresInstruction;
	}

	public void setParametresInstruction(Map<String, String> parametresInstruction) {
		this.parametresInstruction = parametresInstruction;
	}

	public Instruction() {
	}

	public Instruction(String typeInstruction, String ordreLancement, Map<String, String> parametresInstruction) {
		this.typeInstruction = typeInstruction;
		this.ordreLancement = ordreLancement;
		this.parametresInstruction = parametresInstruction;
	}

	@Override
	public String toString() {
		return String.format("Instruction[typeInstruction='%s', ordreLancement='%s', parametresInstruction='%s'",
				typeInstruction, ordreLancement, parametresInstruction);
	}
}
