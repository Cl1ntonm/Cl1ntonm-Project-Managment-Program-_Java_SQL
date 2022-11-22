-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: poisepms
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persons` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project_number` int DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1,1,'Luke','SkyWalker','727265101','Luke@email.com','15 Tatooine',1),(2,1,'Leia','SkyWalker','827238752','leia@email.com','1 Alderaan rd',2),(3,1,'Han','Solo','738928751','han@email.com','76 Correllia',3),(4,1,'C','3po','972371680','3cpo@email.com','16 Tatooine',4),(5,1,'R2','D2','751278365','r2d2@email.com','67 Naboo',5),(6,2,'Harry','Potter','837877083','harry@email.com','89 Understair Land',1),(7,2,'Hermione','Granger','873476873','Hermione@email.com','8 Heathgate Hampstead',2),(8,2,'Ron','Weasley','738928751','ron@email.com','12 Burrow Place',3),(9,2,'Rubeus','Hagrid','762635478','rubeus@email.com','34 West Country',4),(10,2,'Severus','Snape','275619779','severus@email.com','1960 Spinners End',5),(11,3,'Alvin','Seville','871872650','alvin@email.com','1544 North SaintAndrews smallroom',1),(12,3,'Theodore','Seville','729787297','theodore@email.com','1544 North Saint Andrews small room',2),(13,3,'Simon','Seville','738977521','simon@email.com','1544 North Saint Andrews large room',3),(14,3,'Brittany','Miller','874612870','brittany@email.com','78 tree house lane',4),(15,3,'Jeanette','Miller','286091823','jeanette@email.com','78 tree house lane',5),(16,4,'Cameron','Diaz','286091823','cameron@email.com','43 California close',1),(17,4,'Drew','Barrymore','722347299','drew@email.com','78 Malibu crescent',2),(18,4,'Lucy','Liu','738998121','lucy@email.com','90 San Fransisco place',3),(19,4,'John','Bosley','812761095','bosley@email.com','7121 Lonzo Street',4),(20,4,'Charles','Townsend','861872397','charlie@email.com','7121 Lonzo Street',5),(21,5,'Buffy','Summers','871287562','buffy@email.com','1630 Revello Drive',1),(22,5,'Xander','Harris','162954879','xander@eail.com','231 Sunnydale Court',2),(23,5,'Willow','Rosenberg','348712543','willow@email.com','56 Tree Lane',3),(24,5,'Cordelia','chase','871263810','cordelia@email.com','23 california close',4),(25,5,'Dawn','Summers','912837459','dawn@email.com','1630 Revello Drive',5),(26,6,'Jack','Tripper','672165031','jack@email.com','L2 Hacienda Palms',1),(27,6,'Janet','Wood','459287103','janet@email.com','R2 4th Str Santa Monica',2),(28,6,'Chrissy','Snow','281673048','chrissy@email.com','R2 4th Str Santa Monica',3),(29,6,'Stanley','Rooper','827301938','stanley@email.com',' 5154 Fountain Avenue',4),(30,6,'Helen','Rooper','819287399','helen@email.com','  5154 Fountain Avenue',5);
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-27 23:16:43
