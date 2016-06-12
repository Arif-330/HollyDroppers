-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 23, 2014 at 11:03 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hollydropersdata`
--

-- --------------------------------------------------------

--
-- Table structure for table `dropped_course`
--

CREATE TABLE IF NOT EXISTS `dropped_course` (
  `serial` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(4) NOT NULL,
  `semester` int(2) NOT NULL,
  `code` varchar(10) NOT NULL,
  `title` varchar(100) NOT NULL,
  `credit` float NOT NULL,
  PRIMARY KEY (`year`,`semester`,`title`,`credit`,`serial`),
  UNIQUE KEY `serial` (`serial`,`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `dropped_course`
--

INSERT INTO `dropped_course` (`serial`, `year`, `semester`, `code`, `title`, `credit`) VALUES
(7, 1, 1, 'MAT102D', 'Matrices, Vector Analysis and Geometry', 4),
(12, 1, 2, 'CSE100', 'Project Work100', 1),
(13, 1, 2, 'CSE137', 'Data Structure', 3),
(14, 1, 2, 'CSE138', 'Data Structure Lab', 2),
(15, 1, 2, 'EEE203Q', 'Electronic Devices & Circuits', 3),
(16, 1, 2, 'EEE204Q', 'Electronics Devices and Circuits Lab', 1.5),
(17, 1, 2, 'IPE106', 'Engineering Graphics', 1),
(18, 1, 2, 'IPE108', 'workshop Practice', 1),
(21, 2, 1, 'EEE201Q', 'Digital Logic Design', 3),
(29, 2, 2, 'CSE200', 'Project Work200', 1),
(32, 2, 2, 'CSE239', 'Numerical Analysis', 2),
(34, 2, 1, 'CSE243', 'Theory of Computation and Concrete Mathmatics ', 3),
(36, 2, 2, 'MAT204D', 'Complex Variables , Laplace Transform and Fourier Series', 4),
(45, 3, 1, 'CSE368', 'Microprocessor & Interfacing Lab', 1.5);

-- --------------------------------------------------------

--
-- Table structure for table `passed_course`
--

