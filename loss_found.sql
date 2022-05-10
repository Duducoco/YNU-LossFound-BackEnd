-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: loss_found
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `found`
--

DROP TABLE IF EXISTS `found`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `found` (
  `foundID` int NOT NULL AUTO_INCREMENT,
  `foundName` varchar(256) NOT NULL,
  `foundLocation` varchar(256) DEFAULT NULL,
  `foundTime` varchar(13) DEFAULT NULL,
  `releaseTime` varchar(13) NOT NULL,
  `imageUrl` varchar(256) DEFAULT NULL,
  `studentIDFeature` varchar(20) DEFAULT NULL,
  `phoneFeature` varchar(20) DEFAULT NULL,
  `emailFeature` varchar(100) DEFAULT NULL,
  `otherFeature` varchar(128) DEFAULT NULL,
  `foundNowLocation` varchar(128) DEFAULT NULL,
  `authorTeleMethod` varchar(128) DEFAULT NULL,
  `author` varchar(128) DEFAULT NULL,
  `isReturn` tinyint(1) NOT NULL,
  PRIMARY KEY (`foundID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `loss`
--

DROP TABLE IF EXISTS `loss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loss` (
  `lossID` int NOT NULL AUTO_INCREMENT,
  `lossName` varchar(256) NOT NULL,
  `lossLocation` varchar(256) DEFAULT NULL,
  `lossTime` varchar(13) DEFAULT NULL,
  `releaseTime` varchar(13) NOT NULL,
  `imageUrl` varchar(256) DEFAULT NULL,
  `studentIDFeature` varchar(20) DEFAULT NULL,
  `phoneFeature` varchar(20) DEFAULT NULL,
  `emailFeature` varchar(100) DEFAULT NULL,
  `otherFeature` varchar(128) DEFAULT NULL,
  `author` varchar(128) DEFAULT NULL,
  `authorTeleMethod` varchar(128) DEFAULT NULL,
  `isFound` tinyint(1) NOT NULL,
  PRIMARY KEY (`lossID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `studentID` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `avatarurl` varchar(128) NOT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-28 17:56:07
