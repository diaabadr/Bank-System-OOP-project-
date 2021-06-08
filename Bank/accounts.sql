-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2021 at 01:54 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `accounts`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `numOfaccounts` int(14) NOT NULL,
  `ID` varchar(20) DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `clientName` varchar(45) DEFAULT NULL,
  `accountType` varchar(30) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `indebtedness` double DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `allowableLimit_perDay` double DEFAULT NULL,
  `creatingDate` date DEFAULT NULL,
  `creditCardDate` date DEFAULT NULL,
  `debitDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`numOfaccounts`, `ID`, `userName`, `password`, `clientName`, `accountType`, `balance`, `indebtedness`, `status`, `allowableLimit_perDay`, `creatingDate`, `creditCardDate`, `debitDate`) VALUES
(1, '20210608001', 'diaabadr21', '123456', 'Diaa Badr Eldin', 'VIP', 140000, 0, 0, 0, '2021-06-08', '2021-06-06', '2021-06-08'),
(2, '20210408002', 'mosalah23', '123456', 'Mohamed Salah', 'Personal', 0, 4400, 1, 8000, '2021-04-08', '2021-05-08', '2021-05-15'),
(3, '20210608003', 'abdo123', '123456789', 'Abdelrahman Saeed', 'Personal', 6000, 0, 0, 8000, '2021-06-08', '2021-06-08', '2021-06-08'),
(4, '20210108004', 'mohamednasser12', '12345678', 'Mohamed Nasser', 'VIP', 0, 9900, 1, 20000, '2021-01-08', '2021-06-08', '2021-02-07'),
(5, '20210608005', 'dreman123', '202106', 'Dr Eman Marzban', 'VIP', 200000, 0, 0, 20000, '2021-06-08', '2021-06-08', '2021-06-08'),
(6, '20210608006', 'engmohamed53', 'mo123456', 'eng Mohamed Mostafa', 'VIP', 160000, 0, 0, 20000, '2021-06-08', '2021-06-08', '2021-06-08'),
(7, '20200308007', 'shehab123', 'sh1234', 'Shehab Mohamed', 'Personal', 0, 1000, 1, 8000, '2020-03-08', '2021-06-08', '2021-04-02'),
(8, '20210608008', 'radwan23', 'rad123', 'Ahmed Radwan', 'Personal', 6000, 0, 0, 8000, '2021-06-08', '2021-06-08', '2021-06-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`numOfaccounts`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `numOfaccounts` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
