-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2021 at 08:53 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

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
(1, '20210605001', 'mohamed salah', '1732002', 'mohamed salah', 'VIP', 199000, 0, 0, 20000, '2021-06-05', '2021-06-05', '2021-06-05'),
(5, '20210605005', 'diaa', '2022', 'diaa', 'Personal', 10000, 0, 0, 3000, '2021-06-05', '2021-06-06', '2021-06-05'),
(6, '20210606006', 'm', 'm', 'm', 'Personal', 4000, 0, 0, 8000, '2021-06-06', '2021-06-06', '2021-06-06'),
(7, '20210606007', 'abdo', '2021', 'abdo', 'VIP', 4000, 0, 0, 8000, '2021-06-06', '2021-06-06', '2021-06-06'),
(8, '20210606008', 'naser', '2025', 'naser', 'Personal', 900, 0, 0, 7000, '2021-06-06', '2021-06-06', '2021-06-06'),
(9, '20210606009', 'welcome', 'welcome', 'welcome', 'Personal', 1000, 0, 0, 8000, '2021-06-06', '2021-06-06', '2021-06-06');

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
  MODIFY `numOfaccounts` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;


--
-- Metadata
--
USE `phpmyadmin`;

--
-- Metadata for table accounts
--
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
