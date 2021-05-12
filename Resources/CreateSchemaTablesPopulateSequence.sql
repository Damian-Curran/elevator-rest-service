CREATE DATABASE `genesys` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `building` (
  `BuildingId` int NOT NULL AUTO_INCREMENT,
  `id` bigint NOT NULL,
  `name` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`BuildingId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `elevator` (
  `ElevatorId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `id` int NOT NULL,
  `current_floor` int NOT NULL,
  `max_floor` int NOT NULL,
  `min_floor` int NOT NULL,
  `state` int NOT NULL,
  `building_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ElevatorId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `id` bigint NOT NULL,
  `Name` varchar(45) NOT NULL,
  `current_floor` int NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `building_elevators` (
  `building_id` bigint NOT NULL,
  `elevators_id` bigint NOT NULL,
  UNIQUE KEY `UK_8nhw0sbkbk1y8r03tpn1h92eg` (`elevators_id`),
  KEY `FKj70sqav1rmrap92njpar2ran3` (`building_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `building_user` (
  `building_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  KEY `FKhfi15unbpsjb9et1q2sko422b` (`user_id`),
  KEY `FKk2h3ucgee78p8twg94f1fv8mf` (`building_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_buildings` (
  `user_id` bigint(20) NOT NULL,
  `buildings_id` bigint(20) NOT NULL,
  KEY `FKdo1rkwybsm4cw3ob7udgsoi0q` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into genesys.hibernate_sequence
values(0);