CREATE TABLE IF NOT EXISTS `passed_course` (
  `serial` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(4) NOT NULL,
  `semester` int(2) NOT NULL,
  `code` varchar(10) NOT NULL,
  `title` varchar(100) NOT NULL,
  `credit` float NOT NULL,
  `cgpa` varchar(10) NOT NULL,
  PRIMARY KEY (`year`,`semester`,`code`,`title`,`credit`,`serial`),
  UNIQUE KEY `serial` (`serial`),
  KEY `title` (`title`),
  KEY `credit` (`credit`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Dumping data for table `passed_course`
--

INSERT INTO `passed_course` (`serial`, `year`, `semester`, `code`, `title`, `credit`, `cgpa`) VALUES
(1, 1, 1, 'CSE133', 'Structured Programming Language', 3, 'C'),
(2, 1, 1, 'CSE134', 'Structured Programming Language Lab', 3, 'C-'),
(3, 1, 1, 'CSE143', 'Discrete Mathmatics ', 3, 'C-'),
(4, 1, 1, 'CSE144', 'Discrete Mathmatics Lab ', 1.5, 'C'),
(5, 1, 1, 'EEE109Q', 'Electrical Circuits', 3, 'C'),
(6, 1, 1, 'EEE110Q', 'Electrical Circuits Lab', 1.5, 'B-'),
(8, 1, 1, 'ENG101', 'English Language I', 2, 'B-'),
(9, 1, 1, 'ENG102', 'English Language I Lab ', 1, 'B+'),
(19, 1, 2, 'PHY103E', 'Mechanics ,Wave,Heat and thermodynamics', 3, 'B-'),
(23, 2, 1, 'CSE237', 'Algorithm Design & Analysis', 3, 'C+'),
(24, 2, 1, 'CSE238', 'Algorithm Design & Analysis lab', 1.5, 'C-'),
(22, 2, 1, 'EEE202Q', 'Digital Logic Design Lab', 2, 'B-'),
(26, 2, 1, 'PHY207', 'Electromagnetism, Optics and Modern Physics', 3, 'C-'),
(27, 2, 1, 'PHy222B', 'Basic Physics Lab ', 1.5, 'C+'),
(28, 2, 1, 'STA202', 'Basic Statistics and Probability', 4, 'B-'),
(30, 2, 2, 'CSE233', 'Object Oriented and Programming Language', 3, 'A-'),
(33, 2, 2, 'CSE240', 'Numericla Analysis Lab', 1.5, 'B+');

-- --------------------------------------------------------

--
-- Table structure for table `subjecttable`
--

CREATE TABLE IF NOT EXISTS `subjecttable` (
  `serial` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(4) NOT NULL,
  `semester` int(2) NOT NULL,
  `code` varchar(10) NOT NULL,
  `title` varchar(100) NOT NULL,
  `credit` float NOT NULL,
  PRIMARY KEY (`serial`,`year`,`semester`,`code`,`title`,`credit`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=70 ;

--
-- Dumping data for table `subjecttable`
--

INSERT INTO `subjecttable` (`serial`, `year`, `semester`, `code`, `title`, `credit`) VALUES
(1, 1, 1, 'CSE133', 'Structured Programming Language', 3),
(2, 1, 1, 'CSE134', 'Structured Programming Language Lab', 3),
(3, 1, 1, 'CSE143', 'Discrete Mathmatics ', 3),
(4, 1, 1, 'CSE144', 'Discrete Mathmatics Lab ', 1.5),
(5, 1, 1, 'EEE109Q', 'Electrical Circuits', 3),
(6, 1, 1, 'EEE110Q', 'Electrical Circuits Lab', 1.5),
(7, 1, 1, 'MAT102D', 'Matrices, Vector Analysis and Geometry', 4),
(8, 1, 1, 'ENG101', 'English Language I', 2),
(9, 1, 1, 'ENG102', 'English Language I Lab ', 1),
(12, 1, 2, 'CSE100', 'Project Work100', 1),
(13, 1, 2, 'CSE137', 'Data Structure', 3),
(14, 1, 2, 'CSE138', 'Data Structure Lab', 2),
(15, 1, 2, 'EEE203Q', 'Electronic Devices & Circuits', 3),
(16, 1, 2, 'EEE204Q', 'Electronics Devices and Circuits Lab', 1.5),
(17, 1, 2, 'IPE106', 'Engineering Graphics', 1),
(18, 1, 2, 'IPE108', 'workshop Practice', 1),
(19, 1, 2, 'PHY103E', 'Mechanics ,Wave,Heat and thermodynamics', 3),
(20, 1, 2, 'MAT103D', 'Calculus', 4),
(21, 2, 1, 'EEE201Q', 'Digital Logic Design', 3),
(22, 2, 1, 'EEE202Q', 'Digital Logic Design Lab', 2),
(23, 2, 1, 'CSE237', 'Algorithm Design & Analysis', 3),
(24, 2, 1, 'CSE238', 'Algorithm Design & Analysis lab', 1.5),
(25, 2, 1, 'BAN243', 'Cost and Management Accounting ', 3),
(26, 2, 1, 'PHY207', 'Electromagnetism, Optics and Modern Physics', 3),
(27, 2, 1, 'PHy222B', 'Basic Physics Lab ', 1.5),
(28, 2, 1, 'STA202', 'Basic Statistics and Probability', 4),
(29, 2, 2, 'CSE200', 'Project Work200', 1),
(30, 2, 2, 'CSE233', 'Object Oriented and Programming Language', 3),
(31, 2, 2, 'CSE234', 'Object Oriented Programming Language Lab ', 3),
(32, 2, 2, 'CSE239', 'Numerical Analysis', 2),
(33, 2, 2, 'CSE240', 'Numericla Analysis Lab', 1.5),
(34, 2, 1, 'CSE243', 'Theory of Computation and Concrete Mathmatics ', 3),
(35, 2, 2, 'ECO103', 'Principles Of Economics ', 4),
(36, 2, 2, 'MAT204D', 'Complex Variables , Laplace Transform and Fourier Series', 4),
(37, 3, 1, 'CSE333', 'Database System', 3),
(38, 3, 1, 'CSE334', 'Database System Lab', 3),
(39, 3, 1, 'CSE335', 'Operating System and System Programming ', 3),
(40, 3, 1, 'CSE336', 'Operating System and System Programming Lab', 1.5),
(41, 3, 1, 'CSE351', 'Management Information Systems', 3),
(42, 3, 1, 'CSE365', 'Communication Engineering ', 3),
(43, 3, 1, 'CSE366', 'Communication Engineering Lab', 1.5),
(44, 3, 1, 'CSE367', 'Microprocessor & Interfacing ', 3),
(45, 3, 1, 'CSE368', 'Microprocessor & Interfacing Lab', 1.5),
(46, 3, 2, 'CSE300', 'Projrct Work & Seminar300', 2),
(47, 3, 2, 'CSE329', 'Computer Architecture ', 3),
(48, 3, 2, 'CSE331', 'Software Engineering ', 3),
(49, 3, 2, 'CSE332', 'Software Engineering Lab', 1.5),
(50, 3, 2, 'CSE361', 'Computer Networking ', 3),
(51, 3, 2, 'CSE362', 'Computer Networking Lab', 1.5),
(52, 3, 2, 'CSE373', 'Computer Graphics & Image Processing ', 3),
(53, 3, 2, 'CSE374', 'Computer Graphics & Image processing Lab', 1.5),
(54, 3, 2, 'CSE375', 'Technical Writing and Presentation ', 2),
(55, 4, 1, 'CSE400', 'Project400', 2),
(56, 4, 1, 'CSE433', 'Artificial Intelligence', 3),
(57, 4, 1, 'CSE434', 'Artificial Intelligence Lab', 1.5),
(58, 4, 1, 'CSE439', 'Compiler Construction ', 3),
(59, 4, 1, 'CSE440', 'Compiler Construction Lab', 1.5),
(60, 4, 1, 'CSE445', 'Web Engineering ', 2),
(61, 4, 1, 'CSE446', 'Web Engineering Lab', 1.5),
(62, 4, 1, 'CSE4**', 'Option I', 3),
(63, 4, 1, 'CSE4**', 'Option I Lab', 1.5),
(64, 4, 2, 'CSE406', 'Viva Voce', 1),
(65, 4, 2, 'CSE408', 'Project', 4),
(66, 4, 2, 'CSE425', 'Digital Signal Processing ', 3),
(67, 4, 2, 'CSE426', 'Digital Signal Processing Lab', 1.5),
(68, 4, 2, 'CSE4**', 'Option II', 3),
(69, 4, 2, 'CSE4**', 'Option II Lab', 1.5);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
