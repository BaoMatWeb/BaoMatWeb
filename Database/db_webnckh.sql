-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: db_webnckh
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `baocaodt`
--

DROP TABLE IF EXISTS `baocaodt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baocaodt` (
  `MaDT` varchar(20) NOT NULL,
  `MaBC` varchar(20) NOT NULL,
  `TenBC` varchar(200) DEFAULT NULL,
  `FileBC` varchar(500) DEFAULT NULL,
  `NgayBC` date DEFAULT NULL,
  PRIMARY KEY (`MaDT`,`MaBC`),
  CONSTRAINT `baocaodt_ibfk_1` FOREIGN KEY (`MaDT`) REFERENCES `detai` (`MaDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baocaodt`
--

LOCK TABLES `baocaodt` WRITE;
/*!40000 ALTER TABLE `baocaodt` DISABLE KEYS */;
INSERT INTO `baocaodt` VALUES ('dt17','bc1','BÃ¡o cÃ¡o tiáº¿n Ä‘á»™ 1','upload/Nhomx.docx','2017-03-02');
/*!40000 ALTER TABLE `baocaodt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text COLLATE utf8_vietnamese_ci,
  `IMAGE` text COLLATE utf8_vietnamese_ci,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Danh mục',''),(2,'Việt Nam','fd16.png'),(3,'Trung Hoa','fd17.png'),(4,'Ấn Độ','fd18.png'),(5,'Tây Âu','fd19.png'),(6,'Quốc tế','fd20.png'),(7,'Sang trọng','fd1.png'),(8,'Nhà hàng','fd2.png'),(9,'Ăn chay','fd3.png'),(10,'Quán ăn','fd4.png'),(11,'Quán nhậu','fd5.png'),(12,'Tiệm bánh','fd6.png'),(13,'Shop Online','fd7.png'),(14,'Khu Ẩm thực','fd8.png'),(15,'Buffet','fd8.png'),(16,'Ăn vặt/vỉa hè','fd9.png'),(17,'Café/Dessert','fd10.png'),(18,'Bar/Pub','fd11.png'),(19,'Beer club','fd12.png'),(20,'Tiệc tận nơi','fd13.png'),(21,'Giao cơm văn phòng','fd14.png');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text COLLATE utf8_vietnamese_ci,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'TP.HCM'),(2,'Hà Nội'),(3,'Đà Nẵng'),(4,'Cần Thơ'),(5,'Khánh Hoà'),(6,'Vũng Tàu'),(7,'Hải Phòng'),(8,'Bình Thuận'),(9,'Lâm Đồng'),(10,'Đồng Nai'),(11,'Quảng Ninh'),(12,'Huế'),(13,'Bình Dương'),(14,'Ninh Thuận'),(15,'Hải Dương'),(16,'Nam Định'),(17,'Tiền Giang'),(18,'Kon Tum'),(19,'Quảng Nam'),(20,'Lào Cai'),(21,'Nghệ An'),(22,'Long An'),(23,'Bình Định'),(24,'Kiên Giang'),(25,'Cà Mau'),(26,'An Giang'),(27,'Tây Ninh'),(28,'Đắk Lắk'),(29,'Bình Phước'),(30,'Sóc Trăng'),(31,'Thanh Hoá'),(32,'Quảng Trị'),(33,'Bắc Ninh'),(34,'Đồng Tháp'),(35,'Vĩnh Long'),(36,'Gia Lai'),(37,'Hà Tĩnh'),(38,'Quảng Bình'),(39,'Thái Nguyên'),(40,'Bắc Giang'),(41,'Ninh Bình'),(42,'Vĩnh Phúc'),(43,'Bạc Liêu'),(44,'Bến Tre'),(45,'Trà Vinh'),(46,'Thái Bình'),(47,'Hậu Giang'),(48,'Phú Thọ'),(49,'Quảng Ngãi'),(50,'Phú Yên'),(51,'Lạng Sơn'),(52,'Đắk Nông'),(53,'Hưng Yên'),(54,'Hà Giang'),(55,'Yên Bái'),(56,'Sơn La'),(57,'Tuyên Quang'),(58,'Hòa Bình'),(59,'Hà Nam'),(60,'Điện Biên'),(61,'Cao Bằng'),(62,'Bắc Kạn'),(63,'Lai Châu');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctnghiemthu`
--

DROP TABLE IF EXISTS `ctnghiemthu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctnghiemthu` (
  `MaDT` varchar(20) NOT NULL,
  `MaHD` varchar(20) NOT NULL,
  `TongQuan` int(11) DEFAULT NULL,
  `MucTieu` int(11) DEFAULT NULL,
  `PhuongPhap` int(11) DEFAULT NULL,
  `NoiDung` int(11) DEFAULT NULL,
  `DongGop` int(11) DEFAULT NULL,
  `HinhThuc` int(11) DEFAULT NULL,
  `DiemThuong` int(11) DEFAULT NULL,
  `TongDiem` int(11) DEFAULT NULL,
  `YKien` varchar(1000) DEFAULT NULL,
  `NgayNT` date DEFAULT NULL,
  `MaTK` varchar(20) NOT NULL,
  PRIMARY KEY (`MaDT`,`MaHD`,`MaTK`),
  KEY `MaHD` (`MaHD`),
  KEY `MaTK` (`MaTK`),
  CONSTRAINT `ctnghiemthu_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `hoidong` (`MaHD`),
  CONSTRAINT `ctnghiemthu_ibfk_2` FOREIGN KEY (`MaDT`) REFERENCES `detai` (`MaDT`),
  CONSTRAINT `ctnghiemthu_ibfk_3` FOREIGN KEY (`MaTK`) REFERENCES `taikhoan` (`MaTK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctnghiemthu`
--

LOCK TABLES `ctnghiemthu` WRITE;
/*!40000 ALTER TABLE `ctnghiemthu` DISABLE KEYS */;
INSERT INTO `ctnghiemthu` VALUES ('dt15','hd2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'tk1'),('dt15','hd2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'tk7'),('dt17','hoidong69',10,15,15,36,10,10,10,101,'ok','2017-03-02','tk3'),('dt17','hoidong69',10,15,15,35,10,10,10,100,'ádá dá','2017-03-02','tk7'),('dt4','hd1',10,10,10,25,10,10,10,85,'Bài làm khá tốt','2016-10-25','tk3'),('dt4','hd1',10,10,10,20,10,10,10,80,'Bài làm khá tốt','2016-10-25','tk7'),('dt9','hd1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'tk3'),('dt9','hd1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'tk7');
/*!40000 ALTER TABLE `ctnghiemthu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detai`
--

DROP TABLE IF EXISTS `detai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detai` (
  `MaDT` varchar(20) NOT NULL,
  `MaHienThi` varchar(20) DEFAULT NULL,
  `MaTT` varchar(20) DEFAULT NULL,
  `MaCN` varchar(20) DEFAULT NULL,
  `SinhVien1` varchar(20) DEFAULT NULL,
  `SinhVien2` varchar(20) DEFAULT NULL,
  `GVHD` varchar(20) DEFAULT NULL,
  `TenDT` varchar(200) DEFAULT NULL,
  `MoTa` varchar(1000) DEFAULT NULL,
  `LinhVuc` varchar(50) DEFAULT NULL,
  `LoaiHinh` varchar(50) DEFAULT NULL,
  `NgayThucHien` date DEFAULT NULL,
  `NgayKetThuc` date DEFAULT NULL,
  `CoQuanChuTri` varchar(50) DEFAULT NULL,
  `TinhHinhTrong` varchar(200) DEFAULT NULL,
  `TinhHinhNgoai` varchar(200) DEFAULT NULL,
  `TinhCapThiet` varchar(200) DEFAULT NULL,
  `MucTieu` varchar(200) DEFAULT NULL,
  `PPNC` varchar(200) DEFAULT NULL,
  `NoiDungNC` varchar(200) DEFAULT NULL,
  `SPDuKien` varchar(200) DEFAULT NULL,
  `DiaChiUD` varchar(200) DEFAULT NULL,
  `KinhPhi` double DEFAULT NULL,
  PRIMARY KEY (`MaDT`),
  KEY `MaCN` (`MaCN`),
  KEY `GVHD` (`GVHD`),
  KEY `SinhVien1` (`SinhVien1`),
  KEY `SinhVien2` (`SinhVien2`),
  KEY `MaTT` (`MaTT`),
  CONSTRAINT `detai_ibfk_1` FOREIGN KEY (`MaCN`) REFERENCES `taikhoan` (`MaTK`),
  CONSTRAINT `detai_ibfk_2` FOREIGN KEY (`GVHD`) REFERENCES `taikhoan` (`MaTK`),
  CONSTRAINT `detai_ibfk_3` FOREIGN KEY (`SinhVien1`) REFERENCES `taikhoan` (`MaTK`),
  CONSTRAINT `detai_ibfk_4` FOREIGN KEY (`SinhVien2`) REFERENCES `taikhoan` (`MaTK`),
  CONSTRAINT `detai_ibfk_5` FOREIGN KEY (`MaTT`) REFERENCES `trangthai` (`MaTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detai`
--

LOCK TABLES `detai` WRITE;
/*!40000 ALTER TABLE `detai` DISABLE KEYS */;
INSERT INTO `detai` VALUES ('dt1','dt1','tt6','tk4','tk5','tk6','tk3','Web kinh doanh','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt10','dt10','tt3','tk5','tk4','tk6','tk1','Nghiên cứu hệ thống ss','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt11',NULL,'tt10',NULL,NULL,NULL,'tk3','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt12','dt12','tt11',NULL,NULL,NULL,'tk3','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt13','dt13','tt11',NULL,NULL,NULL,'tk1','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt14','dt14','tt11',NULL,NULL,NULL,'tk1','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt15','dt15','tt8','tk4','tk5','tk6','tk1','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt16',NULL,'tt1','tk4','tk5','tk6','tk3','Đề tài mới 2:46','Đề tài mới 2:46','Tự nhiên','Cơ bản','1990-01-01','1996-01-01','CNTT','123123','213','123123','1212312','213','12312','312','12312',321321),('dt17','dt69','tt9','tk4','tk5','tk6','tk3','Đề tài 2:54','Đề tài 2:54','Tự nhiên','Cơ bản','1996-01-01','1996-01-01','CNTT','Đề tài 2:54','Đề tài 2:54','Đề tài 2:54','Đề tài 2:54','Đề tài 2:54','Đề tài 2:54','Đề tài 2:54','Đề tài 2:54',19999),('dt18',NULL,'tt1','tk4','tk5','tk6',NULL,'Đề tài mới 2:46','asdsad','Tự nhiên','Cơ bản','1990-01-01','1996-01-01','CNTT','asf','asdsa','dsad','asds','ad','dsad','asdas','asdsa',100000),('dt2',NULL,'tt5','tk4','tk5','tk6','tk3','Web kinh doanh','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt3','dt3','tt5','tk4','tk5','tk6','tk1','Web kinh doanh','NXây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt4','dt4','tt9','tk4','tk5','tk6','tk1','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt5','dt5','tt3','tk4','tk5','tk6','tk3','Web kinh doanh','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt6','dt6','tt4','tk5','tk4','tk6','tk1','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt7','','tt3','tk5','tk4','tk6','tk1','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt8','dt8','tt7','tk5','tk4','tk6','tk3','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000),('dt9','dt9','tt8','tk5','tk4','tk6','tk3','Nghiên cứu hệ thống nhúng','Xây dựng 1 trang web giúp','Tự nhiên','Cơ bản','2016-08-08','2016-10-08','Khoa CNTT','Phát triển','Phát triển','Các cửa hàng đang rất cần có 1 trang web như vậy',NULL,NULL,NULL,NULL,NULL,2000000);
/*!40000 ALTER TABLE `detai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text COLLATE utf8_vietnamese_ci NOT NULL,
  `CITYID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=218 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,'Quận 1',1),(2,'Quận 2',1),(3,'Quận 3',1),(4,'Quận 4',1),(5,'Quận 5',1),(6,'Quận 6',1),(7,'Quận 7',1),(8,'Quận 8',1),(9,'Quận 9',1),(10,'Quận 10',1),(11,'Quận 11',1),(12,'Quận 12',1),(13,'Quận Bình Thạnh',1),(14,'Quận Tân Bình',1),(15,'Quận Phú Nhuận',1),(16,'Quận Tân Phú',1),(17,'Quận Gò Vấp',1),(18,'Quận Bình Tân',1),(19,'Quận Thủ Đức',1),(20,'Bình Chánh',1),(21,'Nhà Bè',1),(22,'Hóc Môn',1),(23,'Củ Chi',1),(24,'Cần Giờ',1),(25,'Quận Hoàn Kiếm',2),(26,'Quận Tây Hồ',2),(27,'Quận Ba Đình',2),(28,'Quận Thanh Xuân',2),(29,'Quận Hai Bà Trưng',2),(30,'Quận Đống Đa',2),(31,'Quận Cầu Giấy',2),(32,'Quận Hoàng Mai',2),(33,'Quận Long Biên',2),(34,'Quận Hà Đông',2),(35,'Quận Nam Từ Liêm',2),(36,'Quận Bắc Từ Liêm',2),(37,'Ba Vì',2),(38,'Chương Mỹ',2),(39,'Đan Phượng',2),(40,'Đông Anh',2),(41,'Gia Lâm',2),(42,'Hoài Đức',2),(43,'Mê Linh',2),(44,'Mỹ Đức',2),(45,'Phú Xuyên',2),(46,'Phúc Thọ',2),(47,'Quốc Oai',2),(48,'Sóc Sơn',2),(49,'Thạch Thất',2),(50,'Thanh Oai',2),(51,'Thanh Trì',2),(52,'Thường Tín',2),(53,'Ứng Hòa',2),(54,'Thị xã Sơn Tây',2),(55,'Hòa Vang',3),(56,'Quận Cẩm Lệ',3),(57,'Quận Liên Chiểu',3),(58,'Quận Ngũ Hành Sơn',3),(59,'Quận Sơn Trà',3),(60,'Quận Thanh Khê',3),(61,'Quận Hải Châu',3),(62,'Hoàng Sa',3),(63,'Quận Ninh Kiều',4),(64,'Quận Cái Răng',4),(65,'Quận Ô Môn',4),(66,'Quận Bình Thủy',4),(67,'Quận Thốt Nốt',4),(68,'Phong Điền',4),(69,'Hưng Phú',4),(70,'Cờ Đỏ',4),(71,'Vĩnh Thạnh',4),(72,'Thới Lai',4),(73,'Tp. Nha Trang',5),(74,'Tp. Cam Ranh',5),(75,'Vạn Ninh',5),(76,'Diên Khánh',5),(77,'Cam Lâm',5),(78,'Ninh Hòa',5),(79,'Khánh Vĩnh',5),(80,'Khánh Sơn',5),(81,'Trường Sa',5),(82,'Tp. Vũng Tàu',6),(83,'Tp. Bà Rịa',6),(84,'Huyện Tân Thành',6),(85,'Huyện Côn Đảo',6),(86,'Huyện Long Sơn',6),(87,'Huyện Xuyên Mộc',6),(88,'Huyện Long Điền',6),(89,'Huyện Châu Đức',6),(90,'Huyện Đất Đỏ',6),(91,'An Dương',7),(92,'An Lão',7),(93,'Bạch Long Vĩ',7),(94,'Cát Hải',7),(95,'Kiến Thụy',7),(96,'Quận Đồ Sơn',7),(97,'Quận Dương Kinh',7),(98,'Quận Hải An',7),(99,'Quận Hồng Bàng',7),(100,'Quận Kiến An',7),(101,'Quận Lê Chân',7),(102,'Quận Ngô Quyền',7),(103,'Thủy Nguyên',7),(104,'Tiên Lãng',7),(105,'Vĩnh Bảo',7),(106,'Đức Linh',8),(107,'Phú Quý',8),(108,'Tánh Linh',8),(109,'Tp. Phan Thiết',8),(110,'Thị xã Lagi',8),(111,'Hàm Thuận Bắc',8),(112,'Hàm Thuận Nam',8),(113,'Bắc Bình',8),(114,'Hàm Tân',8),(115,'Tuy Phong',8),(116,'Bảo Lâm',9),(117,'Cát Tiên',9),(118,'Đạ Huoai',9),(119,'Đạ Tẻh',9),(120,'Đam Rông',9),(121,'Di Linh',9),(122,'Đơn Dương',9),(123,'Đức Trọng',9),(124,'Lạc Dương',9),(125,'Lâm Hà',9),(126,'Tp. Bảo Lộc',9),(127,'Tp. Đà Lạt',9),(128,'Cẩm Mỹ',10),(129,'Định Quán',10),(130,'Long Thành',10),(131,'Nhơn Trạch',10),(132,'Tân Phú',10),(133,'Thị xã Long Khánh',10),(134,'Thống Nhất',10),(135,'Tp. Biên Hòa',10),(136,'Trảng Bom',10),(137,'Vĩnh Cửu',10),(138,'Xuân Lộc',10),(139,'Tp. Hạ Long',11),(140,'Tp. Uông Bí',11),(141,'Tp. Cẩm Phả',11),(142,'Tp. Móng Cái',11),(143,'Thị Xã Quảng Yên',11),(144,'Vân Đồn',11),(145,'Đông Triều',11),(146,'Hải Hà',11),(147,'Cô Tô',11),(148,'Ba Chẽ',11),(149,'Hoành Bồ',11),(150,'Đầm Hà',11),(151,'Bình Liêu',11),(152,'Tiên Yên',11),(153,'A Lưới',12),(154,'Hương Trà',12),(155,'Nam Đông',12),(156,'Phong Điền',12),(157,'Phú Lộc',12),(158,'Phú Vang',12),(159,'Quảng Điền',12),(160,'Thị xã Hương Thủy',12),(161,'Tp. Huế',12),(162,'Bến Cát',13),(163,'Dầu Tiếng',13),(164,'Dĩ An',13),(165,'Phú Giáo',13),(166,'Tân Uyên',13),(167,'Thị xã Thủ Dầu Một',13),(168,'Thuận An',13),(169,'Bàu Bàng',13),(170,'Bác Ái',14),(171,'Ninh Hải',14),(172,'Ninh Phước',14),(173,'Ninh Sơn',14),(174,'Thuận Bắc',14),(175,'Thuận Nam',14),(176,'Tp. Phan Rang-Tháp Chàm',14),(177,'Tp. Hải Dương',15),(178,'Thị xã Chí Linh',15),(179,'Nam Sách',15),(180,'Kinh Môn',15),(181,'Thanh Miện',15),(182,'Ninh Giang',15),(183,'Tứ Kỳ',15),(184,'Gia Lộc',15),(185,'Bình Giang',15),(186,'Cẩm Giàng',15),(187,'Kim Thành',15),(188,'Thanh Hà',15),(189,'Giao Thủy',16),(190,'Hải Hậu',16),(191,'Mỹ Lộc',16),(192,'Nam Trực',16),(193,'Nghĩa Hưng',16),(194,'Tp. Nam Định',16),(195,'Trực Ninh',16),(196,'Vụ Bản',16),(197,'Xuân Trường',16),(198,'Ý Yên',16),(199,'Cái Bè',17),(200,'Châu Thành',17),(201,'Chợ Gạo',17),(202,'Gò Công Đông',17),(203,'Gò Công Tây',17),(204,'Tân Phú Đông',17),(205,'Tân Phước',17),(206,'Thị xã Cai Lậy',17),(207,'Thị xã Gò Công',17),(208,'Tp. Mỹ Tho',17),(209,'Đắk Glei',18),(210,'Đắk Hà',18),(211,'Đắk Tô',18),(212,'Kon Plông',18),(213,'Kon Rẫy',18),(214,'Ngọc Hồi',18),(215,'Sa Thầy',18),(216,'Tp. Kon Tum',18),(217,'Tu Mơ Rông',18);
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dongiahan`
--

DROP TABLE IF EXISTS `dongiahan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dongiahan` (
  `MaDonXin` varchar(20) NOT NULL,
  `MaDT` varchar(20) DEFAULT NULL,
  `GHDen` date DEFAULT NULL,
  `LyDo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MaDonXin`),
  KEY `MaDT` (`MaDT`),
  CONSTRAINT `dongiahan_ibfk_1` FOREIGN KEY (`MaDT`) REFERENCES `detai` (`MaDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dongiahan`
--

LOCK TABLES `dongiahan` WRITE;
/*!40000 ALTER TABLE `dongiahan` DISABLE KEYS */;
INSERT INTO `dongiahan` VALUES ('dgh1','dt1','2016-12-08','Lý do gia đình');
/*!40000 ALTER TABLE `dongiahan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhuy`
--

DROP TABLE IF EXISTS `donhuy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donhuy` (
  `MaDonXin` varchar(20) NOT NULL,
  `MaDT` varchar(20) DEFAULT NULL,
  `LyDo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MaDonXin`),
  KEY `MaDT` (`MaDT`),
  CONSTRAINT `donhuy_ibfk_1` FOREIGN KEY (`MaDT`) REFERENCES `detai` (`MaDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhuy`
--

LOCK TABLES `donhuy` WRITE;
/*!40000 ALTER TABLE `donhuy` DISABLE KEYS */;
INSERT INTO `donhuy` VALUES ('dhuy1','dt6','Lý do gia đình');
/*!40000 ALTER TABLE `donhuy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoidong`
--

DROP TABLE IF EXISTS `hoidong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoidong` (
  `MaHD` varchar(20) NOT NULL,
  `PhanBien` varchar(20) DEFAULT NULL,
  `ChuTich` varchar(20) DEFAULT NULL,
  `UyVien` varchar(20) DEFAULT NULL,
  `NgayThanhLap` date DEFAULT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `PhanBien` (`PhanBien`),
  KEY `ChuTich` (`ChuTich`),
  KEY `UyVien` (`UyVien`),
  CONSTRAINT `hoidong_ibfk_1` FOREIGN KEY (`PhanBien`) REFERENCES `taikhoan` (`MaTK`),
  CONSTRAINT `hoidong_ibfk_2` FOREIGN KEY (`ChuTich`) REFERENCES `taikhoan` (`MaTK`),
  CONSTRAINT `hoidong_ibfk_3` FOREIGN KEY (`UyVien`) REFERENCES `taikhoan` (`MaTK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoidong`
--

LOCK TABLES `hoidong` WRITE;
/*!40000 ALTER TABLE `hoidong` DISABLE KEYS */;
INSERT INTO `hoidong` VALUES ('hd1','tk3','tk7',NULL,'2016-10-10'),('hd2','tk1','tk7',NULL,'2016-10-10'),('hoidong69','tk7','tk3','tk1','2017-03-02');
/*!40000 ALTER TABLE `hoidong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaitb`
--

DROP TABLE IF EXISTS `loaitb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loaitb` (
  `MaLTB` varchar(20) NOT NULL,
  `TenLoaiTB` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaLTB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaitb`
--

LOCK TABLES `loaitb` WRITE;
/*!40000 ALTER TABLE `loaitb` DISABLE KEYS */;
INSERT INTO `loaitb` VALUES ('ltt1','Thông báo bình thường'),('ltt2','Thông báo đăng ký đề tài'),('ltt3','Thông báo hủy đề tài'),('ltt4','Thông báo gia hạn đề tài');
/*!40000 ALTER TABLE `loaitb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `street` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text COLLATE utf8_vietnamese_ci,
  `CITYID` int(11) DEFAULT NULL,
  `DISTRICTID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
INSERT INTO `street` VALUES (1,'Bà Lê Chân',1,1),(2,'Bến Chương Dương',1,1),(3,'Bến Nghé',1,1),(4,'Bùi Thị Xuân',1,1),(5,'Bùi Viện',1,1),(6,'Cách Mạng Tháng 8',1,1),(7,'Calmette',1,1),(8,'Cao Bá Nhạ',1,1),(9,'Cao Bá Quát',1,1),(10,'Chu Mạnh Trinh',1,1),(11,'Cô Bắc',1,1),(12,'Cô Giang',1,1),(13,'Cống Quỳnh',1,1),(14,'Công Trường Lam Sơn',1,1),(15,'Công Trường Mê Linh',1,1),(16,'Công Xã Paris',1,1),(17,'An Phú',1,2),(18,'Cát Lái',1,2),(19,'Cầu Phú Mỹ',1,2),(20,'Cây Bàng',1,2),(21,'Đại Lộ Đông Tây',1,2),(22,'Đỗ Xuân Hợp',1,2),(23,'Đồng Văn Cống',1,2),(24,'Đường 19',1,2),(25,'Bà Huyện Thanh QUan',1,3),(26,'Bàn Cờ',1,3),(27,'Cách Mạng Tháng 8',1,3);
/*!40000 ALTER TABLE `street` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taikhoan` (
  `MaTK` varchar(20) NOT NULL,
  `MatKhau` varchar(50) DEFAULT NULL,
  `Quyen` varchar(50) DEFAULT NULL,
  `HoTen` varchar(50) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `Nganh` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `HinhAnh` varchar(100) DEFAULT NULL,
  `MSNH` varchar(20) DEFAULT NULL,
  `CNNH` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaTK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('tk1','e10adc3949ba59abbe56e057f20f883e','Manager','Trương Thành Tín','1996-10-11','CNTT','tin@gmail.com',NULL,'123','BIDV'),('tk14','e10adc3949ba59abbe56e057f20f883e','Manager','<script>alert(\"Hell!box!!\")</script>','1996-04-04','BCCC','avc@gmail.com',NULL,NULL,'VCB'),('tk3','e10adc3949ba59abbe56e057f20f883e','Lecturers','','1996-10-11','CNTT','lxtriet@gmail.com',NULL,'123','BIDV'),('tk4','e10adc3949ba59abbe56e057f20f883e','Student','Lê Thị Thảo','1996-10-11','CNTT','ltthao@gmail.com',NULL,'123','BIDV'),('tk5','e10adc3949ba59abbe56e057f20f883e','Student','Lâm Siêu Vồn','1996-10-11','CNTT','lsvon@gmail.com',NULL,'123','BIDV'),('tk6','e10adc3949ba59abbe56e057f20f883e','Student','Lâm Siêu Nhân','1996-10-11','CNTT','lsnhan@gmail.com',NULL,'123','BIDV'),('tk69','e10adc3949ba59abbe56e057f20f883e','Admin','Lê Thu','1996-01-09','CNTT','thang@gmail.com',NULL,NULL,NULL),('tk7','e10adc3949ba59abbe56e057f20f883e','Lecturers','Trần Thị Lý','1996-10-11','CNTT','Ly@gmail.com',NULL,'123','BIDV');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tk`
--

DROP TABLE IF EXISTS `tb_tk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tk` (
  `MaCTTB` varchar(20) NOT NULL,
  `MaTB` varchar(20) DEFAULT NULL,
  `MaLTB` varchar(20) DEFAULT NULL,
  `TinTB` varchar(100) DEFAULT NULL,
  `NgayGui` date DEFAULT NULL,
  PRIMARY KEY (`MaCTTB`),
  KEY `MaLTB` (`MaLTB`),
  KEY `MaTB` (`MaTB`),
  CONSTRAINT `tb_tk_ibfk_1` FOREIGN KEY (`MaLTB`) REFERENCES `loaitb` (`MaLTB`),
  CONSTRAINT `tb_tk_ibfk_2` FOREIGN KEY (`MaTB`) REFERENCES `thongbao` (`MaTB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tk`
--

LOCK TABLES `tb_tk` WRITE;
/*!40000 ALTER TABLE `tb_tk` DISABLE KEYS */;
INSERT INTO `tb_tk` VALUES ('cttb10','tb4','ltt1','Thông báo đề tài đăng ký thành công','2016-12-06'),('cttb11','tb5','ltt2','Thông báo đăng ký đề tài mới','2016-11-01'),('cttb15','tb8','ltt1','Thông báo đăng ký thành công đề tài dt17','2017-03-02'),('cttb16','tb8','ltt1','Thống báo đề tài dt17 đã có kết quả thu','2017-03-02'),('cttb17','tb9','ltt1','Thống báo đề tài dt17 đã có kết quả thu','2017-03-02'),('cttb2','tb1','ltt2','Thông báo đăng ký đề tài mới','2016-11-01'),('cttb3','tb2','ltt1','Thông báo đề tài hủy thành công','2016-11-01'),('cttb4','tb2','ltt1','Thông báo đề tài đã được nghiệm thu','2016-11-01'),('cttb5','tb2','ltt1','Thông báo đề tài đăng ký thành công','2016-11-01'),('cttb6','tb3','ltt3','Thông báo có yêu cầu hủy đề tài','2016-10-16'),('cttb7','tb3','ltt2','Thông báo đăng ký đề tài mới','2016-11-01'),('cttb8','tb4','ltt1','Thông báo đề tài gia hạn thành công','2016-10-05'),('cttb9','tb4','ltt1','Thông báo đề tài đang trong thời gian nghiệm thu','2016-11-01');
/*!40000 ALTER TABLE `tb_tk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongbao`
--

DROP TABLE IF EXISTS `thongbao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thongbao` (
  `MaTB` varchar(20) NOT NULL,
  `NguoiGui` varchar(20) DEFAULT NULL,
  `NguoiNhan` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`MaTB`),
  KEY `NguoiGui` (`NguoiGui`),
  KEY `NguoiNhan` (`NguoiNhan`),
  CONSTRAINT `thongbao_ibfk_1` FOREIGN KEY (`NguoiGui`) REFERENCES `taikhoan` (`MaTK`),
  CONSTRAINT `thongbao_ibfk_2` FOREIGN KEY (`NguoiNhan`) REFERENCES `taikhoan` (`MaTK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongbao`
--

LOCK TABLES `thongbao` WRITE;
/*!40000 ALTER TABLE `thongbao` DISABLE KEYS */;
INSERT INTO `thongbao` VALUES ('tb1','tk4','tk1'),('tb2','tk1','tk4'),('tb3','tk5','tk1'),('tb4','tk1','tk5'),('tb5','tk3','tk1'),('tb6','tk1','tk3'),('tb7','tk1','tk1'),('tb8','tk3','tk4'),('tb9','tk7','tk4');
/*!40000 ALTER TABLE `thongbao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trangthai`
--

DROP TABLE IF EXISTS `trangthai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trangthai` (
  `MaTT` varchar(20) NOT NULL,
  `TenTT` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trangthai`
--

LOCK TABLES `trangthai` WRITE;
/*!40000 ALTER TABLE `trangthai` DISABLE KEYS */;
INSERT INTO `trangthai` VALUES ('tt1','Chưa duyệt'),('tt10','Chờ phê duyệt'),('tt11','Đăng ký thành công'),('tt2','Quản lý duyệt'),('tt3','Đang tiến hành'),('tt4','Chờ duyệt hủy'),('tt5','Đã hủy'),('tt6','Chờ duyệt gia hạn'),('tt7','Đang gia hạn'),('tt8','Đang nghiệm thu'),('tt9','Đã nghiệm thu');
/*!40000 ALTER TABLE `trangthai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text COLLATE utf8_vietnamese_ci,
  `IMG` text COLLATE utf8_vietnamese_ci,
  `CATEGORYID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (232,'Sang trọng','1.png',1),(233,'Buffet','2.png',1),(234,'Nhà hàng','3.png',1),(235,'Ăn vặt/vỉa hè','4.png',1),(236,'Ăn chay','5.png',1),(237,'Café/Dessert','6.png',1),(238,'Quán ăn','7.png',1),(239,'Bar/Pub','8.png',1),(240,'Quán nhậu','9.png',1),(241,'Beer club','10.png',1),(242,'Tiệm bánh','11.png',1),(243,'Tiệc tận nơi','12.png',1),(244,'Shop Online','13.png',1),(245,'Giao cơm văn phòng','14.png',1),(246,'Khu Ẩm Thực','15.png',1),(247,'Thăm quan & chụp ảnh','16.png',2),(248,'Khách sạn','17.png',2),(249,'Khu nghỉ dưỡng','18.png',2),(250,'Du lịch sinh thái','19.png',2),(251,'Tàu du lịch','20.png',2),(252,'Công viên vui chơi','21.png',2),(253,'Bảo tàng & Di tích','22.png',2),(254,'Chùa & Nhà thờ','23.png',2),(255,'Phòng Vé Máy Bay','24.png',2),(256,'Phương Tiện - Xe Cộ','25.png',2),(257,'Homestay','26.png',2),(258,'Căn hộ','27.png',2),(259,'Nhà nghỉ','28.png',2),(260,'Hãng Du Lịch','29.png',2),(261,'Tiệc cưới/Hội nghị','30.png',3),(262,'Chụp hình cưới','31.png',3),(263,'Trang điểm','32.png',3),(264,'Áo cưới','33.png',3),(265,'Hoa cưới - Shop hoa','34.png',3),(266,'Tiệc tại gia','35.png',3),(267,'Spa/Massage','36.png',4),(268,'Làm tóc/Gội đầu/Nối mi','37.png',4),(269,'Thể dục thẩm mỹ','38.png',4),(270,'Tiệm nail','39.png',4),(271,'Chăm sóc da','40.png',4),(272,'Shop hóa mỹ phẩm','41.png',4),(273,'Thể dục thể thao','42.png',4),(274,'Thẩm mỹ viện','43.png',4),(275,'Xăm hình','44.png',4),(276,'Phòng khám','45.png',4),(277,'Nha khoa','46.png',4),(278,'Nhà thuốc','47.png',4),(279,'Bệnh viện','48.png',4),(280,'Karaoke','49.png',5),(281,'Billiards','50.png',5),(282,'Rạp chiếu phim','51.png',5),(283,'Sân khấu','52.png',5),(284,'Khu chơi Game','53.png',5),(285,'Shop/Cửa hàng','54.png',6),(286,'Siêu thị','55.png',6),(287,'Trung tâm thương mại','56.png',6),(288,'Chợ','57.png',6),(289,'Mua sắm Online','58.png',6),(290,'Đại Học & Cao Đẳng','59.png',7),(291,'Trung tâm giáo dục','60.png',7),(292,'Trung tâm ngoại ngữ','61.png',7),(293,'Nhà sách & Thư viện','62.png',7),(294,'Nhà trẻ & Mẫu giáo','63.png',7),(295,'Trung học & Phổ Thông','64.png',7),(296,'Trường dạy nghề','65.png',7),(297,'Bank - ATM','66.png',8),(298,'Trạm xăng','67.png',8),(299,'Viễn thông','68.png',8),(300,'Vận tải','69.png',8),(301,'Giặt ủi','70.png',8),(302,'Vật nuôi','71.png',8),(303,'Trụ Sở Ban Ngành','72.png',8),(304,'Dịch Vụ Vệ Sinh','73.png',8),(305,'Dịch Vụ Sửa Chữa Nhà Cửa','74.png',8),(306,'Dịch Vụ Vận Chuyển Đồ Đạc','75.png',8);
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-20  1:40:14
