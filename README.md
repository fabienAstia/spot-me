# Spot Me — Exercices Spring Boot

## Présentation
Ce projet est un exercice pratique autour de **Spring Boot** visant à manipuler :
- la validation personnalisée,
- la gestion des erreurs globales et de champ,
- le `ControllerAdvice` pour centraliser le traitement des exceptions.

Il permet également de prendre en main **le debugger** (points d’arrêt, pas à pas, inspection des variables, etc.).

Technos principales :
- Java 17  
- Maven  
- PostgreSQL  

---

## Objectifs pédagogiques

### 1.1 Validation de l’unicité d’un Spot
- Valider qu’il n’existe pas déjà un **Spot** avec la même combinaison `(nom + latitude + longitude)`.  
- Actuellement : une violation de contrainte en base (`t_spots_uk`).  
- Attendu : retourner un **HTTP 400 BAD REQUEST** avec une erreur de validation claire.  

Contraintes :  
- Validation **globale** (plusieurs champs en même temps).  
- Ne pas valider si un champ est `null`.  
- Comparaison du nom insensible à la casse.  
- Utiliser une **query method** Spring Data (`SpotRepository`).  
- Injection d’un bean Spring dans le validateur possible.  

---

### 1.2 Ajout d’un `ControllerAdvice`
- Centraliser le traitement des erreurs comme dans le projet *restcountries*.  
- Personnaliser le format de sortie pour distinguer :  
  - les **erreurs de champs** (`fieldErrors`),  
  - les **erreurs globales** (`globalErrors`).  

Exemple de JSON attendu :

```json
{
  "fieldErrors": {
    "image": ["FileType", "FileSize"],
    "lng": ["NotNull"],
    "lat": ["Max"]
  },
  "globalErrors": ["SpotUnique"]
}
```

## Modèle de données
## DDL
```
DROP TABLE IF EXISTS t_spots, t_categories;

CREATE TABLE t_categories (
	id_category int GENERATED ALWAYS AS IDENTITY,
	category_name varchar(100) NOT NULL,
	CONSTRAINT t_categories_pk PRIMARY KEY (id_category),
	CONSTRAINT t_categories_uk UNIQUE (category_name)
);

CREATE TABLE t_spots (
   	id_spot int GENERATED ALWAYS AS IDENTITY, 
   	spot_name VARCHAR(200) NOT NULL,
   	spot_lat DECIMAL(9,6) NOT NULL,
   	spot_long DECIMAL(9,6) NOT NULL,
   	spot_desc VARCHAR(2000),
   	spot_img VARCHAR(41),
   	spot_category_id int,
   	CONSTRAINT t_spots_pk PRIMARY KEY(id_spot),
   	CONSTRAINT t_spots_uk UNIQUE (spot_name, spot_lat, spot_long),
   	CONSTRAINT t_spots_categories_fk FOREIGN KEY (spot_category_id) 
   		REFERENCES t_categories (id_category)
);
```

## DL (jeu de tests)
```postgres 
DELETE FROM t_spots;

INSERT INTO t_spots (spot_name, spot_lat, spot_long, spot_desc) VALUES 
	('Aux pigeons blancs', 43.383331, -1.66667, 'Restaurant de cuisine traditionnelle à St Jean de Luz');

```

## Structure du projet
```
src/main/java/co/simplon/spotmebusiness
 ├── controllers        # Contrôleurs REST (SpotController, SpotControllerAdvice, etc.)
 ├── dtos               # Objets de transfert (SpotCreate, SpotView)
 ├── entities           # Entités JPA (Spot)
 ├── exceptions         # Gestion des exceptions & erreurs personnalisées
 ├── repositories       # Accès aux données (SpotRepository)
 ├── services           # Logique métier (SpotService)
 ├── validation         # Validateurs personnalisés
 └── SpotMeBusinessApplication.java   # Classe principale Spring Boot
```

## Lancer le projet 
### Prérequis
- Java 17
- Maven 3+
- PostrgreSQL (avec une base spotme configurée dans application.properties)

### Lancer le projet
mvn spring-boot:run
