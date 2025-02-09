CREATE DATABASE  IF NOT EXISTS `military_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `military_db`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 34.205.43.78    Database: military_db
-- ------------------------------------------------------
-- Server version	8.0.41-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Departments`
--

DROP TABLE IF EXISTS `Departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Departments` (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(100) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `department_name` (`department_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Departments`
--

LOCK TABLES `Departments` WRITE;
/*!40000 ALTER TABLE `Departments` DISABLE KEYS */;
INSERT INTO `Departments` VALUES (1,'Logistics','Handles supply chain and transportation.'),(2,'Intelligence','Responsible for gathering and analyzing intelligence.'),(3,'Operations','Manages military operations and strategic planning.'),(4,'Medical','Provides medical care and support.'),(5,'Training','Responsible for soldier training and development.'),(6,'Engineering','Involved in building and maintaining military infrastructure.'),(7,'Communications','Handles military communication systems.'),(8,'Research and Development','Works on new military technologies.'),(9,'Legal','Provides legal advice and services.'),(10,'Finance','Manages military budgets and financial resources.');
/*!40000 ALTER TABLE `Departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mission_Assignments`
--

DROP TABLE IF EXISTS `Mission_Assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Mission_Assignments` (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `mission_id` int DEFAULT NULL,
  `soldier_id` int DEFAULT NULL,
  PRIMARY KEY (`assignment_id`),
  KEY `mission_id` (`mission_id`),
  CONSTRAINT `Mission_Assignments_ibfk_1` FOREIGN KEY (`mission_id`) REFERENCES `Missions` (`mission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mission_Assignments`
--

LOCK TABLES `Mission_Assignments` WRITE;
/*!40000 ALTER TABLE `Mission_Assignments` DISABLE KEYS */;
/*!40000 ALTER TABLE `Mission_Assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Missions`
--

DROP TABLE IF EXISTS `Missions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Missions` (
  `mission_id` int NOT NULL AUTO_INCREMENT,
  `mission_name` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `objective` text,
  PRIMARY KEY (`mission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Missions`
--

LOCK TABLES `Missions` WRITE;
/*!40000 ALTER TABLE `Missions` DISABLE KEYS */;
INSERT INTO `Missions` VALUES (1,'Operation Desert Storm','1991-01-17','1991-02-28','Kuwait','Liberate Kuwait from Iraqi forces.'),(2,'Operation Iraqi Freedom','2003-03-20','2011-12-18','Iraq','Topple Saddam Hussein and stabilize Iraq.'),(3,'Operation Enduring Freedom','2001-10-07','2014-12-28','Afghanistan','Defeat Taliban and Al-Qaeda forces.'),(4,'Operation Overlord','1944-06-06','1944-08-30','Normandy','Launch invasion of Western Europe.'),(5,'Operation Neptune Spear','2011-05-02','2011-05-02','Pakistan','Eliminate Osama Bin Laden.'),(6,'Operation Sea Breeze','2020-07-06','2020-07-12','Black Sea','Joint military exercise between NATO and Ukraine.'),(7,'Operation Thunderbolt','1976-07-04','1976-07-04','Uganda','Rescue hostages from hijacked plane.'),(8,'Operation Chammal','2014-09-19','2014-09-19','Iraq and Syria','Fight against ISIS in Iraq and Syria.'),(9,'Operation Unfurling Freedom','2004-08-12','2004-10-30','Kosovo','Support stability in Kosovo.'),(10,'Operation Golden Dawn','2019-05-10','2019-06-01','Mediterranean','Fight piracy in the Mediterranean Sea.');
/*!40000 ALTER TABLE `Missions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ranks`
--

DROP TABLE IF EXISTS `Ranks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ranks` (
  `rank_id` int NOT NULL AUTO_INCREMENT,
  `rank_name` varchar(50) DEFAULT NULL,
  `rank_level` int DEFAULT NULL,
  PRIMARY KEY (`rank_id`),
  UNIQUE KEY `rank_name` (`rank_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ranks`
--

LOCK TABLES `Ranks` WRITE;
/*!40000 ALTER TABLE `Ranks` DISABLE KEYS */;
INSERT INTO `Ranks` VALUES (1,'Private',1),(2,'Corporal',2),(3,'Sergeant',3),(4,'Lieutenant',4),(5,'Captain',5),(6,'Major',6),(7,'Colonel',7),(8,'General',8),(9,'Brigadier',9),(10,'Admiral',10);
/*!40000 ALTER TABLE `Ranks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Soldiers`
--

DROP TABLE IF EXISTS `Soldiers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Soldiers` (
  `soldier_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `rank_id` int DEFAULT NULL,
  `unit_id` int DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  `enlistment_date` date DEFAULT NULL,
  PRIMARY KEY (`soldier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Soldiers`
--

LOCK TABLES `Soldiers` WRITE;
/*!40000 ALTER TABLE `Soldiers` DISABLE KEYS */;
INSERT INTO `Soldiers` VALUES (1,'Gabriel','Becker','1990-05-15',1,1,1,'2010-07-01'),(2,'Utku','Duman','1985-03-22',2,2,2,'2012-06-14'),(3,'Michael','Johnson','1988-07-30',3,3,3,'2013-09-01'),(4,'Sophia','Williams','1992-12-10',1,4,4,'2015-05-23'),(5,'James','Brown','1994-02-05',2,5,5,'2016-10-15'),(6,'Olivia','Jones','1991-08-18',1,6,6,'2014-12-04'),(7,'Liam','Miller','1993-11-25',3,7,7,'2017-01-10'),(8,'Ethan','Davis','1987-09-11',2,8,8,'2011-03-19'),(9,'Mia','Garcia','1995-01-22',1,9,9,'2018-02-28'),(10,'Lucas','Martinez','1996-04-09',3,10,10,'2019-07-11'),(11,'Gabriel','Becker','1990-05-15',1,1,1,'2010-07-01'),(12,'Utku','Duman','1985-03-22',2,2,2,'2012-06-14'),(13,'Michael','Johnson','1988-07-30',3,3,3,'2013-09-01'),(14,'Sophia','Williams','1992-12-10',1,4,4,'2015-05-23'),(15,'James','Brown','1994-02-05',2,5,5,'2016-10-15'),(16,'Olivia','Jones','1991-08-18',1,6,6,'2014-12-04'),(17,'Liam','Miller','1993-11-25',3,7,7,'2017-01-10'),(18,'Ethan','Davis','1987-09-11',2,8,8,'2011-03-19'),(19,'Mia','Garcia','1995-01-22',1,9,9,'2018-02-28'),(20,'Lucas','Martinez','1996-04-09',3,10,10,'2019-07-11'),(21,'John','Doe',NULL,NULL,NULL,NULL,'2025-02-03'),(22,'Gabriel','Becker','1990-05-15',1,1,1,'2010-07-01'),(23,'Utku','Duman','1985-03-22',2,2,2,'2012-06-14'),(24,'Michael','Johnson','1988-07-30',3,3,3,'2013-09-01'),(25,'Sophia','Williams','1992-12-10',1,4,4,'2015-05-23'),(26,'James','Brown','1994-02-05',2,5,5,'2016-10-15'),(27,'Olivia','Jones','1991-08-18',1,6,6,'2014-12-04'),(28,'Liam','Miller','1993-11-25',3,7,7,'2017-01-10'),(29,'Ethan','Davis','1987-09-11',2,8,8,'2011-03-19'),(30,'Mia','Garcia','1995-01-22',1,9,9,'2018-02-28'),(31,'Lucas','Martinez','1996-04-09',3,10,10,'2019-07-11');
/*!40000 ALTER TABLE `Soldiers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Training_Attendance`
--

DROP TABLE IF EXISTS `Training_Attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Training_Attendance` (
  `attendance_id` int NOT NULL AUTO_INCREMENT,
  `course_id` int DEFAULT NULL,
  `soldier_id` int DEFAULT NULL,
  `completion_date` date DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `course_id` (`course_id`),
  KEY `soldier_id` (`soldier_id`),
  CONSTRAINT `Training_Attendance_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `Training_Courses` (`course_id`),
  CONSTRAINT `Training_Attendance_ibfk_2` FOREIGN KEY (`soldier_id`) REFERENCES `Soldiers` (`soldier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Training_Attendance`
--

LOCK TABLES `Training_Attendance` WRITE;
/*!40000 ALTER TABLE `Training_Attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `Training_Attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Training_Courses`
--

DROP TABLE IF EXISTS `Training_Courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Training_Courses` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Training_Courses`
--

LOCK TABLES `Training_Courses` WRITE;
/*!40000 ALTER TABLE `Training_Courses` DISABLE KEYS */;
/*!40000 ALTER TABLE `Training_Courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Units`
--

DROP TABLE IF EXISTS `Units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Units` (
  `unit_id` int NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(100) DEFAULT NULL,
  `unit_type` varchar(50) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Units`
--

LOCK TABLES `Units` WRITE;
/*!40000 ALTER TABLE `Units` DISABLE KEYS */;
INSERT INTO `Units` VALUES (1,'1st Infantry','Infantry','New York'),(2,'2nd Infantry','Infantry','California'),(3,'3rd Armored','Armored','Texas'),(4,'4th Airborne','Airborne','Nevada'),(5,'5th Recon','Recon','Florida'),(6,'6th Cavalry','Cavalry','Arizona'),(7,'7th Marines','Marines','Oregon'),(8,'8th Engineers','Engineers','Washington'),(9,'9th Medical','Medical','Utah'),(10,'10th Military Police','Military Police','Idaho');
/*!40000 ALTER TABLE `Units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vehicle_Assignments`
--

DROP TABLE IF EXISTS `Vehicle_Assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Vehicle_Assignments` (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `vehicle_id` int DEFAULT NULL,
  `mission_id` int DEFAULT NULL,
  `assignment_date` date DEFAULT NULL,
  PRIMARY KEY (`assignment_id`),
  KEY `vehicle_id` (`vehicle_id`),
  KEY `mission_id` (`mission_id`),
  CONSTRAINT `Vehicle_Assignments_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `Vehicles` (`vehicle_id`),
  CONSTRAINT `Vehicle_Assignments_ibfk_2` FOREIGN KEY (`mission_id`) REFERENCES `Missions` (`mission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vehicle_Assignments`
--

LOCK TABLES `Vehicle_Assignments` WRITE;
/*!40000 ALTER TABLE `Vehicle_Assignments` DISABLE KEYS */;
/*!40000 ALTER TABLE `Vehicle_Assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vehicles`
--

DROP TABLE IF EXISTS `Vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Vehicles` (
  `vehicle_id` int NOT NULL AUTO_INCREMENT,
  `vehicle_name` varchar(50) DEFAULT NULL,
  `vehicle_type` varchar(50) DEFAULT NULL,
  `license_plate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`),
  UNIQUE KEY `license_plate` (`license_plate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vehicles`
--

LOCK TABLES `Vehicles` WRITE;
/*!40000 ALTER TABLE `Vehicles` DISABLE KEYS */;
/*!40000 ALTER TABLE `Vehicles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Weapon_Assignments`
--

DROP TABLE IF EXISTS `Weapon_Assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Weapon_Assignments` (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `weapon_id` int DEFAULT NULL,
  `soldier_int` int DEFAULT NULL,
  `assignment_date` date DEFAULT NULL,
  PRIMARY KEY (`assignment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Weapon_Assignments`
--

LOCK TABLES `Weapon_Assignments` WRITE;
/*!40000 ALTER TABLE `Weapon_Assignments` DISABLE KEYS */;
/*!40000 ALTER TABLE `Weapon_Assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Weapons`
--

DROP TABLE IF EXISTS `Weapons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Weapons` (
  `weapon_id` int NOT NULL AUTO_INCREMENT,
  `weapon_name` varchar(50) DEFAULT NULL,
  `weapon_type` varchar(50) DEFAULT NULL,
  `serial_number` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`weapon_id`),
  UNIQUE KEY `serial_number` (`serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Weapons`
--

LOCK TABLES `Weapons` WRITE;
/*!40000 ALTER TABLE `Weapons` DISABLE KEYS */;
/*!40000 ALTER TABLE `Weapons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-09 22:38:06
