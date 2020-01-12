package com.sopra.artemis.modeles;

import java.util.Map;

import org.springframework.data.annotation.Id;

public class Instruction {

		@Id
		public String id;
		
		public String typeInstruction;
		
		public String ordreLancement;
		
		public Map<String,String> parametresInstruction;
		
		public Instruction(String typeInstruction,String ordreLancement,Map<String,String> parametresInstruction) {
			this.typeInstruction=typeInstruction;
			this.ordreLancement=ordreLancement;
			this.parametresInstruction=parametresInstruction;
		}
		
		@Override
		public String toString() {
			return String.format("Instruction[id='%s', typeInstruction='%s', ordreLancement='%s', parametresInstruction='%s'",id,typeInstruction,ordreLancement,parametresInstruction);
		}
}
