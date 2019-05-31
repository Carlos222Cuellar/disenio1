-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: DBpos
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Table structure for table `Categorias`
--

DROP TABLE IF EXISTS `Categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categorias` (
  `IdCategoria` int(10) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categorias`
--

LOCK TABLES `Categorias` WRITE;
/*!40000 ALTER TABLE `Categorias` DISABLE KEYS */;
INSERT INTO `Categorias` VALUES (1,'Platos'),(2,'Bebidas'),(3,'Postres');
/*!40000 ALTER TABLE `Categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DetalleOrden`
--

DROP TABLE IF EXISTS `DetalleOrden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DetalleOrden` (
  `IdOrden` int(10) NOT NULL,
  `IdProductos` int(10) NOT NULL,
  `cantidad` int(10) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`IdOrden`,`IdProductos`),
  KEY `fk_DetalleOrden_Ordenes1_idx` (`IdProductos`),
  CONSTRAINT `fk_DetalleOrden_Ordenes1` FOREIGN KEY (`IdProductos`) REFERENCES `Productos` (`IdProductos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleOrden_Ordenes2` FOREIGN KEY (`IdOrden`) REFERENCES `Ordenes` (`IdOrden`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetalleOrden`
--

LOCK TABLES `DetalleOrden` WRITE;
/*!40000 ALTER TABLE `DetalleOrden` DISABLE KEYS */;
/*!40000 ALTER TABLE `DetalleOrden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ordenes`
--

DROP TABLE IF EXISTS `Ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ordenes` (
  `IdOrden` int(10) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `mesero` varchar(50) DEFAULT NULL,
  `mesa` varchar(50) DEFAULT NULL,
  `cliente` varchar(50) DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `observacion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IdOrden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ordenes`
--

LOCK TABLES `Ordenes` WRITE;
/*!40000 ALTER TABLE `Ordenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Productos`
--

DROP TABLE IF EXISTS `Productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Productos` (
  `IdProductos` int(10) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `esPreparado` tinyint(4) DEFAULT NULL,
  `IdCategoria` int(10) NOT NULL,
  PRIMARY KEY (`IdProductos`,`IdCategoria`),
  KEY `fk_productos_categorias_idx` (`IdCategoria`),
  CONSTRAINT `fk_productos_categorias` FOREIGN KEY (`IdCategoria`) REFERENCES `Categorias` (`IdCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Productos`
--

LOCK TABLES `Productos` WRITE;
/*!40000 ALTER TABLE `Productos` DISABLE KEYS */;
INSERT INTO `Productos` VALUES (1,'Pollo',1.25,1,1),(2,'Sopa',2.25,1,1),(3,'Gaseosa',0.75,0,2),(4,'Flan',1.5,1,3);
/*!40000 ALTER TABLE `Productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametros` (
  `IdParametros` int(10) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `valor` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IdParametros`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-31 11:55:28
