PRAGMA foreign_keys = OFF;
drop table if exists LGA;
drop table if exists PopulationStatistics;
/*drop table if exists socioeconomicoutcome;*/
drop table if exists WeeklyIncome; 
drop table if exists LTHC; 
drop table if exists Persona; 
drop table if exists PersonaAttribute; 
drop table if exists SchoolCompletion; 

PRAGMA foreign_keys = ON;

CREATE TABLE LGA (
    lga_code16        INTEGER NOT NULL,
    year              INTEGER NOT NULL,
    lga_name16        TEXT NOT NULL,
    lga_type16        CHAR (2),
    stateAbbr         TEXT NOT NULL,
    area_sqkm         DOUBLE,
    latitude          DOUBLE,
    longitude         DOUBLE,
    PRIMARY KEY (lga_code16, year)
);

CREATE TABLE PopulationStatistics (
    lga_code16        INTEGER NOT NULL,
    year              INTEGER NOT NULL,
    indigenous_status TEXT NOT NULL,
    sex               CHAR (1) NOT NULL,
    age               TEXT NOT NULL,
    count             INTEGER NOT NULL,
    age_min           INTEGER NOT NULL,
    age_max           INTEGER NOT NULL,
    PRIMARY KEY (lga_code16, year, indigenous_status, sex, age)
    FOREIGN KEY (lga_code16) REFERENCES LGA(lga_code16)
    FOREIGN KEY (year) REFERENCES LGA(year)
);

CREATE TABLE SchoolCompletion (
    code INTEGER NOT NULL,
    year INTEGER NOT NULL,
    indigenous_status TEXT NOT NULL,
    sex CHAR(1) NOT NULL,
    schoolyear INTEGER NOT NULL,
    count INTEGER NOT NULL, 
    PRIMARY KEY (code, year, indigenous_status, schoolyear, sex)
    FOREIGN KEY (code) REFERENCES LGA(lga_code16)
    FOREIGN KEY (year) REFERENCES LGA(year)
);

CREATE TABLE WeeklyIncome (
    code INTEGER NOT NULL,
    year INTEGER NOT NULL,
    indigenous_status TEXT NOT NULL,
    sex CHAR(1) NOT NULL,
    incomebracket TEXT NOT NULL,
    count INTEGER NOT NULL,
    incomebracketmin INTEGER NOT NULL,
    incomebracketmax INTEGER NOT NULL,
    PRIMARY KEY (code, year, indigenous_status, sex, incomebracket) 
    FOREIGN KEY (code) REFERENCES LGA(lga_code16)
    FOREIGN KEY (year) REFERENCES LGA(year)
);

CREATE TABLE LTHC (
    code INTEGER NOT NULL,
    year INTEGER NOT NULL,
    indigenous_status TEXT NOT NULL,
    sex CHAR(1) NOT NULL,
    condition TEXT NOT NULL,
    count INTEGER NOT NULL,
    PRIMARY KEY (code, year, indigenous_status, sex)
    FOREIGN KEY (code) REFERENCES LGA(lga_code16)
    FOREIGN KEY (year) REFERENCES LGA(year)
);
    


CREATE TABLE Persona ( 
    Name TEXT NOT NULL, 
    ImageFilePath TEXT NOT NULL, 
    PRIMARY KEY (Name) 

); 

CREATE TABLE PersonaAttribute ( 

perattID INTEGER NOT NULL, 

AttributeType TEXT NOT NULL, 

Descrip TEXT NOT NULL, 

Name TEXT NOT NULL, 

PRIMARY KEY (perattID) 

FOREIGN KEY (Name) REFERENCES Persona(Name) 
);

/*CREATE TABLE SocioeconomicOutcome (
    ID              INTEGER NOT NULL,
    Title           TEXT NOT NULL,
    Descrip         TEXT NOT NULL,
    PRIMARY KEY (ID)
);*/
