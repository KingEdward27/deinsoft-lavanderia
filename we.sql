-- MySQL dump 10.13  Distrib 5.5.25, for Win32 (x86)
--
-- Host: localhost    Database: dbbodega
-- ------------------------------------------------------
-- Server version	5.5.25

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `IdCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(70) DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'embutidos','1'),(2,'refrescos','1'),(3,'saborizantes','1'),(4,'yogurt','1'),(5,'granel','1'),(6,'panes','1'),(7,'cigarros','1'),(8,'lacteos','1'),(9,'descartables','1'),(10,'bolsas','1'),(11,'reposteria','1'),(12,'limpieza','1'),(13,'conservas','1'),(14,'GALLETAS','1'),(15,'CEREAL','1');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `IdCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(150) NOT NULL,
  `Dni` varchar(8) NOT NULL,
  `Direccion` varchar(80) DEFAULT NULL,
  `Telefono` varchar(11) DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'PUBLICO EN GENERAL','11111111','-','-','1');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `IdCompra` int(11) NOT NULL AUTO_INCREMENT,
  `IdProveedor` int(11) NOT NULL,
  `TipoDoc` varchar(20) NOT NULL,
  `NumDoc` varchar(6) NOT NULL,
  `Fecha` date NOT NULL,
  `Igv` decimal(7,2) NOT NULL,
  `SubTotal` decimal(7,2) NOT NULL,
  `Total` decimal(7,2) NOT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdCompra`),
  KEY `fk_idproveedor` (`IdProveedor`),
  CONSTRAINT `fk_idproveedor` FOREIGN KEY (`IdProveedor`) REFERENCES `proveedores` (`IdProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecompras`
--

DROP TABLE IF EXISTS `detallecompras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecompras` (
  `IdCompra` int(11) NOT NULL,
  `IdProducto` int(11) NOT NULL,
  `Cantidad` decimal(7,2) NOT NULL,
  `Precio` decimal(7,2) NOT NULL,
  `Importe` decimal(7,2) NOT NULL,
  PRIMARY KEY (`IdCompra`,`IdProducto`),
  KEY `fk_idcompra` (`IdCompra`),
  KEY `fk_idproducto_compra` (`IdProducto`),
  CONSTRAINT `fk_idcompra` FOREIGN KEY (`IdCompra`) REFERENCES `compras` (`IdCompra`),
  CONSTRAINT `fk_idproducto_compra` FOREIGN KEY (`IdProducto`) REFERENCES `productos` (`IdProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecompras`
--

LOCK TABLES `detallecompras` WRITE;
/*!40000 ALTER TABLE `detallecompras` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallecompras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventas`
--

