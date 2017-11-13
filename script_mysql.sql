#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Eleve
#------------------------------------------------------------

CREATE TABLE Eleve(
        matricule               int (11) Auto_increment  NOT NULL ,
        ville_naissance         Varchar (25) NOT NULL ,
        pays_naissance          Varchar (25) NOT NULL ,
        sexe                    Bool NOT NULL ,
        date_inscription        Date NOT NULL ,
        etablissement_precedent Varchar (25) ,
        date_naissance          Date NOT NULL ,
        nom                     Varchar (25) NOT NULL ,
        prenom                  Varchar (25) NOT NULL ,
        id_coord                Int NOT NULL ,
        id_sante                Int NOT NULL ,
        id_classe               Int NOT NULL ,
        PRIMARY KEY (matricule )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Coordonnees
#------------------------------------------------------------

CREATE TABLE Coordonnees(
        id_coord   int (11) Auto_increment  NOT NULL ,
        adresse    Varchar (25) NOT NULL ,
        ville      Varchar (25) NOT NULL ,
        tel_mobile Varchar (25) ,
        tel_fixe   Varchar (25) NOT NULL ,
        mail       Varchar (25) ,
        matricule  Int NOT NULL ,
        PRIMARY KEY (id_coord )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Responsable
#------------------------------------------------------------

CREATE TABLE Responsable(
        id_responsable int (11) Auto_increment  NOT NULL ,
        prenom         Varchar (25) NOT NULL ,
        nom            Varchar (25) NOT NULL ,
        adresse        Varchar (25) NOT NULL ,
        telephone      Varchar (25) NOT NULL ,
        mail           Varchar (25) NOT NULL ,
        PRIMARY KEY (id_responsable )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Carnet_sante
#------------------------------------------------------------

CREATE TABLE Carnet_sante(
        id_sante           int (11) Auto_increment  NOT NULL ,
        medecin_traitement Varchar (25) NOT NULL ,
        telephone_medecin  Varchar (25) NOT NULL ,
        vaccinations       TinyText ,
        allergies          TinyText ,
        matricule          Int NOT NULL ,
        PRIMARY KEY (id_sante )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Classe
#------------------------------------------------------------

CREATE TABLE Classe(
        id_classe int (11) Auto_increment  NOT NULL ,
        nom       Varchar (25) NOT NULL ,
        id_niveau Int NOT NULL ,
        PRIMARY KEY (id_classe )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Niveau_classe
#------------------------------------------------------------

CREATE TABLE Niveau_classe(
        id_niveau int (11) Auto_increment  NOT NULL ,
        nom       Varchar (25) NOT NULL ,
        id_classe Int NOT NULL ,
        PRIMARY KEY (id_niveau ) ,
        UNIQUE (nom )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Matiere
#------------------------------------------------------------

CREATE TABLE Matiere(
        id_matiere  int (11) Auto_increment  NOT NULL ,
        nom_matiere Varchar (25) NOT NULL ,
        PRIMARY KEY (id_matiere ) ,
        UNIQUE (nom_matiere )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Note
#------------------------------------------------------------

CREATE TABLE Note(
        id_note    int (11) Auto_increment  NOT NULL ,
        libelle    Varchar (25) ,
        note       Float ,
        id_matiere Int NOT NULL ,
        matricule  Int NOT NULL ,
        PRIMARY KEY (id_note )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Utilisateur
#------------------------------------------------------------

CREATE TABLE Utilisateur(
        id_utilisateur int (11) Auto_increment  NOT NULL ,
        mail           Varchar (25) NOT NULL ,
        nom            Varchar (25) ,
        prenom         Varchar (25) NOT NULL ,
        hash_mdp       Char (25) NOT NULL ,
        id_privilege   Int NOT NULL ,
        PRIMARY KEY (id_utilisateur ) ,
        UNIQUE (mail )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: privilege
#------------------------------------------------------------

CREATE TABLE privilege(
        id_privilege int (11) Auto_increment  NOT NULL ,
        libelle      Varchar (25) NOT NULL ,
        PRIMARY KEY (id_privilege ) ,
        UNIQUE (libelle )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: est responsable de
#------------------------------------------------------------

CREATE TABLE est_responsable_de(
        id_responsable Int NOT NULL ,
        matricule      Int NOT NULL ,
        PRIMARY KEY (id_responsable ,matricule )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: suit
#------------------------------------------------------------

CREATE TABLE suit(
        coefficient Float NOT NULL ,
        matricule   Int NOT NULL ,
        id_matiere  Int NOT NULL ,
        PRIMARY KEY (matricule ,id_matiere )
)ENGINE=InnoDB;

ALTER TABLE Eleve ADD CONSTRAINT FK_Eleve_id_coord FOREIGN KEY (id_coord) REFERENCES Coordonnees(id_coord);
ALTER TABLE Eleve ADD CONSTRAINT FK_Eleve_id_sante FOREIGN KEY (id_sante) REFERENCES Carnet_sante(id_sante);
ALTER TABLE Eleve ADD CONSTRAINT FK_Eleve_id_classe FOREIGN KEY (id_classe) REFERENCES Classe(id_classe);
ALTER TABLE Coordonnees ADD CONSTRAINT FK_Coordonnees_matricule FOREIGN KEY (matricule) REFERENCES Eleve(matricule);
ALTER TABLE Carnet_sante ADD CONSTRAINT FK_Carnet_sante_matricule FOREIGN KEY (matricule) REFERENCES Eleve(matricule);
ALTER TABLE Classe ADD CONSTRAINT FK_Classe_id_niveau FOREIGN KEY (id_niveau) REFERENCES Niveau_classe(id_niveau);
ALTER TABLE Niveau_classe ADD CONSTRAINT FK_Niveau_classe_id_classe FOREIGN KEY (id_classe) REFERENCES Classe(id_classe);
ALTER TABLE Note ADD CONSTRAINT FK_Note_id_matiere FOREIGN KEY (id_matiere) REFERENCES Matiere(id_matiere);
ALTER TABLE Note ADD CONSTRAINT FK_Note_matricule FOREIGN KEY (matricule) REFERENCES Eleve(matricule);
ALTER TABLE Utilisateur ADD CONSTRAINT FK_Utilisateur_id_privilege FOREIGN KEY (id_privilege) REFERENCES privilege(id_privilege);
ALTER TABLE est_responsable_de ADD CONSTRAINT FK_est_responsable_de_id_responsable FOREIGN KEY (id_responsable) REFERENCES Responsable(id_responsable);
ALTER TABLE est_responsable_de ADD CONSTRAINT FK_est_responsable_de_matricule FOREIGN KEY (matricule) REFERENCES Eleve(matricule);
ALTER TABLE suit ADD CONSTRAINT FK_suit_matricule FOREIGN KEY (matricule) REFERENCES Eleve(matricule);
ALTER TABLE suit ADD CONSTRAINT FK_suit_id_matiere FOREIGN KEY (id_matiere) REFERENCES Matiere(id_matiere);
