*** Installer Docker sur une VM Ubuntun Server 18.xx je sais plus ***

 - (Mettre à jour tous le bouzin)
 - sudo apt install docker.io
 - sudo systemctl start docker
 - sudo systemctl enable docker

*** Pour créer une instance mongdb ***

 - sudo docker pull mongo
 - sudo docker run -d -p 27017-27019:27017-27019 --name MongoDBInstance mongo
 
 
* Installer MAVEN sur la VM (prérequis) *
* Avoir java d'installer aussi (mais souvent c'est le cas sur les VM)*

** Projet Maven ** 

- mvn clean install
- mvn spring-boot:run


*** L'idée derrière tout ça ***



*** Le modèle de données ***

Un modèle QualityModele 

	* id 
	* nom
	* qualityHeader (Map<infos:valeur>)
	* List Instruction

Un modèle Instruction 

	* id
	* typeInstruction
	* ordreLancement
	* parametresInstructions(Map<donnee:valeur>)
	
	De cette façon c'est assez souple pour le backend car on peut abstraire toute la complexité de gestion des données. 
	On veut juste que les données du qualityHeader soit garanties (Au niveau de l'IHM ça ira du coup).
	Pour les instructions, c'est super souple car peut importe ce qu'on ira remplir sur l'ihm, on pourra balancer ce qu'on veut. 
	L'instruction représente aussi bien un test IHM, qu'une configuration bouchon, un choix / injection de modèle, un appel à un webService. Etant donné qu'on peut donner autant de parametresInstruction que voulu comme c'est une Map, ça permet de faire quelque chose de très souple niveau IHM si je me trompe pas.
	
=====================================================================================

db.qualityModele.find().pretty()


{
        "_id" : ObjectId("5e1a918a7b37117282afc7bc"),
        "nom" : "CAS001",
        "qualityHeader" : {
                "typeInjection" : "WS",
                "description" : "cas de test 01",
                "nom" : "test01",
                "casMetier" : "SFTTH"
        },
        "instructions" : [
                {
                        "typeInstruction" : "IHM",
                        "ordreLancement" : "1",
                        "parametresInstruction" : {
                                "data" : "06TOTO",
                                "action" : "cliquer",
                                "page" : "corbeille"
                        }
                },
                {
                        "typeInstruction" : "IHM",
                        "ordreLancement" : "2",
                        "parametresInstruction" : {
                                "data" : "06TOTO",
                                "action" : "cliquer",
                                "page" : "corbeille"
                        }
                }
        ],
        "_class" : "com.sopra.artemis.modeles.QualityModele"
}
{
        "_id" : ObjectId("5e1a918a7b37117282afc7bd"),
        "nom" : "CAS002",
        "qualityHeader" : {
                "typeInjection" : "MQ",
                "description" : "cas de test 02",
                "nom" : "test02",
                "casMetier" : "VFTTH"
        },
        "instructions" : [
                {
                        "typeInstruction" : "PROCESS",
                        "ordreLancement" : "3",
                        "parametresInstruction" : {
                                "nomProcess" : "CompletudeCommande",
                                "executer" : "false"
                        }
                },
                {
                        "typeInstruction" : "PROCESS",
                        "ordreLancement" : "4",
                        "parametresInstruction" : {
                                "nomProcess" : "CompletudeInterferance"
                        }
                }
        ],
        "_class" : "com.sopra.artemis.modeles.QualityModele"
}


=====================================================================================

*** Les commandes mongodb *** 

Se connecter sur le docker mongo via exec -it dockerId bash

taper "mongo"

show dbs  - permet de voir les databases.
use dbsName - permet de rentrer dans une database.
db.CollectionName.find().pretty - affiche toutes les entrées de la collection CollectionName et les formatte (pretty)

Dans notre cas quelques commandes utiles : 

db.qualityModele.find( { "qualityHeader.nom" : "test01" } ).pretty() - Recherche par nom de test.

db.qualityModele.find( { "instructions.parametresInstruction.nomProcess" : "CompletudeCommande" } ).pretty() - Recherche par process testé

db.qualityModele.find( { "instructions.typeInstruction" : "PROCESS" } ).pretty() - Recherche par type de test qui test des process.


*** La suite à donner *** 

..........