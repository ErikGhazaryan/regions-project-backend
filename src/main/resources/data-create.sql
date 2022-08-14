drop table if exists population_density;
drop table if exists population_density_migration_table;
drop table if exists nuts_level_region_migration_table;
drop table if exists  nuts_level_3_region;
drop table if exists  nuts_level_2_region;
drop table if exists  nuts_level_1_region;
drop table if exists nuts_level_0_region;
drop table if exists year_period;

CREATE TABLE nuts_level_region_migration_table (
    migration_table_id INT NOT NULL AUTO_INCREMENT,
    territory_code VARCHAR(50) UNIQUE NOT NULL,
    nuts_level INT NOT NULL,
    country_order INT NOT NULL,
    region_order INT NOT NULL,
    PRIMARY KEY (migration_table_id)
);

CREATE TABLE population_density_migration_table (
    population_density_migration_table_id INT NOT NULL AUTO_INCREMENT,
    territory_code VARCHAR(50) UNIQUE NOT NULL,
    nuts_level_name VARCHAR(300) NOT NULL,
    year_2015 VARCHAR(50),
    year_2016 VARCHAR(50),
    year_2017 VARCHAR(50),
    year_2018 VARCHAR(50),
    year_2019 VARCHAR(50),
    PRIMARY KEY (population_density_migration_table_id)
);

create table year_period(
year_period_id INT NOT NULL AUTO_INCREMENT,
calendar_year int NOT NULL,
PRIMARY KEY (year_period_id));

create table nuts_level_0_region(
nuts_level_0_region_id int not null AUTO_INCREMENT,
territory_code varchar(50)  not null,
nuts_name varchar(50),
PRIMARY KEY(nuts_level_0_region_id)
);

create table nuts_level_1_region(
nuts_level_1_region_id int not null AUTO_INCREMENT,
nuts_level_0_region_id int,
territory_code varchar(50)  not null,
nuts_name varchar(50),
PRIMARY KEY(nuts_level_1_region_id),
FOREIGN KEY(nuts_level_0_region_id) REFERENCES nuts_level_0_region(nuts_level_0_region_id) ON DELETE CASCADE
);

create table nuts_level_2_region(
nuts_level_2_region_id int not null AUTO_INCREMENT,
nuts_level_1_region_id int,
territory_code varchar(50)  not null,
nuts_name varchar(50),
FOREIGN KEY(nuts_level_1_region_id) REFERENCES nuts_level_1_region(nuts_level_1_region_id) ON DELETE CASCADE,
PRIMARY KEY(nuts_level_2_region_id)
);

create table nuts_level_3_region(
nuts_level_3_region_id int not null AUTO_INCREMENT,
nuts_level_2_region_id int,
territory_code varchar(50) unique not null,
nuts_name varchar(50),
FOREIGN KEY(nuts_level_2_region_id) REFERENCES nuts_level_2_region(nuts_level_2_region_id) ON DELETE CASCADE,
PRIMARY KEY(nuts_level_3_region_id)
);

CREATE TABLE population_density(
population_density_id int not null AUTO_INCREMENT,
population_density_psk VARCHAR(50),
nuts_level_3_region_id int,
year_period_id int,
PRIMARY KEY(population_density_id),
FOREIGN KEY(nuts_level_3_region_id) REFERENCES nuts_level_3_region(nuts_level_3_region_id) ON DELETE CASCADE,
FOREIGN KEY(year_period_id) REFERENCES year_period(year_period_id) ON DELETE CASCADE
);
