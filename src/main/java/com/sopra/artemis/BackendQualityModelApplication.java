package com.sopra.artemis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sopra.artemis.modeles.Instruction;
import com.sopra.artemis.modeles.QualityModele;
import com.sopra.artemis.repositories.QualityModeleRepository;

@SpringBootApplication
public class BackendQualityModelApplication implements CommandLineRunner {
	
	@Autowired 
	private QualityModeleRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendQualityModelApplication.class, args);
	}
	
	@Override
	  public void run(String... args) throws Exception {
		repository.deleteAll();
		
		// Save a couple of QualityModele
		Map<String,String> mapTestTiti  = new HashMap<>();
		mapTestTiti.put("page", "corbeille");
		mapTestTiti.put("action","cliquer");
		mapTestTiti.put("data", "06TOTO");
		Instruction instructionTestTiti = new Instruction("IHM","1",mapTestTiti);
		
		Map<String,String> mapTestToto  = new HashMap<>();
		mapTestToto.put("page", "corbeille");
		mapTestToto.put("action","cliquer");
		mapTestToto.put("data", "06TOTO");
		Instruction instructionTestToto = new Instruction("IHM","2",mapTestToto);
		
		List<Instruction> instructionsTest  = new ArrayList<>();
		instructionsTest.add(instructionTestTiti);
		instructionsTest.add(instructionTestToto);
		
		Map<String,String> qualityHeaderTest = new HashMap<>();
		qualityHeaderTest.put("nom","test01");
		qualityHeaderTest.put("description","cas de test 01");
		qualityHeaderTest.put("casMetier","SFTTH");
		qualityHeaderTest.put("typeInjection","WS");
		
		QualityModele qualityModeleTest = new QualityModele("CAS001",qualityHeaderTest,instructionsTest);
		
		repository.save(qualityModeleTest);
		
		Map<String,String> mapTestTutu  = new HashMap<>();
		mapTestTutu.put("nomProcess", "CompletudeCommande");
		mapTestTutu.put("executer", "true");
		Instruction instructionTestTutu = new Instruction("PROCESS","3",mapTestTutu);
		
		Map<String,String> mapTestTata  = new HashMap<>();
		mapTestTata.put("nomProcess", "CompletudeInterferance");
		mapTestTutu.put("executer", "false");
		Instruction instructionTestTata = new Instruction("PROCESS","4",mapTestTata);
		
		List<Instruction> instructionsTest2  = new ArrayList<>();
		instructionsTest2.add(instructionTestTutu);
		instructionsTest2.add(instructionTestTata);
		
		Map<String,String> qualityHeaderTest2 = new HashMap<>();
		qualityHeaderTest2.put("nom","test02");
		qualityHeaderTest2.put("description","cas de test 02");
		qualityHeaderTest2.put("casMetier","VFTTH");
		qualityHeaderTest2.put("typeInjection","MQ");
		
		QualityModele qualityModeleTest2 = new QualityModele("CAS002",qualityHeaderTest2,instructionsTest2);
		
		repository.save(qualityModeleTest2);
		
		System.out.println("qualityModele found with findAll()");
		System.out.println("-------------------------------");
		for (QualityModele qualityModele : repository.findAll()) {
		      System.out.println(qualityModele);
		    }
	}
}