DROP TABLE IF EXISTS `detalleventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleventas` (
  `IdVenta` int(11) NOT NULL,
  `IdProducto` int(11) NOT NULL,
  `Cantidad` decimal(7,2) NOT NULL,
  `Precio` decimal(7,2) NOT NULL,
  `Descuento` decimal(7,2) NOT NULL,
  `Importe` decimal(7,2) NOT NULL,
  PRIMARY KEY (`IdVenta`,`IdProducto`),
  KEY `fk_idventa` (`IdVenta`),
  KEY `fk_idproducto_venta` (`IdProducto`),
  CONSTRAINT `fk_idproducto_venta` FOREIGN KEY (`IdProducto`) REFERENCES `productos` (`IdProducto`),
  CONSTRAINT `fk_idventa` FOREIGN KEY (`IdVenta`) REFERENCES `ventas` (`IdVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventas`
--

LOCK TABLES `detalleventas` WRITE;
/*!40000 ALTER TABLE `detalleventas` DISABLE KEYS */;
INSERT INTO `detalleventas` VALUES (1,94,2.00,4.50,0.00,9.00),(1,199,5.00,2.20,0.00,11.00),(2,199,5.00,2.20,0.00,11.00),(3,199,5.00,2.20,0.00,11.00),(4,94,5.00,4.50,0.00,22.50),(5,97,1.00,4.50,0.00,4.50),(5,121,1.00,6.00,0.00,6.00),(5,292,1.00,2.50,0.00,2.50),(6,91,2.00,4.50,0.00,9.00),(6,98,2.00,4.50,0.00,9.00),(6,199,5.00,2.20,0.00,11.00),(7,82,2.00,1.79,0.00,3.58),(7,117,1.00,7.00,0.00,7.00),(7,145,2.00,1.50,0.00,3.00),(7,267,2.00,6.00,0.00,12.00),(8,85,2.00,5.50,0.00,11.00),(8,181,2.00,2.50,0.00,5.00),(8,264,1.00,2.80,0.00,2.80),(9,85,1.00,5.50,0.00,5.50),(9,110,3.00,1.00,0.00,3.00),(9,125,1.00,5.60,0.00,5.60),(9,126,1.00,5.60,0.00,5.60),(9,130,1.00,3.80,0.00,3.80),(9,131,1.00,7.60,0.00,7.60),(9,132,1.00,7.60,0.00,7.60),(9,133,1.00,3.80,0.00,3.80),(9,195,1.00,1.00,0.00,1.00),(9,282,1.00,0.80,0.00,0.80),(10,91,2.00,4.50,0.00,9.00),(10,246,6.00,4.80,0.00,28.80),(11,92,2.00,4.33,0.00,8.66),(11,142,1.00,3.10,0.00,3.10),(12,89,1.00,4.50,0.00,4.50),(12,245,12.00,2.63,0.00,31.56);
/*!40000 ALTER TABLE `detalleventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egresos`
--

DROP TABLE IF EXISTS `egresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `egresos` (
  `IdEgreso` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Monto` decimal(7,2) NOT NULL,
  `Motivo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`IdEgreso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egresos`
--

LOCK TABLES `egresos` WRITE;
/*!40000 ALTER TABLE `egresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `egresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresos` (
  `IdIngreso` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Monto` decimal(7,2) NOT NULL,
  `Motivo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`IdIngreso`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresos`
--

LOCK TABLES `ingresos` WRITE;
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
INSERT INTO `ingresos` VALUES (1,'2014-01-21',10.00,'APERTURA'),(2,'2014-01-28',100.00,'APERTURA'),(3,'2014-02-04',20.00,'APERTURA'),(4,'2014-02-06',100.00,'APERTURA'),(5,'2014-02-07',10.00,'APERTURA'),(6,'2014-02-11',20.00,'APERTURA');
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marcas` (
  `IdMarca` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'sin marca','1'),(2,'aconcagua','1'),(3,'alacena','1'),(4,'alfa','1'),(5,'alpesa','1'),(6,'angel','1'),(7,'bella holandesa','1'),(8,'bimbo','1'),(9,'blanca flor','1'),(10,'blancosita','1'),(11,'bonle','1'),(12,'cafetal','1'),(13,'cerdeña','1'),(14,'daly','1'),(15,'dolf','1'),(16,'dorina','1'),(17,'dos caballos','1'),(18,'duryea','1'),(19,'el firme','1'),(20,'elephant','1'),(21,'elitte','1'),(22,'everest','1'),(23,'fanny','1'),(24,'fiesta','1'),(25,'fina','1'),(26,'frica','1'),(27,'frugos','1'),(28,'gloria','1'),(29,'hamilton','1'),(30,'heinz','1'),(31,'herbi','1'),(32,'jennifer','1'),(33,'kikko','1'),(34,'kimbo','1'),(35,'la americana','1'),(36,'la danesa','1'),(37,'la europea','1'),(38,'la preferida','1'),(39,'la segoviana','1'),(40,'laive','1'),(41,'lassy','1'),(42,'leal','1'),(43,'loro','1'),(44,'lucky','1'),(45,'macbell','1'),(46,'manty','1'),(47,'mc colins','1'),(48,'menu','1'),(49,'milo','1'),(50,'mirkito','1'),(51,'molib','1'),(52,'negrita','1'),(53,'nescafe','1'),(54,'nesquik','1'),(55,'nestle','1'),(56,'otto kunz','1'),(57,'pamesa','1'),(58,'pepito','1'),(59,'premier','1'),(60,'pura vida','1'),(61,'pyc','1'),(62,'rollosito','1'),(63,'san fernando','1'),(64,'san gabriel','1'),(65,'scott','1'),(66,'segoviana','1'),(67,'sello de oro','1'),(68,'suiza','1'),(69,'swis','1'),(70,'tampico','1'),(71,'tari','1'),(72,'tari','1'),(73,'t-shirt','1'),(74,'tucan','1'),(75,'tuxa','1'),(76,'universal','1'),(77,'winston','1'),(78,'winter','1'),(79,'tres islas','1'),(80,'caballo de oro','1'),(81,'MAIZENA','1'),(82,'SAN JACINTO','1'),(83,'BELLIDO','1'),(84,'SUPER','1'),(85,'ECCO','1'),(86,'LIZ','1'),(87,'MILKITO','1'),(88,'NOBLE','1'),(89,'MAGGI','1'),(90,'UNIÓN','1'),(91,'2.5 EVERT','1'),(92,'SOY VIDA','1');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `IdProducto` int(11) NOT NULL AUTO_INCREMENT,
  `IdMarca` int(11) DEFAULT NULL,
  `IdCategoria` int(11) NOT NULL,
  `IdUnidadMedida` int(11) DEFAULT NULL,
  `Descripcion` varchar(80) NOT NULL,
  `Costo` decimal(7,2) DEFAULT NULL,
  `Precio` decimal(7,2) DEFAULT NULL,
  `Precio2` decimal(7,2) DEFAULT NULL,
  `paquete` decimal(7,2) DEFAULT NULL,
  `Stock` decimal(7,2) NOT NULL,
  `StockMinimo` decimal(7,2) DEFAULT NULL,
  `CodigoBarra` varchar(30) DEFAULT NULL,
  `Observacion` varchar(100) DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdProducto`),
  KEY `fk_idmarca_pro` (`IdMarca`),
  KEY `fk_idcategoria_pro` (`IdCategoria`),
  KEY `fk_unidadmedida_pro` (`IdUnidadMedida`),
  CONSTRAINT `fk_idcategoria_pro` FOREIGN KEY (`IdCategoria`) REFERENCES `categorias` (`IdCategoria`),
  CONSTRAINT `fk_idmarca_pro` FOREIGN KEY (`IdMarca`) REFERENCES `marcas` (`IdMarca`),
  CONSTRAINT `fk_unidadmedida_pro` FOREIGN KEY (`IdUnidadMedida`) REFERENCES `unidadmedidas` (`IdUnidadMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=353 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,63,1,1,'JAM POLL SF X 100GR',0.00,1.00,0.83,6.00,110.00,10.00,'7750946002639','','1'),(2,63,1,1,'MORTADELLA X 100 GR',0.00,1.00,0.83,6.00,100.00,5.00,'7750946000017','','1'),(3,63,1,1,'CHORIZO SF X 85G X PAQ6',0.00,1.00,0.97,6.00,0.00,5.00,'7750946000123','','1'),(4,63,1,1,'SALCHICHA POLLO SF 100 GR',0.00,1.00,0.83,6.00,120.00,5.00,'7750946002592','','1'),(5,63,1,1,'SUPER SALCHICHA SF X24 920 GR.',0.00,5.50,5.50,24.00,45.00,5.00,'7750946001335','','1'),(6,35,1,1,'Chich lam 100gr ',0.00,1.70,1.63,12.00,20.00,5.00,'7750284000106','','1'),(7,13,1,1,'CHICH CDÑA X 100G',0.00,1.70,1.67,12.00,0.00,5.00,'7759352337601','','1'),(8,13,1,1,'CHICH CDÑA X 85G',0.00,1.70,1.63,12.00,8.00,5.00,'7759352337601','','1'),(9,13,1,1,'BARRA JAMON CERDEÑA 3.100 KG.',0.00,13.00,13.00,3.10,24.80,5.00,'7753080000066','','1'),(10,66,1,1,'CHORIZO SEGO X 85G',0.00,1.00,0.96,12.00,80.00,5.00,'7750302002549','','1'),(11,56,1,1,'TOCINO OTTO KUNZ 100 GR.',0.00,2.00,2.00,1.00,0.00,5.00,'7750302724915','','1'),(12,38,1,1,'SALCHI POLL X  920G/24UN.',0.00,0.00,0.00,24.00,0.00,5.00,'7750946001335','','1'),(13,62,1,1,'JAM PAVI SF X 85G X PAG6',0.00,1.50,1.33,6.00,0.00,5.00,'7750946002325','','1'),(14,66,1,1,'Chich sego x 100g',0.00,5.50,5.50,6.00,19.00,5.00,'7750302001696','','1'),(15,68,1,1,'Hog suiza x 230g',0.00,3.50,3.50,6.00,0.00,5.00,'7750151157568','','1'),(16,66,1,1,'Hog segov. 920g/24',0.00,5.50,5.50,24.00,50.00,5.00,'7750302002662','','1'),(17,63,1,1,'salchi poll x  200g x paq 6',0.00,2.00,1.58,6.00,0.00,5.00,'7750946002608','','1'),(18,80,1,1,'wantan caballo de oro',0.00,2.50,2.50,1.00,40.00,5.00,'','','1'),(19,58,1,1,'BARRA JAMON DE POLLO PEPITO 2 KG.',0.00,11.00,10.00,2.00,18.00,5.00,'7759352358644','','1'),(20,28,2,1,'Bebid glo 1L -marac',0.00,2.50,2.21,12.00,31.00,5.00,'7751271016209','','1'),(21,28,2,1,'Bebid glo 1L -mang',0.00,2.21,2.21,12.00,44.00,5.00,'7751271016216','','1'),(22,28,2,1,'Bebid glo 1L -naran',0.00,2.50,2.21,12.00,46.00,5.00,'7751271016162','','1'),(23,28,2,1,'Bebid glo 1L -dur',0.00,2.50,2.21,12.00,65.00,5.00,'7751271016155','','1'),(24,28,2,1,'Bebid glo 1L -piñ',0.00,2.50,2.21,12.00,120.00,5.00,'7751271016186','','1'),(25,28,2,1,'Bebid glo 1L -pera',0.00,2.50,2.21,12.00,36.00,5.00,'7751271016193','','1'),(26,28,2,1,'Nect glo TTP 200ml-piñ',0.00,1.00,0.83,6.00,36.00,5.00,'7751271002547','','1'),(27,28,2,1,'Nect glo TTP 200ml-naran',0.00,1.00,0.83,6.00,312.00,5.00,'7751271635240','','1'),(28,28,2,1,'Nect glo TTP 200ml-durazno',0.00,1.00,0.83,6.00,42.00,5.00,'7751271635264','','1'),(29,70,2,1,'Bebi Tampi 2 L',0.00,3.80,3.50,4.00,16.00,5.00,'7751271001472','','1'),(30,70,2,1,'Bebi Tampi 1 L',0.00,0.00,0.00,6.00,0.00,5.00,'7751271001472','','1'),(31,70,2,1,'Bebi Tampi 3.78 lt.',0.00,7.00,6.75,2.00,8.00,5.00,'','','1'),(32,70,2,1,'Bebi Tampi 1.87 lt.',0.00,3.80,3.50,4.00,13.00,5.00,'95188010644','','1'),(33,60,2,1,'Bebid P.V. 1l -dur',0.00,2.00,2.00,1.00,0.00,5.00,'7751271015349','','1'),(34,70,2,1,'bebida tampi ctr pch 2l',0.00,3.80,3.50,1.00,0.00,5.00,'7751271001472','','1'),(35,70,2,1,'bebida tampi ctr pch 600 ml.',0.00,1.80,1.67,6.00,11.00,5.00,'95188016004','','1'),(36,27,2,1,'NECT FRUGOS 235 ML-DUR',0.00,1.00,0.83,6.00,42.00,5.00,'7750182001267','','1'),(37,6,3,1,'Cereal Angel 110g-fresia',0.00,2.00,1.83,12.00,2.00,5.00,'7759826001311','','1'),(38,6,3,1,'Cereal Angel 140g-frutt',0.00,2.00,1.83,12.00,33.00,5.00,'7759826000406','','1'),(39,6,3,1,'Cereal Angel 140g-chock',0.00,2.00,1.83,12.00,38.00,5.00,'7759826000116','','1'),(40,6,3,1,'CEREAL ANGEL 140G-MEL',0.00,2.00,1.83,12.00,29.00,5.00,'7759826000123','','1'),(41,6,3,1,'CEREAL ANGEL 120G-COPIX',0.00,2.00,1.83,12.00,48.00,5.00,'7759826002899','','1'),(42,6,3,1,'CEREAL ANGEL 150G-FLAKES',0.00,2.00,1.83,12.00,62.00,5.00,'7759826000093','','1'),(43,6,3,1,'Cereal Angel 150g-zuck',0.00,2.00,1.83,12.00,41.00,5.00,'7759826000109','','1'),(44,6,3,1,'Cereal Angel 18g-fresia',0.00,0.40,0.33,12.00,96.00,5.00,'7759826001328','','1'),(45,6,3,1,'Cereal Angel 22g-mel',0.00,0.40,0.33,12.00,108.00,5.00,'7759826000161','','1'),(46,6,3,1,'Cereal Angel 22g-chock',0.00,0.40,0.33,12.00,48.00,5.00,'','','1'),(47,6,3,1,'Cereal Angel 22g-copix',0.00,0.40,0.33,12.00,60.00,5.00,'7759826001861','','1'),(48,6,3,1,'Cereal Angel 22g-zuck',0.00,0.40,0.33,12.00,38.00,5.00,'7759826001861','','1'),(49,6,3,1,'Cereal Angel 22g-kraspy',0.00,0.40,0.33,12.00,2.00,5.00,'7759826000345','','\r'),(50,54,3,1,'NESQUIK CEREAL 200 G',0.00,6.50,6.50,1.00,5.00,5.00,'7613033566790','','1'),(51,54,3,1,'nesquik cereal 400 g',0.00,12.00,12.00,1.00,7.00,5.00,'7613034517067','','1'),(52,31,3,1,'Hervi-mznilla x100sbr',0.00,3.50,3.50,1.00,4.00,5.00,'7752432000013','','1'),(53,31,3,1,'Hervii-te-c-c x 100 sbr',0.00,3.50,3.50,1.00,11.00,5.00,'7752432000051','','1'),(54,31,3,1,'Hervi-anis x 100sbr',0.00,3.50,3.50,1.00,5.00,5.00,'7752432000037','','1'),(55,31,3,1,'Hervi-anis x 25sbr',0.00,1.00,1.00,1.00,6.00,5.00,'7752432000044','','1'),(56,31,3,1,'Hervi-mznilla x 25 sb r',0.00,1.00,1.00,1.00,33.00,5.00,'7752432000020','','1'),(57,31,3,1,'Hervi-te-c-c x 25 sbr',0.00,1.00,1.00,1.00,40.00,5.00,'7752432000068','','1'),(58,31,3,1,'herbi chocolate taza 90 gr.',0.00,0.80,0.79,12.00,80.00,5.00,'7752432000310','','1'),(59,47,3,1,'McColin-anis x100sbr',0.00,5.50,5.50,1.00,10.00,5.00,'7752285009065','','1'),(60,47,3,1,'McColin-te x 100sbr',0.00,5.50,5.50,1.00,8.00,5.00,'7752285015127','','1'),(61,47,3,1,'McColin-te-c-c x 100 sbr',0.00,5.50,5.50,1.00,23.00,5.00,'7752285016308','','1'),(62,47,3,1,'McColin-manzanilla-c-c x 100 sbr',0.00,3.50,3.50,1.00,10.00,5.00,'7752285012287','','1'),(63,33,3,1,'Siyau kikko 500ml',0.00,2.00,2.00,1.00,12.00,5.00,'7752704109659','','1'),(64,33,3,1,'Siyau kikko 160ml x6',0.00,5.00,5.00,1.00,0.00,5.00,'7752704109628','','1'),(65,19,3,1,'Vinagr firme 1l - tinto',0.00,3.50,3.50,1.00,14.00,5.00,'7753121109161','','1'),(66,19,3,1,'Vinagr firme 1l - blan',0.00,3.50,3.50,1.00,8.00,5.00,'7753121109178','','1'),(67,19,3,1,'vinagr firme 1.1l-blan',0.00,2.50,2.50,1.00,5.00,5.00,'7753121000772','','1'),(68,19,3,1,'vinagr firme 1.1l-tinto',0.00,2.50,2.50,1.00,0.00,5.00,'7753121000789','','1'),(69,53,3,1,'Café Nesc 50g-sobre',0.00,5.50,5.50,1.00,0.00,5.00,'7613031592814','','1'),(70,53,3,1,'Café Nesc 50g-pote',0.00,6.50,6.50,1.00,0.00,5.00,'7702024002925','','1'),(71,53,3,1,'Café Nesc 10g',0.00,1.00,0.94,16.00,0.00,5.00,'','','1'),(72,53,3,1,'Café Nesc 200g',0.00,22.00,22.00,1.00,0.00,5.00,'7702024002963','','1'),(73,53,3,1,'Café Nesc-Kirma 200g',0.00,19.50,19.50,1.00,8.00,5.00,'7802950088502','','1'),(74,34,3,1,'Cebada Kimbo 190gr',0.00,5.50,5.50,1.00,0.00,5.00,'7750463002464','','1'),(75,48,3,1,'PURÉ MENÚ  125G',0.00,2.50,2.50,1.00,0.00,5.00,'7750243018470','','1'),(76,3,3,1,'Aji Alacena 100cm',0.00,1.80,1.54,12.00,0.00,5.00,'7750243021760','','1'),(77,3,3,1,'Salsa Alacena 100cm',0.00,1.80,1.54,12.00,0.00,5.00,'7750243003971','','1'),(78,3,3,1,'Hcaina Alacena 90g',0.00,1.80,1.54,12.00,0.00,5.00,'7750243028332','','1'),(79,3,3,1,'Ketchup Alacena  100g',0.00,1.00,1.00,1.00,0.00,5.00,'7750243003070','','1'),(80,72,3,1,'aji crema Tari 85g',0.00,1.80,1.54,12.00,0.00,5.00,'7750243030328','','1'),(81,3,3,1,'mayonesa alacena 500 cc',0.00,7.00,7.00,1.00,54.00,5.00,'7750243514521','','1'),(82,3,3,1,'Mayonesa Alacena 115cm',0.00,1.80,1.79,12.00,4.00,5.00,'7750243035255','','1'),(83,3,3,1,'Rocoto Alacena 100cm',0.00,1.80,1.54,12.00,0.00,5.00,'7750243021784','','1'),(84,31,3,1,'choco herbi 90 g',0.00,0.80,0.79,12.00,0.00,5.00,'7752432000310','','1'),(85,12,3,1,'CAFÉ CAFETAL SELECTO 220 G',0.00,5.50,5.50,1.00,21.00,5.00,'7754308000158','','1'),(86,49,3,1,'café milo 200 g-bolsa',0.00,5.50,5.50,1.00,15.00,5.00,'7613031592753','','1'),(87,49,3,1,'café milo 400 g',0.00,8.00,8.00,1.00,5.00,5.00,'7702020000000','','1'),(88,60,4,1,'Yog PV 90g',0.00,0.50,0.42,24.00,0.00,5.00,'7751271001526','','1'),(89,28,4,1,'Yog glo 1k-fre',0.00,4.50,4.33,6.00,-3.00,5.00,'7751271011662','','1'),(90,28,4,1,'Yog glo 1k-light fre',0.00,0.00,0.00,6.00,4.00,5.00,'7751271011808','','1'),(91,28,4,1,'Yog glo 1k-nat',0.00,4.50,4.33,6.00,-2.00,5.00,'7751271011730','','1'),(92,28,4,1,'Yog glo 1k-tutti',0.00,4.50,4.33,6.00,7.00,5.00,'7751271011716','','1'),(93,28,4,1,'YOG GLO 1K-DUR',0.00,4.50,4.33,6.00,3.00,5.00,'7751271011686','','1'),(94,28,4,1,'Yog glo 1k-vnilla f',0.00,4.50,4.33,6.00,18.00,5.00,'7751271011679','','1'),(95,28,4,1,'Yog glo 1k-luc',0.00,4.50,4.33,6.00,24.00,5.00,'7751271011693','','1'),(96,28,4,1,'Yog glo 1k-piñ',0.00,4.50,4.33,6.00,25.00,5.00,'7751271011754','','1'),(97,28,4,1,'Yog glo 1k-fre l',0.00,4.50,4.33,6.00,59.00,5.00,'7751271011808','','1'),(98,28,4,1,'Yog glo 1k-dur l',0.00,4.50,4.33,6.00,16.00,5.00,'7751271011822','','1'),(99,28,4,1,'Yog glo 1k-gnab',0.00,4.50,4.33,6.00,22.00,5.00,'7751271011709','','1'),(100,28,4,1,'Yog glo 1k-act fre',0.00,5.00,4.33,6.00,57.00,5.00,'7751271011778','','1'),(101,28,4,1,'Yog glo 1k-act hig',0.00,5.00,4.33,6.00,12.00,5.00,'7751271010818','','1'),(102,28,4,1,'Yog glo 1k-act gr',0.00,5.00,4.33,6.00,13.00,5.00,'7751271014625','','1'),(103,28,4,1,'Yog glo 1k-soyv f',0.00,3.00,2.67,6.00,14.00,5.00,'7751271011976','','1'),(104,28,4,1,'Yog glo 500g-act gr',0.00,3.00,2.67,6.00,24.00,5.00,'7751271000833','','1'),(105,28,4,1,'Yog glo 500g-fre',0.00,2.50,2.50,6.00,12.00,5.00,'7751271011990','','1'),(106,28,4,1,'Yog glo 500g-vnilla',0.00,2.50,2.42,6.00,12.00,5.00,'7751271012003','','1'),(107,28,4,1,'Yog glo 190g-fre',0.00,1.00,0.88,12.00,96.00,5.00,'7751271016049','','1'),(108,28,4,1,'Yog glo 100 g pro defensis',0.00,6.50,6.50,1.00,2.00,5.00,'7751271012393','','1'),(109,28,4,1,'YOG GLO FRESA X 190GR',0.00,1.00,1.00,1.00,88.00,24.00,'7751271016049','','1'),(110,28,4,1,'YOG GLO BATISHAKE 120G',0.00,1.00,0.79,24.00,-9.00,5.00,'7751271012324','','1'),(111,28,4,1,'Yog glo Battimix 125 g.',0.00,2.42,2.42,12.00,135.00,5.00,'7751271012263','','1'),(112,28,4,1,'Yog glo Battimix ojuela 125 g.',0.00,2.50,2.42,12.00,21.00,5.00,'7751271012270','','1'),(113,7,4,1,'YoMost BellH 180ml-fre',0.00,1.20,1.17,12.00,42.00,5.00,'7751271276733','','1'),(114,40,4,1,'Yog laive 1.8l-prob f',0.00,8.00,8.00,4.00,0.00,5.00,'7750151000369','','1'),(115,40,4,1,'Yog laive 1.8l-prob v',0.00,8.00,8.00,4.00,0.00,5.00,'7750151000376','','1'),(116,60,4,1,'yog pv batidito',0.00,0.50,0.42,12.00,209.00,5.00,'7751271001526','','1'),(117,1,8,2,'QUESO',0.00,12.00,12.00,1.00,163.00,10.00,'','','1'),(118,67,5,2,'chuño santi',0.00,5.00,4.50,1.00,6.30,5.00,'','','1'),(119,82,5,2,'AZÚCAR SAN JACINTO',0.00,2.00,2.00,1.00,19.90,50.00,'','','1'),(120,67,5,2,'guindones',0.00,8.00,7.00,1.00,20.00,5.00,'','','1'),(121,61,6,1,'PAN FAMIL PYC 435G',0.00,4.00,3.80,1.00,9.00,5.00,'7750727001912','','1'),(122,8,6,1,'pan famil bimbo mediano 480g',0.00,6.00,5.80,1.00,0.00,5.00,'7750727003329','','1'),(123,77,7,1,'Cigarr winston -rojo',0.00,63.00,63.00,1.00,0.00,5.00,'77531476','','1'),(124,77,7,1,'Cigarr winston -azul',0.00,63.00,63.00,1.00,0.00,5.00,'77531469','','1'),(125,29,7,1,'Cigarr hamtl azul',0.00,5.60,5.60,10.00,129.00,5.00,'78009158','','1'),(126,29,7,1,'Cigarr hamtl verde',0.00,5.60,5.60,1.00,59.00,5.00,'77538826','','1'),(127,29,7,1,'Cigarr hamtl azul chic',0.00,2.90,2.85,20.00,160.00,5.00,'78009738','','1'),(128,29,7,1,'Cigarr hamtl verde chic',0.00,2.90,2.85,20.00,80.00,5.00,'77538833','','1'),(129,29,7,1,'Cigarr hamtl convertible fresh chico',0.00,0.00,0.00,20.00,40.00,5.00,'77538833','','1'),(130,29,7,1,'Cigarr hamtl lucky strike chico',0.00,3.80,3.80,20.00,39.00,5.00,'77540683','','1'),(131,44,7,1,'Cigarr lucky azul',0.00,7.60,7.60,10.00,-1.00,5.00,'77538048','','1'),(132,44,7,1,'Cigarr lucky verde',0.00,7.60,7.60,10.00,-1.00,5.00,'77540690','','1'),(133,44,7,1,'Cigarr lucky azul chic',0.00,3.80,3.80,20.00,-2.00,5.00,'77538222','','1'),(134,44,7,1,'Cigarr lucky verde chic',0.00,3.80,3.80,20.00,0.00,5.00,'77540683','','1'),(135,59,7,1,'Cigarr premier',0.00,6.00,6.00,1.00,30.00,5.00,'7751145001027','','1'),(136,20,7,1,'Cigarr elephant',0.00,15.00,15.00,1.00,0.00,5.00,'6901028199100','','1'),(137,11,8,1,'Qso. bonle glo- rall 35g.',0.00,2.50,2.42,12.00,0.00,5.00,'7751271001205','','1'),(138,11,8,1,'leche bonle cremosa bolsa 400 gr.',0.00,2.20,2.17,24.00,216.00,5.00,'7751271013635','','1'),(139,28,8,1,'Lech glo 170g',0.00,1.50,1.40,48.00,110.00,5.00,'7751271021579','','1'),(140,28,8,1,'Lech Glo-Evap-410g light',0.00,2.80,2.70,24.00,155.00,5.00,'7751271103237','','1'),(141,28,8,1,'Lech Glo-Evap-410g',0.00,2.80,2.70,24.00,331.00,5.00,'7751271103213','','1'),(142,28,8,1,'Lech Glo-Desl-410g',0.00,3.10,3.00,24.00,171.00,5.00,'7751271010504','','1'),(143,28,8,1,'Lech Glo-dha-410g',0.00,3.20,3.00,24.00,115.00,5.00,'7751271016766','','1'),(144,28,8,1,'Lech Glo-Ev.semi-410g',0.00,3.20,3.00,24.00,0.00,5.00,'7751271103237','','1'),(145,28,8,1,'Lech Glo-soy v-400g',0.00,1.50,1.50,24.00,130.00,5.00,'7751271007269','','1'),(146,28,8,1,'Lech glo UHT 1l-choco',0.00,3.80,3.50,12.00,35.00,5.00,'7751271226981','','1'),(147,28,8,1,'Lech glo UHT 1l-light',0.00,3.50,3.33,12.00,28.00,5.00,'7751271226974','','1'),(148,28,8,1,'Lech glo UHT 1l-entera',0.00,3.33,3.33,12.00,32.00,5.00,'7751271131780','','1'),(149,28,8,1,'Lech glo UHT 1l-niños dha',0.00,3.80,3.58,12.00,36.00,5.00,'7751271004213','','1'),(150,28,8,1,'Lech glo UHT 1l-no preservantes',0.00,3.50,3.33,1.00,2.00,5.00,'7751271000901','','1'),(151,28,8,1,'Lech Glo 180ml.-choco',0.00,1.00,0.97,6.00,0.00,5.00,'7751271016681','','1'),(152,28,8,1,'Lech Glo bolsa 946ml.-choco',0.00,3.00,3.00,1.00,20.00,5.00,'','','1'),(153,28,8,1,'LECH GLO CONDENSADA 395 GR.',0.00,4.00,4.00,1.00,21.00,5.00,'7751271003728','','1'),(154,60,8,1,'Lech P.V 165g',0.00,1.20,1.10,48.00,336.00,5.00,'7751271007771','','1'),(155,60,8,1,'Lech P.V 400 gr.',0.00,2.10,2.08,24.00,100.00,5.00,'7751271049184','','1'),(156,60,8,1,'Lech P.V chocolatada bolsa 800 ml',0.00,2.50,2.50,10.00,50.00,5.00,'7751271056397','','1'),(157,40,8,1,'Qso. Laive eddam x 90g',0.00,3.50,3.46,12.00,0.00,5.00,'7750151986014','','1'),(158,40,8,1,'lech laive 500g-evap',0.00,2.50,2.42,12.00,0.00,5.00,'7750151002301','','1'),(159,40,8,1,'lech laive 500g-deslact',0.00,3.00,3.00,1.00,11.00,5.00,'7750151000406','','1'),(160,40,8,1,'LECHE LAIVE FAMILIA 500 ML.',0.00,2.50,2.42,1.00,243.00,5.00,'7750151002301','','1'),(161,67,9,1,'Papel sulfito',0.00,1.00,1.00,1.00,23.00,5.00,'','','1'),(162,50,9,1,'Cuch 5 mirkito 100unid',0.00,1.50,1.00,10.00,6.00,5.00,'','','1'),(163,50,9,1,'Tene mirkito 100uni',0.00,1.50,1.00,10.00,4.00,5.00,'','','1'),(164,67,9,1,'tenedores x100 num 5 ',0.00,1.50,1.50,1.00,104.00,5.00,'','','1'),(165,67,9,1,'tenedores color x100 num 4',0.00,1.20,1.15,10.00,0.00,5.00,'','','1'),(166,67,9,1,'tenedores blanco x100 num 5 ',0.00,1.50,1.30,10.00,65.00,5.00,'','','1'),(167,4,9,1,'tenedores blanco x100 num 6',0.00,3.00,2.80,10.00,0.00,5.00,'','','1'),(168,67,9,1,'picad s-m 100 unid',0.00,1.00,0.90,10.00,113.00,5.00,'','','1'),(169,37,9,1,'cuch la europea 100 unid- colores',0.00,1.20,1.20,1.00,3.00,5.00,'','','1'),(170,67,9,1,'sangu sandwichs-plastico',0.00,1.00,0.90,10.00,28.00,5.00,'','','1'),(171,64,9,1,'vaso 10 onz san gabriel 50 unid',0.00,4.50,4.30,20.00,21.00,5.00,'','','1'),(172,64,9,1,'vaso 10 onz opaco 50 unid x 20pt',0.00,4.50,4.30,1.00,100.00,5.00,'','','1'),(173,64,9,1,'vaso 10 onz transp 50 unid x 20pt',0.00,4.50,4.30,1.00,100.00,5.00,'','','1'),(174,64,9,1,'vaso 8 onz tecnopor 50 unid',0.00,8.00,8.00,20.00,22.00,5.00,'','','1'),(175,67,9,1,'VASO 7 ONZ 3B 50 UNID X 20PT',0.00,1.25,1.15,10.00,100.00,5.00,'','','1'),(176,67,9,1,'vaso 5 onz 50 unid',0.00,2.50,2.30,20.00,0.00,5.00,'','','1'),(177,67,9,1,'vaso 5.5 onz 50 unid',0.00,2.50,2.30,1.00,16.00,5.00,'7750078001296','','1'),(178,67,9,1,'vaso 6 onz alfa 50 unid x 20pt',0.00,2.50,2.30,1.00,42.00,5.00,'','','1'),(179,67,9,1,'vaso 3 onz alf 50 unid x 20pt',0.00,2.00,1.90,1.00,5.00,5.00,'','','1'),(180,67,9,1,'plato 15 visoras 25 unid',0.00,3.50,3.50,1.00,50.00,5.00,'','','1'),(181,67,9,1,'plato 12 visoras 25 unid',0.00,2.50,2.50,1.00,98.00,5.00,'','','1'),(182,67,9,1,'plato 14 visoras 25 unid',0.00,2.80,2.80,1.00,50.00,5.00,'','','1'),(183,67,9,1,'plato ovalado 50 unid',0.00,4.50,4.50,1.00,3.00,5.00,'','','1'),(184,50,9,1,'tend transp mirkito 50 unid',0.00,3.50,3.50,1.00,100.00,5.00,'','','1'),(185,37,9,1,'cuch transp la europea 50 unid',0.00,3.50,3.50,1.00,100.00,5.00,'','','1'),(186,24,9,1,'plato triple 26 fiesta 25 unid',0.00,4.50,4.25,4.00,40.00,5.00,'','','1'),(187,24,9,1,'plato 22 fiesta 25 unid',0.00,2.80,2.50,1.00,22.00,5.00,'','','1'),(188,24,9,1,'plato sopero 20 fiesta 25 unid',0.00,4.50,4.25,4.00,7.00,5.00,'','','1'),(189,64,9,1,'plato 18 san gabriel 25 unid',0.00,1.80,1.63,4.00,43.00,5.00,'','','1'),(190,67,9,1,'taper ct2 x50 superfast',0.00,22.50,22.50,1.00,403.00,5.00,'','','1'),(191,68,9,1,'taper ct3 x50 superfast',0.00,15.00,15.00,8.00,0.00,5.00,'','','\r'),(192,57,9,1,'taper ct4 x50 pamesa',0.00,10.00,10.00,5.00,4.00,5.00,'','','1'),(193,57,9,1,'taper ct5 x50 pamesa',0.00,10.00,10.00,6.00,0.00,5.00,'','','\r'),(194,67,9,1,'plato bandeja 50 unid',0.00,7.00,7.00,1.00,12.00,5.00,'','','1'),(195,43,10,4,'10X15  loro 80un',0.00,1.00,1.00,1.00,-1.00,5.00,'','','1'),(196,4,10,4,'10x15 blancosito',0.00,2.20,2.20,1.00,8.00,5.00,'','','1'),(197,4,10,4,'12x13',0.00,2.00,2.00,1.00,0.00,5.00,'','','1'),(198,43,10,4,'12X16 loro - color',0.00,2.20,2.20,1.00,0.00,5.00,'','','1'),(199,4,10,4,'12X16 loro - blanco',0.00,2.20,2.20,1.00,-20.00,5.00,'','','1'),(200,4,10,4,'12X16 loro - negro',0.00,2.20,2.20,1.00,0.00,5.00,'','','1'),(201,4,10,4,'12x17 rollo alfa',0.00,8.50,8.50,1.00,0.00,5.00,'','','1'),(202,4,10,4,'13X19 alfa 40un',0.00,1.50,1.50,1.00,0.00,5.00,'','','1'),(203,4,10,4,'13x19 dolf',0.00,1.50,0.00,1.00,30.00,5.00,'','','1'),(204,43,10,4,'16x19 loro 100uni',0.00,3.60,3.50,1.00,0.00,5.00,'','','1'),(205,62,10,4,'16x19 tucan',0.00,3.60,3.50,1.00,0.00,5.00,'','','1'),(206,4,10,4,'2.5 x 8 Everest',0.00,0.70,0.60,1.00,0.00,5.00,'','','1'),(207,74,10,4,'20x30 negro la preferida',0.00,6.00,5.00,1.00,0.00,5.00,'','','1'),(208,43,10,4,'26x40 lassy 100 unid',0.00,10.00,9.00,1.00,0.00,5.00,'','','1'),(209,43,10,4,'21X24 pb 100un t-shirt',0.00,8.80,8.80,1.00,0.00,5.00,'','','1'),(210,15,10,4,'3X8 alfa 200un',0.00,1.30,1.30,5.00,31.00,5.00,'','','1'),(211,43,10,4,'4X8 alfa 200un ',0.00,1.50,1.50,1.00,53.00,5.00,'','','1'),(212,67,10,4,'5X10 alfa 100un - blancosita',0.00,0.90,0.90,1.00,20.00,5.00,'','','1'),(213,10,10,4,'5X10 alfa 100un-crist',0.00,1.30,1.30,1.00,20.00,5.00,'','','1'),(214,4,10,4,'5X10 alfa 200un-crist',0.00,2.50,2.50,1.00,20.00,5.00,'','','1'),(215,4,10,4,'5x10 rollosito alfa',0.00,8.50,8.50,1.00,4.00,5.00,'','','1'),(216,10,10,4,'5x32 alfa 70un',0.00,0.70,0.65,10.00,37.00,5.00,'','','1'),(217,4,10,4,'6X12 alfa 100un ',0.00,1.50,1.50,1.00,160.00,5.00,'','','1'),(218,73,10,4,'6x12 alfa 200un ',0.00,3.00,3.00,1.00,15.00,5.00,'','','1'),(219,67,10,4,'6x6 sanguchero alfa 100 unid',0.00,1.00,0.90,1.00,2.00,5.00,'','','1'),(220,10,10,4,'7X10 alfa 100un - blancosito',0.00,1.00,1.00,1.00,40.00,5.00,'','','1'),(221,4,10,4,'8X12 alfa 100un - blanc',0.00,1.20,1.20,1.00,19.00,5.00,'','','1'),(222,41,10,4,'8X12 loro',0.00,0.90,0.90,1.00,3.00,5.00,'','','1'),(223,38,10,4,'8x12 rollo alfa',0.00,1.20,1.20,1.00,2.00,5.00,'','','1'),(224,3,11,1,'Mayonesa Alacena 10 cc',0.00,2.50,2.20,20.00,37.00,5.00,'','','1'),(225,3,11,1,'HUANCAINA ALACENA 90 CC',0.00,1.80,1.54,12.00,24.00,5.00,'7750243028332','','1'),(226,3,11,1,'HUANCAINA ALACENA X 900GR',0.00,10.00,10.00,1.00,15.00,6.00,'7750243028349','','1'),(227,3,11,1,'rocoto molido alacena 100 cc',0.00,1.80,1.54,12.00,12.00,5.00,'','','1'),(228,3,11,1,'ketchup alacena 100 cc',0.00,1.00,1.00,12.00,12.00,5.00,'','','1'),(229,5,11,1,'Mostaza personal alpesa 10 gr.',0.00,1.50,1.25,20.00,120.00,5.00,'','','1'),(230,5,11,1,'Ketchup personal alpesa 10 gr.',0.00,1.50,1.25,20.00,70.00,5.00,'','','1'),(231,5,11,1,'Mostaza alpeza 20 kg.',0.00,63.00,63.00,1.00,5.00,5.00,'','','1'),(232,5,11,1,'Mostaza alpeza 4 kg.',0.00,13.50,13.50,1.00,18.00,5.00,'','','1'),(233,9,11,1,'HARINA PRE BL FLOR 1K',0.00,5.30,5.10,12.00,91.00,5.00,'7750243006880','','1'),(234,23,11,1,'Mermel.fanny 1k',0.00,6.50,6.50,1.00,0.00,5.00,'7750885005920','','1'),(235,23,11,1,'Mermel fanny 310g',0.00,3.50,3.25,1.00,0.00,5.00,'7750885008747','','1'),(236,23,11,1,'Mermelada fanny pote 340 gr.',0.00,3.50,3.25,12.00,61.00,5.00,'7750885008525','','1'),(237,23,11,1,'Mermelada fanny vaso 310 gr.',0.00,3.50,3.25,1.00,28.00,5.00,'7750885008747','','1'),(238,23,11,1,'fanny piña en rodajas 567 gr.',0.00,4.50,4.25,24.00,0.00,5.00,'','','1'),(239,23,11,1,'fanny cocktail de frutas 820 gr.',0.00,7.00,7.00,1.00,4.00,5.00,'7750885006101','','\r'),(240,79,11,1,'durasnos en mitades tres islas',0.00,5.60,5.60,1.00,3.00,5.00,'7753255000013','','\r'),(241,26,11,1,'ketchup frica 10 kg.',0.00,3.40,3.40,1.00,24.00,5.00,'','','1'),(242,28,11,1,'Mermel. Glo 340g',0.00,3.50,3.25,12.00,44.00,5.00,'7751271071260','','1'),(243,28,11,1,'Mermel. Glo 320g x 12 Vas',0.00,3.50,3.25,1.00,0.00,5.00,'','','1'),(244,28,11,1,'Mermel. Glo 240g x 12 fr.',0.00,3.50,3.25,1.00,0.00,5.00,'','','1'),(245,28,11,1,'Manteq. Glo 100g.  x 48u',0.00,2.80,2.63,12.00,-12.00,5.00,'7772905002351','','1'),(246,28,11,1,'Manteq. Glo 200g.  x 24u',0.00,5.00,4.80,1.00,-6.00,5.00,'7772905002368','','1'),(247,30,11,1,'colado Heinz 113g - banan',0.00,0.00,0.00,1.00,0.00,5.00,'608875003210','','1'),(248,32,11,1,'PAPITAS JENNIFER 225 GR.',0.00,2.50,1.80,25.00,0.00,5.00,'7754465000015','','0'),(249,36,11,1,'mantequilla la danesa 2 kg.',0.00,8.00,7.50,1.00,5.00,5.00,'','','1'),(250,38,11,1,'Mantequilla La Preferida 10 kg.',0.00,8.00,8.00,1.00,8.00,5.00,'','','1'),(251,42,11,1,'Flan leal bolsa 5kg',0.00,7.00,6.50,1.00,2.00,5.00,'','','1'),(252,42,11,1,'gelatina leal naranja',0.00,7.00,6.50,5.00,5.00,5.00,'','','1'),(253,42,11,1,'gelatina leal menta',0.00,7.00,6.50,5.00,3.40,5.00,'','','1'),(254,42,11,1,'gelatina leal fresa',0.00,7.00,6.50,5.00,3.00,5.00,'','','1'),(255,42,11,1,'gelatina leal piña',0.00,7.00,6.50,5.00,3.00,5.00,'','','1'),(256,45,11,1,'Mayoneza base macbell 4lt.',0.00,8.00,6.75,4.00,20.00,5.00,'','','1'),(257,46,11,1,'MANTEQUILLA MANTY 50 GR.',0.00,0.50,0.50,1.00,87.00,5.00,'17750243035283','','1'),(258,46,11,1,'MANTEQUILLA MANTY 100 GR.',0.00,1.00,0.90,24.00,-264.00,5.00,'77542557','','1'),(259,48,11,1,'pure papa menu 125 gr.',0.00,2.50,2.50,1.00,10.00,5.00,'7750243018470','','0'),(260,51,11,1,'Mostaza Molib bolsa 4 kg.',0.00,3.40,3.40,4.00,16.00,5.00,'','','1'),(261,52,11,1,'VAINILLA NEGRITA 90 ML',0.00,1.00,0.83,12.00,82.00,5.00,'7750243011884','','1'),(262,55,11,1,'Lech cond nestle 397g',0.00,4.50,4.33,12.00,0.00,5.00,'7802950066906','','1'),(263,55,11,1,'Lech cond nestle 100g',0.00,1.80,1.67,12.00,0.00,5.00,'7702024002826','','1'),(264,55,11,1,'MANJAR NESTLE 200 G',0.00,2.80,2.75,12.00,-3.00,5.00,'7802950009408','','1'),(265,55,11,1,'Manjar nestle 500 gr.',0.00,7.00,7.00,1.00,19.00,5.00,'','','1'),(266,55,11,1,'MANJAR NESTLE 1 KG.',0.00,13.00,13.00,1.00,5.00,5.00,'7802950004892','','1'),(267,67,11,1,'Mantequilla Sello de Oro 400 gr.',0.00,6.00,6.00,12.00,10.00,5.00,'7750243035361','','1'),(268,67,11,1,'Mantequilla Sello de Oro 45 gr. X caja',0.00,12.00,12.00,24.00,10.00,5.00,'','','1'),(269,67,11,1,'MANTEQUILLA SELLO DE ORO 90 GR. X CAJA',0.00,1.00,0.90,20.00,-4.00,5.00,'7750243035323','','1'),(270,67,11,1,'Azucar blanca kg',0.00,2.20,2.20,1.00,0.00,5.00,'','','1'),(271,67,11,1,'Azucar rubia kg',0.00,2.00,2.00,1.00,0.00,5.00,'','','\r'),(272,67,11,1,'Harina kg',0.00,2.20,2.20,1.00,0.00,5.00,'','','1'),(273,69,11,1,'Manteq. Swis Brra. 100 gr.',0.00,1.50,1.50,1.00,0.00,5.00,'7750151163613','','\r'),(274,69,11,1,'Manteq. Swis Brra. 200 gr.',0.00,3.00,3.00,1.00,0.00,5.00,'','','1'),(275,72,11,1,'crema aji tari 85 gr.',0.00,1.80,1.54,24.00,264.00,5.00,'7750243030328','','1'),(276,72,11,1,'crema aji tari 400 gr.',0.00,7.00,7.00,1.00,4.00,5.00,'7750243030335','','1'),(277,76,11,1,'Gelat. Univ. 150g - piñ',0.00,2.50,2.42,12.00,27.00,5.00,'7752230001670','','1'),(278,76,11,1,'Gelat. Univ. 150g - fre',0.00,2.50,2.42,12.00,0.00,5.00,'','','1'),(279,76,11,1,'Gelat. Univ. 150g - nar',0.00,2.50,2.42,12.00,0.00,5.00,'7752230001687','','1'),(280,76,11,1,'Colapi Univ 20g',0.00,1.40,1.35,12.00,4.00,5.00,'7752230119696','','1'),(281,76,11,1,'Flan Univ. 150g',0.00,2.50,2.42,12.00,0.00,5.00,'7752230001885','','1'),(282,70,2,1,'BEBIDAS TAMPICO 1.5L',0.00,2.50,2.25,1.00,-1.00,6.00,'7751271015455','','1'),(283,76,11,1,'Flan universal x 5 k',0.00,6.50,6.00,5.00,0.00,5.00,'','','1'),(284,76,11,1,'Gelatina universal x 1/4 k',0.00,2.50,2.42,12.00,0.00,5.00,'7752230001663','','1'),(285,20,12,1,'papel toa elite 105hjas',0.00,2.50,2.17,12.00,0.00,5.00,'7759185003995','','1'),(286,25,12,1,'servill. Fina 200 unid',0.00,1.00,0.77,15.00,2.00,5.00,'','','1'),(287,20,12,1,'servill. Elit 200 unid',0.00,1.00,0.83,18.00,126.00,5.00,'7759185002523','','1'),(288,20,12,1,'servill. Elit 400 unid',0.00,2.00,1.83,1.00,76.00,5.00,'7759185099509','','1'),(289,65,12,1,'servill. Scott 100 unid doblada',0.00,2.50,2.50,1.00,0.00,5.00,'7751493877053','','1'),(290,65,12,1,'servill. Scott 220 unid',0.00,1.00,1.00,1.00,26.00,5.00,'7751493000505','','1'),(291,65,12,1,'servill. Scott 400',0.00,2.50,2.50,1.00,1.00,5.00,'','','1'),(292,20,12,1,'papel h elite mega rollo',0.00,2.50,2.25,1.00,47.00,5.00,'7759185003995','','1'),(293,32,13,1,'PAPA JENNIFER BOLSA 5KG.',0.00,2.50,2.25,1.00,14.00,5.00,'7754465000015','','1'),(294,2,13,1,'Aconcagua duraznos 822 gr.',0.00,6.00,5.67,1.00,12.00,5.00,'','','1'),(295,23,13,1,'Piña fanny 567 gr.',0.00,4.50,4.25,1.00,18.00,5.00,'','','1'),(296,63,13,1,'HAMBURGUESA CARNE SF 965 GR.',0.00,8.30,8.30,1.00,10.00,5.00,'7750946000727','','1'),(297,32,13,1,'HAMBURGUESA CARNE JENNIFER 1KG.',0.00,5.50,5.50,1.00,9.00,5.00,'','','1'),(298,63,13,1,'Nuggets sf 180 gr.',0.00,3.50,3.50,1.00,13.00,5.00,'','','1'),(299,17,13,1,'duraznos mitades dos cab 820 gr.',0.00,6.00,5.80,1.00,12.00,5.00,'7801380101522','','1'),(300,23,13,1,'Conserv fanny - piña 820g',0.00,4.50,4.25,1.00,0.00,5.00,'7750885006279','','1'),(301,81,5,2,'MAIZENA',0.00,4.00,4.00,1.00,0.00,5.00,'','','1'),(302,60,8,1,'LECH PV BOLSA 946 ML',0.00,2.50,2.50,1.00,0.00,5.00,'','','1'),(303,60,8,1,'LECH PV BOLSA SIN LACTOSA 946 ML',0.00,2.50,2.50,1.00,0.00,5.00,'','','1'),(304,28,4,4,'YOG GLORIA SACHET FRESA',0.00,5.00,1.00,5.00,0.00,5.00,'','','1'),(305,1,5,2,'HUEVOS',0.00,3.40,3.40,1.00,0.00,6.00,'','','1'),(306,26,3,1,'KETCHUP FRICA BALDE',0.00,12.50,12.50,1.00,0.00,1.00,'','','1'),(307,46,11,1,'MANTEQUILLA MANTY 330 GR',0.00,3.50,3.50,1.00,0.00,5.00,'7750243035293','','1'),(308,28,4,3,'YOGURT CALLCIFEN 1LT.',0.00,5.00,5.00,1.00,0.00,5.00,'7751271013772','','1'),(309,28,8,3,'LECHE SUPER LIGHT CAJA 1LT.',0.00,3.50,3.50,1.00,0.00,10.00,'7751271632188','','1'),(310,60,4,3,'YOGURT NUTRI MAX PURA VIDA 1 LT.',0.00,4.00,4.00,1.00,0.00,10.00,'7751271017985','','1'),(311,28,8,1,'LECH GLORIA ACTIAVENA 1L UHT',0.00,4.00,3.83,1.00,0.00,24.00,'7751271016834','','1'),(312,28,8,1,'LECH GLORIA DHA NIÑOS X 200GR',0.00,1.50,1.33,1.00,0.00,6.00,'7751271016322','','1'),(313,28,4,1,'YOG GLORIA VF 190G',0.00,1.00,0.88,1.00,0.00,24.00,'7751271016070','','1'),(314,4,9,1,'SORBETIN ALFA X 60U',0.00,0.40,0.33,1.00,0.00,750.00,'','','1'),(315,83,8,2,'QUESO PARMESANO BELLIDO',0.00,34.00,34.00,1.00,0.00,10.00,'','','1'),(316,84,9,1,'MONTADIENTES REDONDOS SUPER',0.00,0.80,0.80,1.00,0.00,500.00,'','','1'),(317,55,2,1,'ECCO NESTLE X 195GR',0.00,5.80,5.80,1.00,0.00,24.00,'7802950002584','','1'),(318,28,8,1,'LECH GLORIA BOLSA LIGTH X 946ML',0.00,3.00,3.00,1.00,0.00,30.00,'7751271002684','','1'),(319,86,9,1,'SERVILLETA LIZ DOBLADAS COLORES  X 100',0.00,2.50,2.50,1.00,0.00,30.00,'7751166000061','','1'),(320,65,9,1,'PAPEL HIGENICO SCOTT MEGA ROLLO X 110HOJAS',0.00,2.50,2.50,1.00,0.00,72.00,'7751493004831','','1'),(321,28,8,1,'QUESO MOZZARELLA GLORIA BONLE',0.00,6.50,6.50,1.00,0.00,20.00,'7751271001311','','1'),(322,68,1,1,'SALCHICHA SUIZA CARNE X 230 GR',0.00,3.50,3.50,1.00,0.00,10.00,'7750151157568','','1'),(323,64,9,1,'CONTAINER 8 ONZAS SAN GABRIEL X 50',0.00,5.50,5.25,1.00,0.00,500.00,'','','1'),(324,87,4,1,'YOG MILKITO FRESA X 1K',0.00,4.50,4.17,1.00,0.00,6.00,'7751271013734','','1'),(325,61,6,1,'TOSTADAS CLÁSICAS PYC X 160',0.00,3.80,3.80,1.00,0.00,6.00,'7750727004098','','1'),(326,89,11,1,'MOSTAZA MAGGI LIBBYS X 100GR',0.00,1.00,1.00,1.00,0.00,24.00,'7613030779070','','1'),(327,90,3,1,'SALVADO DE TRIGO UNION X 200GR',0.00,3.50,3.50,1.00,0.00,3.00,'7752056668576','','1'),(328,3,11,1,'HUANCAINA ALACENA X 450GR',0.00,7.00,7.00,1.00,0.00,12.00,'7750243028318','','1'),(329,28,4,1,'YOG GLORIA PASION X 160GR',0.00,2.30,2.17,1.00,0.00,12.00,'7751271004725','','1'),(330,28,8,1,'MANTEQ. CON SAL GLORIA X 400GR',0.00,9.80,9.80,1.00,0.00,6.00,'7751271012652','','1'),(331,67,11,1,'MANTEQ. SELLO DE ORO X 225 GR',0.00,3.50,3.50,1.00,0.00,18.00,'7750243035354','','1'),(332,16,11,1,'MANTEQ. DORINA LIGHT X 225GR',0.00,4.00,4.00,1.00,0.00,24.00,'7702047013335','','1'),(333,16,11,1,'MANTEQ. DORINA LIGHT X 450GR',0.00,8.00,8.00,1.00,0.00,16.00,'7702047013342','','1'),(334,1,9,1,'SANGU SANDWICHS DE PAPEL',0.00,1.00,1.00,1.00,0.00,200.00,'','','1'),(335,90,15,1,'GRANOLA LONCHERA UNION X 200GR',0.00,4.00,4.00,1.00,0.00,3.00,'7752056000208','','1'),(336,28,4,1,'YOG GLORIA FRUTADO X 120GR',0.00,1.00,0.96,1.00,0.00,24.00,'7751271012355','','1'),(337,6,15,1,'CEREAL ANGEL - 110GR TITO ALMOHADA CHOCOLATE',0.00,2.00,1.83,1.00,0.00,30.00,'7759826001366','','1'),(338,1,5,2,'PASAS',0.00,10.00,10.00,1.00,0.00,10.00,'','','1'),(339,1,5,2,'GUINDON',0.00,8.00,8.00,1.00,0.00,5.00,'','','1'),(340,1,5,2,'COCO',0.00,10.00,10.00,1.00,0.00,20.00,'','','1'),(341,1,11,2,'AZUCAR IMPARPABLE',0.00,5.00,5.00,1.00,0.00,10.00,'','','1'),(342,1,5,2,'MOSTAZA',0.00,0.90,0.90,1.00,-2.00,20.00,'','','1'),(343,76,11,1,'COLAPIZ UNIVERSAL X 20G',0.00,1.40,1.40,1.00,0.00,36.00,'7752230119696','','1'),(344,76,11,1,'POLVO DE HORNEAR UNIVERSAL X 25GR',0.00,0.80,0.80,1.00,0.00,36.00,'7752230119702','','1'),(345,55,15,1,'MILO NESTLE X 200GR',0.00,8.00,8.00,1.00,0.00,12.00,'7613031592753','','1'),(346,28,4,1,'YOG GLO DURAZNO X 190GR',0.00,1.00,1.00,1.00,0.00,24.00,'7751271016056','','1'),(347,28,8,1,'LATA LECHE LIGHT ROJA GLORIA X 410GR',0.00,2.80,2.80,1.00,0.00,24.00,'7751271103237','','1'),(348,92,8,1,'LECHE DE SOYA SOY VIDA X 400GR',0.00,1.50,1.50,1.00,0.00,24.00,'7751271007269','','1'),(349,60,8,1,'LECHE PURA VIDA EN LATA X 400GR',0.00,2.10,2.10,1.00,0.00,24.00,'7751271049184','','1'),(350,28,4,1,'YOG GLO BATISHAKE FRE X 120GR',0.00,1.00,0.79,1.00,0.00,24.00,'7751271012317','','1'),(351,28,4,1,'YOG GLO GUANA 1K',0.00,4.50,4.33,1.00,0.00,6.00,'7751271011709','','1'),(352,28,8,1,'QUESO PARME BONLE X 35GR',0.00,2.50,4.50,1.00,0.00,50.00,'7751271001205','','1');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `IdProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `RazonSocial` varchar(70) NOT NULL,
  `Ruc` varchar(11) NOT NULL,
  `Direccion` varchar(70) DEFAULT NULL,
  `Telefono` varchar(11) DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'SIN PROVEEDOR','11111111111','-','-','1');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadmedidas`
--

DROP TABLE IF EXISTS `unidadmedidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidadmedidas` (
  `IdUnidadMedida` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(70) DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdUnidadMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadmedidas`
--

LOCK TABLES `unidadmedidas` WRITE;
/*!40000 ALTER TABLE `unidadmedidas` DISABLE KEYS */;
INSERT INTO `unidadmedidas` VALUES (1,'unidad','1'),(2,'kg.','1'),(3,'lt.','1'),(4,'bolsa','1'),(5,'botella','1');
/*!40000 ALTER TABLE `unidadmedidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `IdUsuario` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(8) NOT NULL,
  `Clave` varchar(8) NOT NULL,
  `Tipo` varchar(35) DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin','ADMINISTRADOR','1'),(2,'CONSUELO','12345','USUARIO','0'),(3,'CAROLINA','carolina','ADMINISTRADOR','1'),(4,'ESTHER','esther','ADMINISTRADOR','1');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `IdVenta` int(11) NOT NULL AUTO_INCREMENT,
  `IdCliente` int(11) DEFAULT NULL,
  `TipoDoc` varchar(20) NOT NULL,
  `SerieDoc` varchar(3) NOT NULL,
  `NumDoc` varchar(6) NOT NULL,
  `Fecha` date NOT NULL,
  `hora` time NOT NULL,
  `Igv` decimal(7,2) NOT NULL,
  `SubTotal` decimal(7,2) NOT NULL,
  `Total` decimal(7,2) NOT NULL,
  `IdUsuario` smallint(5) unsigned DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdVenta`),
  KEY `fk_idcliente` (`IdCliente`),
  KEY `fk_idusuario` (`IdUsuario`),
  CONSTRAINT `fk_idcliente` FOREIGN KEY (`IdCliente`) REFERENCES `clientes` (`IdCliente`),
  CONSTRAINT `fk_idusuario` FOREIGN KEY (`IdUsuario`) REFERENCES `usuarios` (`IdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,1,'Ticket','001','0001','2014-01-21','16:15:25',0.00,0.00,20.00,1,'1'),(2,1,'Ticket','001','0002','2014-01-21','16:21:32',0.00,0.00,11.00,1,'1'),(3,1,'Ticket','001','0003','2014-01-21','16:24:51',0.00,0.00,11.00,1,'1'),(4,1,'Ticket','001','0004','2014-01-21','16:26:03',0.00,0.00,22.50,1,'1'),(5,1,'Ticket','001','0005','2014-01-21','16:29:22',0.00,0.00,13.00,1,'1'),(6,1,'Ticket','001','0006','2014-01-21','16:56:10',0.00,0.00,29.00,1,'p'),(7,1,'Ticket','001','0007','2014-01-28','17:40:07',0.00,0.00,25.58,1,'1'),(8,1,'Ticket','001','0008','2014-02-04','16:08:31',0.00,0.00,18.80,1,'1'),(9,1,'Ticket','001','0009','2014-02-04','16:17:31',0.00,0.00,44.30,1,'p'),(10,1,'Ticket','001','0008','2014-02-04','18:09:38',0.00,0.00,37.80,1,'p'),(11,1,'Ticket','001','0009','2014-02-04','18:12:55',0.00,0.00,11.76,1,'1'),(12,1,'Ticket','001','0010','2014-02-11','16:08:32',0.00,0.00,36.06,1,'p');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-11 18:31:50
