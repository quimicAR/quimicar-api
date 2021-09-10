CREATE TABLE IF NOT EXISTS elements (
      "id" serial not null,
      "number" numeric(9,2) not null,
      "name" text not null,
      "atomic_mass" numeric(9,2) not null,
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
      "symbol" text not null,
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
      "enabled" bool default true,
      PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS users (
    "id" serial,
    "email" text,
    "password" text,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS user_authenticated (
    authorization_id serial not null,
    authorization_email text not null,
    PRIMARY KEY(authorization_id)
);

INSERT INTO users (email, password) VALUES ('admin@email.com','password');