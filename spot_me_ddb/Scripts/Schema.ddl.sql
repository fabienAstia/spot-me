DROP TABLE IF EXISTS t_spots, t_categories;

CREATE TABLE t_categories (
	id_category int GENERATED ALWAYS AS IDENTITY,
	category_name varchar (100) NOT null,
	CONSTRAINT t_categories_pk PRIMARY KEY (id_category),
	CONSTRAINT t_categories_uk UNIQUE (category_name)
);

CREATE TABLE t_spots(
   	id_spot int GENERATED ALWAYS AS IDENTITY, 
   	spot_name VARCHAR(200) NOT null,
   	spot_lat DECIMAL(9,6) NOT null,
   	spot_long DECIMAL(9,6) NOT null,
   	spot_desc VARCHAR(2000),
   	spot_img VARCHAR(41),
   	spot_category_id int,
   	CONSTRAINT t_spots_pk PRIMARY KEY(id_spot),
   	CONSTRAINT t_spots_uk UNIQUE (spot_name, spot_lat, spot_long),
   	CONSTRAINT t_spots_categories_fk FOREIGN KEY (spot_category_id) 
   		REFERENCES t_categories (id_category)
);

