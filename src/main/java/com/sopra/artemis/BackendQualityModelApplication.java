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
		Instruction instructionTestToto = new Instruction("IHM","1",mapTestToto);
		
		List<Instruction> instructionsTest  = new ArrayList<>();
		instructionsTest.add(instructionTestTiti);
		instructionsTest.add(instructionTestToto);
		
		Map<String,String> qualityHeaderTest = new HashMap<>();
		qualityHeaderTest.put("nom","test01");
		qualityHeaderTest.put("description","cas de test 01");
		qualityHeaderTest.put("casMetier","je sais pas");
		qualityHeaderTest.put("typeInjection","MQ ou WS");
		
		QualityModele qualityModeleTest = new QualityModele("CAS001",qualityHeaderTest,instructionsTest);
		
		repository.save(qualityModeleTest);
		
		System.out.println("qualityModele found with findAll()");
		System.out.println("-------------------------------");
		for (QualityModele qualityModele : repository.findAll()) {
		      System.out.println(qualityModele);
		    }
	}
}


