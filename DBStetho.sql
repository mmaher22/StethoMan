-- phpMyAdmin SQL Dump
-- version 3.5.8.2
-- http://www.phpmyadmin.net
--
-- Host: sql103.byetcluster.com
-- Generation Time: Dec 16, 2016 at 12:47 AM
-- Server version: 5.6.34-79.1
-- PHP Version: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `eb2a_19296533_StethoMan`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `DoctorID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Mail` varchar(100) NOT NULL,
  `Password` varchar(16) CHARACTER SET ascii NOT NULL,
  `Mobile` int(11) NOT NULL,
  `Review` float NOT NULL,
  `ImgURL` varchar(200) NOT NULL,
  `Specialization` text NOT NULL,
  `Fees` int(11) NOT NULL,
  `Education` text NOT NULL,
  PRIMARY KEY (`DoctorID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=201301112 ;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`DoctorID`, `Name`, `Mail`, `Password`, `Mobile`, `Review`, `ImgURL`, `Specialization`, `Fees`, `Education`) VALUES
(201301111, 'Try Doctor', 'try_doctor@gmail.com', 'PASSWORD', 1123456789, 4, 'Ay7aga', 'Expert', 2500, 'PHD');

-- --------------------------------------------------------

--
-- Table structure for table `lab`
--

CREATE TABLE IF NOT EXISTS `lab` (
  `LabID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) CHARACTER SET latin1 NOT NULL,
  `Results` varchar(1000) NOT NULL,
  `ImgURL` varchar(200) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PatientID` int(11) NOT NULL,
  PRIMARY KEY (`LabID`),
  KEY `PatientID` (`PatientID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE IF NOT EXISTS `manager` (
  `ManagerID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Mail` varchar(100) NOT NULL,
  `Password` int(16) NOT NULL,
  `Mobile` int(11) NOT NULL,
  PRIMARY KEY (`ManagerID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`ManagerID`, `Name`, `Mail`, `Password`, `Mobile`) VALUES
(1, 'Maher', 'm.maher525@gmail.com', 201301463, 1141763525);

-- --------------------------------------------------------

--
-- Table structure for table `medication`
--

CREATE TABLE IF NOT EXISTS `medication` (
  `MedicationID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Start Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Period` int(11) NOT NULL COMMENT 'in Hours',
  `Number of Times` int(11) NOT NULL,
  `Instructions` text NOT NULL,
  `DoctorID` int(11) NOT NULL,
  `PatientID` int(11) NOT NULL,
  PRIMARY KEY (`MedicationID`),
  KEY `DoctorID` (`DoctorID`,`PatientID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `toid` varchar(9) CHARACTER SET latin1 NOT NULL,
  `fromid` varchar(9) CHARACTER SET latin1 NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` varchar(2000) NOT NULL,
  `isread` tinyint(1) NOT NULL DEFAULT '0',
  KEY `toid` (`toid`),
  KEY `fromid` (`fromid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `PatientID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Mail` varchar(100) NOT NULL,
  `Password` varchar(16) CHARACTER SET ascii NOT NULL,
  `Mobile` int(1) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `ImgURL` varchar(200) NOT NULL,
  `Blood` varchar(3) CHARACTER SET latin1 NOT NULL,
  `Chronic Diseases` text CHARACTER SET latin1 NOT NULL,
  `setPass` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`PatientID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE IF NOT EXISTS `report` (
  `ReportID` int(11) NOT NULL AUTO_INCREMENT,
  `DoctorID` int(11) NOT NULL,
  `PatientID` int(11) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Title` varchar(200) NOT NULL,
  `Specialization` text NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`ReportID`),
  KEY `DoctorID` (`DoctorID`,`PatientID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE IF NOT EXISTS `review` (
  `PatientID` int(11) NOT NULL,
  `DoctorID` int(11) NOT NULL,
  `Review` int(11) NOT NULL,
  KEY `PatientID` (`PatientID`,`DoctorID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `timeslot`
--

CREATE TABLE IF NOT EXISTS `timeslot` (
  `SlotID` int(11) NOT NULL AUTO_INCREMENT,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DoctorID` int(11) NOT NULL,
  `MaxPatients` int(11) NOT NULL,
  `Isavailable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`SlotID`),
  KEY `DoctorID` (`DoctorID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `visit`
--

CREATE TABLE IF NOT EXISTS `visit` (
  `PatientID` int(11) NOT NULL,
  `VisitID` int(11) NOT NULL,
  `Isconfirmed` tinyint(1) NOT NULL DEFAULT '0',
  KEY `PatientID` (`PatientID`,`VisitID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
