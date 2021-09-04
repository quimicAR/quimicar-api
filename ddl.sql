-- CREATE DATABASE db;

-- CREATE USER administrator WITH PASSWORD 'password';

-- GRANT ALL PRIVILEGES ON DATABASE "db" to administrator;

CREATE TABLE elements (
	"element_id" serial,
	"number" numeric(9,2),
	"name" text,
	"atomic_mass" numeric(9,2),
	"appearance" text,
	"boil" numeric(9,2),
	"category" text,
	"density" numeric(9,2),
	"melt" numeric(9,2),
	"molar_heat" numeric(9,2),
	"discovered_by" text,
	"named_by" text,
	"period" numeric(9,2),
	"phase" text,
	"symbol" text,
	"source" text,
	"spectral_img" text,
	"summary" text,
	"xpos" numeric(9,2),
	"ypos" numeric(9,2),
	"shells" numeric(9,2),
	"electron_configuration" text,
	"electron_configuration_semantic" text,
	"electron_affinity" numeric(9,2),
	"electronegativity_pauling" numeric(9,2),
	"ionization_energies" numeric(9,2),
	"element_img" text,
	PRIMARY KEY( element_id )
);

CREATE TABLE users (
	"user_id" serial,
	"name" text,
	"password" text,
	PRIMARY KEY( user_id )

)