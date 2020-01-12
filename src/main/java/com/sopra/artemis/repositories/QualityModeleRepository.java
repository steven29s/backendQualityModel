package com.sopra.artemis.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sopra.artemis.modeles.Instruction;
import com.sopra.artemis.modeles.QualityModele;

@RepositoryRestResource(collectionResourceRel = "qualityModele" , path = "qualityModele")
public interface QualityModeleRepository extends MongoRepository<QualityModele, String>{
	
	public QualityModele findByQualityHeader(Map<String,String> qualityHeader);
	public QualityModele findByInstructions(List<Instruction> instructions);
	public QualityModele findByNom(@Param("nom") String nom);
	
	

}
