-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: gestion
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activdad`
--

DROP TABLE IF EXISTS `activdad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activdad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `avance` enum('0','25','50','75','100') NOT NULL DEFAULT '0',
  `id_proyecto` int(11) DEFAULT NULL,
  `Observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_proyecto_idx` (`id_proyecto`),
  CONSTRAINT `fk_actividad_proyecto` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activdad`
--

LOCK TABLES `activdad` WRITE;
/*!40000 ALTER TABLE `activdad` DISABLE KEYS */;
/*!40000 ALTER TABLE `activdad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (3,'cierre'),(2,'elaboración'),(1,'inicio');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Carlos','Balladares1','calos.balladares@arcotel.gob.ec','0998025475'),(5,'José','Días','jose.dias@arcotel.gob.ec','23451444'),(9,'GBY13','MREON','SDG','FD'),(10,'ret','wert','ert','ert'),(11,'Jake','ertw','twtwrw','ewerew'),(13,'Jake','ertw','twtwrw123','ewerew'),(14,'kjkjk','jkjk','mb,bb','klhlhkhh'),(15,'bbm,b','m,bm,b','lkk','hlkh');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaxactividad`
--

DROP TABLE IF EXISTS `personaxactividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personaxactividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_personaxproyecto` int(11) DEFAULT NULL,
  `id_actividad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_personaxproyecto_idx` (`id_personaxproyecto`),
  KEY `fk_personaxactividad_actividad_idx` (`id_actividad`),
  CONSTRAINT `fk_personaxactividad_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `activdad` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personaxactividad_personaxproyecto` FOREIGN KEY (`id_personaxproyecto`) REFERENCES `personaxproyecto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaxactividad`
--

LOCK TABLES `personaxactividad` WRITE;
/*!40000 ALTER TABLE `personaxactividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `personaxactividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaxproyecto`
--

DROP TABLE IF EXISTS `personaxproyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personaxproyecto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `id_proyecto` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_persona_idx` (`id_persona`),
  KEY `fk_proyecto_idx` (`id_proyecto`),
  KEY `fk_personaxproyecto_rol_idx` (`id_rol`),
  CONSTRAINT `fk_personaxproyecto_persona` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personaxproyecto_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personsaxproyecto_proyecto` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaxproyecto`
--

LOCK TABLES `personaxproyecto` WRITE;
/*!40000 ALTER TABLE `personaxproyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `personaxproyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `id_estado` int(11) DEFAULT NULL,
  `avance` int(11) NOT NULL DEFAULT '0',
  `descripcion` varchar(100) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_estado_idx` (`id_estado`),
  CONSTRAINT `fk_proyecto_estado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reunion`
--

DROP TABLE IF EXISTS `reunion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reunion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `id_tiporeunion` int(11) DEFAULT NULL,
  `id_proyecto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reunion_tiporeunion_idx` (`id_tiporeunion`),
  KEY `fk_reunion_proyecto_idx` (`id_proyecto`),
  CONSTRAINT `fk_reunion_proyecto` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reunion_tiporeunion` FOREIGN KEY (`id_tiporeunion`) REFERENCES `tiporeunion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reunion`
--

LOCK TABLES `reunion` WRITE;
/*!40000 ALTER TABLE `reunion` DISABLE KEYS */;
/*!40000 ALTER TABLE `reunion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reunionactividad`
--

DROP TABLE IF EXISTS `reunionactividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reunionactividad` (
  `id_reunion` int(11) NOT NULL,
  `quehizoayer` varchar(200) DEFAULT NULL,
  `queharahoy` varchar(200) DEFAULT NULL,
  `queimpideelavance` varchar(200) DEFAULT NULL,
  `id_actividad` int(11) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_reunion`),
  KEY `fk_reunionactividad_actividad_idx` (`id_actividad`),
  CONSTRAINT `fk_reunionactividad_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `activdad` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reunionactividad_reunion` FOREIGN KEY (`id_reunion`) REFERENCES `reunion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reunionactividad`
--

LOCK TABLES `reunionactividad` WRITE;
/*!40000 ALTER TABLE `reunionactividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `reunionactividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Scrum Master'),(3,'Dueño de producto'),(10,'Miembro del equipo1'),(11,'nueva'),(13,'nueva d2');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiporeunion`
--

DROP TABLE IF EXISTS `tiporeunion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiporeunion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiporeunion`
--

LOCK TABLES `tiporeunion` WRITE;
/*!40000 ALTER TABLE `tiporeunion` DISABLE KEYS */;
INSERT INTO `tiporeunion` VALUES (1,'Diaria'),(2,'Inicio de Proyecto'),(3,'Definición de caso de uso');
/*!40000 ALTER TABLE `tiporeunion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `tipo` enum('A','O') DEFAULT 'O',
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `id_persona_idx` (`id_persona`),
  CONSTRAINT `id_persona` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('carlos.balladares','bocadAbril2011',1,NULL,1),('wer','123',10,NULL,0),('ttt','123',11,NULL,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gestion'
--

--
-- Dumping routines for database 'gestion'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-14 23:45:46
