-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2022 at 10:14 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kursinis`
--

-- --------------------------------------------------------

--
-- Table structure for table `cargo`
--

CREATE TABLE `cargo` (
  `cargoId` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `orderId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cargo`
--

INSERT INTO `cargo` (`cargoId`, `type`, `orderId`) VALUES
(7, 'dwdw', 3),
(9, 'aaa', 7),
(14, 'io', 9);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL,
  `text` text NOT NULL,
  `forumId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `destination`
--

CREATE TABLE `destination` (
  `id` int(5) NOT NULL,
  `PickupDestinationAddress` varchar(100) NOT NULL,
  `PickUpDestinationDate` varchar(100) NOT NULL,
  `FinalDestinationDate` varchar(100) NOT NULL,
  `FinalDestinationAddress` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destination`
--

INSERT INTO `destination` (`id`, `PickupDestinationAddress`, `PickUpDestinationDate`, `FinalDestinationDate`, `FinalDestinationAddress`) VALUES
(11, 'aa', 'aa', 'aa', 'aa'),
(13, 'dd', 'dd', 'dd', 'dd'),
(16, 'tyjtryj', 'tryjrtyjrtyj', 'rtyjrtyjrtyj', 'tryjrtyj'),
(20, 'ss', 'tryjrtyj', 'rtyjrtyjrtyj', 'tryjrtyjrtyj'),
(21, 'sss', 'tryjrtyj', 'rtyjrtyjrtyj', 'tryjrtyjrtyj'),
(22, 'dsdsd', 'tryjrtyj', 'rtyjrtyjrtyj', 'tryjrtyjrtyj'),
(26, 'dddd', 'dddd', 'dddd', 'dddd');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `userId` int(11) NOT NULL,
  `healthProofEndDate` varchar(100) NOT NULL,
  `driverLicenceEndDate` varchar(100) NOT NULL,
  `managerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`userId`, `healthProofEndDate`, `driverLicenceEndDate`, `managerId`) VALUES
(2, 'w', 'w', 1),
(4, 'q', 'q', 1);

-- --------------------------------------------------------

--
-- Table structure for table `forum`
--

CREATE TABLE `forum` (
  `forumId` int(11) NOT NULL,
  `forumTopic` varchar(10000) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `licence`
--

CREATE TABLE `licence` (
  `licenceId` int(11) NOT NULL,
  `dateEnding` varchar(100) NOT NULL,
  `dateAcquireq` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `userId` int(11) NOT NULL,
  `managedDrivers` int(4) NOT NULL,
  `company` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`userId`, `managedDrivers`, `company`) VALUES
(1, 0, 'asdasd');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `orderId` int(11) NOT NULL,
  `route` varchar(100) NOT NULL,
  `cargoId` int(11) NOT NULL,
  `destinationId` int(11) NOT NULL,
  `driverId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`orderId`, `route`, `cargoId`, `destinationId`, `driverId`) VALUES
(3, 'b', 5, 13, 4),
(4, 'fgh', 5, 11, 2),
(5, 'fhn', 5, 16, 4),
(7, 'l', 5, 11, 4),
(9, 'ww', 5, 11, 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phoneNumber` varchar(150) NOT NULL,
  `emailAddress` varchar(100) NOT NULL,
  `birthDay` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `isRetired` int(2) NOT NULL,
  `salary` int(8) NOT NULL,
  `currency` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `name`, `phoneNumber`, `emailAddress`, `birthDay`, `username`, `password`, `isRetired`, `salary`, `currency`) VALUES
(1, 'a', '5', 'a', 'a', 'a', 'a', 0, 0, ' '),
(2, 'aa', 'aa', 'aa', 'aa', 'aa', 'aa', 0, 0, ' '),
(3, 'asdsad', 'asdasd', 'asdasd', 'asdaasd', 'asdd', 'asd', 0, 1, 'a'),
(4, 'sssssss', 'q', 'q', 'q', 'q', 'q', 0, 4, 'q'),
(6, 'asd', '0', ' ', ' ', ' ', ' ', 0, 0, ' '),
(9, 'asd', '0', ' ', ' ', ' ', ' ', 0, 0, ' '),
(10, 'aaaaa', '0', ' ', ' ', ' ', ' ', 0, 0, ' ');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicleId` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `carNumber` varchar(100) NOT NULL,
  `wheelNumber` int(4) NOT NULL,
  `locationDegreeX` varchar(100) NOT NULL,
  `locationDegreeY` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `company` varchar(100) NOT NULL,
  `ensurance` varchar(100) NOT NULL,
  `dateCreated` varchar(100) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`cargoId`),
  ADD KEY `orderId` (`orderId`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentId`),
  ADD KEY `forumId` (`forumId`);

--
-- Indexes for table `destination`
--
ALTER TABLE `destination`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `managerId` (`managerId`);

--
-- Indexes for table `forum`
--
ALTER TABLE `forum`
  ADD PRIMARY KEY (`forumId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `licence`
--
ALTER TABLE `licence`
  ADD PRIMARY KEY (`licenceId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`orderId`),
  ADD KEY `cargoId` (`cargoId`) USING BTREE,
  ADD KEY `desid` (`destinationId`) USING BTREE,
  ADD KEY `driverId` (`driverId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicleId`),
  ADD KEY `userId` (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
  MODIFY `cargoId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `commentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `destination`
--
ALTER TABLE `destination`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `forum`
--
ALTER TABLE `forum`
  MODIFY `forumId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `licence`
--
ALTER TABLE `licence`
  MODIFY `licenceId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `orderId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicleId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cargo`
--
ALTER TABLE `cargo`
  ADD CONSTRAINT `cargo_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`);

--
-- Constraints for table `driver`
--
ALTER TABLE `driver`
  ADD CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`managerId`) REFERENCES `manager` (`userId`),
  ADD CONSTRAINT `driver_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);

--
-- Constraints for table `forum`
--
ALTER TABLE `forum`
  ADD CONSTRAINT `forum_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  ADD CONSTRAINT `forum_ibfk_2` FOREIGN KEY (`forumId`) REFERENCES `comment` (`forumId`);

--
-- Constraints for table `licence`
--
ALTER TABLE `licence`
  ADD CONSTRAINT `licence_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `driver` (`userId`);

--
-- Constraints for table `manager`
--
ALTER TABLE `manager`
  ADD CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`driverId`) REFERENCES `driver` (`userId`),
  ADD CONSTRAINT `order_ibfk_2` FOREIGN KEY (`destinationId`) REFERENCES `destination` (`id`);

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
