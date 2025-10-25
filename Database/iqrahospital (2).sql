-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2023 at 10:06 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iqrahospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `bankaccount`
--

CREATE TABLE `bankaccount` (
  `AccountNumber` int(255) NOT NULL,
  `IdCard` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `AccountTitle` varchar(255) NOT NULL,
  `cvv` int(255) NOT NULL,
  `exp` int(255) NOT NULL,
  `balance` int(255) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bankaccount`
--

INSERT INTO `bankaccount` (`AccountNumber`, `IdCard`, `Email`, `password`, `AccountTitle`, `cvv`, `exp`, `balance`) VALUES
(54321, 147147, 'iqrahospital3@gmail.com', 'iqra', 'IQRA HOSPITAL', 255, 1225, 2500),
(54325, 654321, 'shadabakhund14@gmail.com', 'sharjeel', 'Sharjeel Ahmed', 688, 9483, 12200),
(54326, 96385, 'shadabakhund14@gmail.com', 'shadab', 'Shadab Ahmed', 651, 5902, 12027);

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `id` int(255) NOT NULL,
  `DoctorName` varchar(255) NOT NULL,
  `fees` int(255) NOT NULL,
  `Speciality` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `DoctorName`, `fees`, `Speciality`) VALUES
(1, 'Dr.Shareel Ahmed', 0, 'Cardiology'),
(2, 'Dr. Aliyan Qureshi', 0, 'Neurology'),
(3, 'Dr. Sufiyan Qureshi', 0, 'Gyanelogist'),
(4, 'Dr Usman Ali', 0, 'Cardiology'),
(5, 'Dr Shadab Ahmed', 2560, 'Cardiology'),
(6, 'Shadab', 6300, 'Neurology'),
(7, 'Asma Qaiser', 6000, 'Neurology'),
(8, 'gvgvgv', 55, 'Neurology'),
(9, 'Faiza Adnan', 900, 'Cardiology'),
(10, 'vgvgv', 55, 'Neurology'),
(11, 'ismail', 2563, 'Neurology'),
(12, 'Dr. Shadab Aijaz', 3000, 'Hey'),
(13, 'Dr. njncjx', 55, 'here we go'),
(14, 'Dr. Ali Khan', 500, 'Dentist'),
(15, 'Dr. Dr. zubaida', 6900, 'Poka');

-- --------------------------------------------------------

--
-- Table structure for table `patientdata`
--

CREATE TABLE `patientdata` (
  `MrNumber` int(6) NOT NULL,
  `RecordNumber` int(255) NOT NULL DEFAULT 0,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(266) NOT NULL,
  `age` int(3) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `email` varchar(255) NOT NULL,
  `speciality` varchar(255) NOT NULL DEFAULT 'NA',
  `Doctor` varchar(255) NOT NULL DEFAULT 'NA',
  `day` text NOT NULL DEFAULT 'NA',
  `timeSlot` varchar(255) NOT NULL DEFAULT 'NA',
  `paymentStatus` varchar(20) NOT NULL DEFAULT 'NA',
  `date` text NOT NULL,
  `patientStatus` text NOT NULL DEFAULT 'waiting'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patientdata`
--

INSERT INTO `patientdata` (`MrNumber`, `RecordNumber`, `FirstName`, `LastName`, `age`, `gender`, `email`, `speciality`, `Doctor`, `day`, `timeSlot`, `paymentStatus`, `date`, `patientStatus`) VALUES
(1208, 0, 'Usman', 'Ahmed', 21, 'Female', 'shadabakhund14@gmail.com', 'Cardiology', 'Dr Shadab Ahmed', 'Monday', 'Monday (4:00PM))', 'waiting', '03 Sep 2023, 05:23 PM', 'Checked'),
(1209, 0, 'Shayan', 'Ahmed', 21, 'Female', 'shadabakhund14@gmail.com', 'Cardiology', 'Dr Shadab Ahmed', 'Monday', 'Monday (4:00PM))', 'waiting', '03 Sep 2023, 05:24 PM', 'Checked'),
(1210, 0, 'Aliyan', 'Ahmed', 21, 'Female', 'shadabakhund14@gmail.com', 'Cardiology', 'Dr Shadab Ahmed', 'Saturday', 'Saturday (9:00PM))', 'waiting', '03 Sep 2023, 05:24 PM', 'waiting'),
(1211, 0, 'Shadab', 'Ahmed', 21, 'Female', 'shadabakhund14@gmail.com', 'Gyanelogist', 'Dr. Sufiyan Qureshi', 'Select', 'Select Timeslot', 'Paid', '04 Sep 2023, 12:56 AM', 'waiting'),
(1212, 0, 'Shadab', 'Ahmed', 21, 'Female', 'shadabakhund14@gmail.com', 'Neurology', 'Shadab', 'Select', 'Select Timeslot', 'Paid', '04 Sep 2023, 12:59 AM', 'waiting'),
(1213, 129, 'Shadab', 'Ahmed', 21, 'Male', 'shadabakhund14@gmail.com', 'Neurology', 'Dr. Aliyan Qureshi', 'Select', 'Select Timeslot', 'unpaid', '04 Sep 2023, 01:05 AM', 'waiting'),
(1214, 129, 'Shadab', 'Ahmed', 21, 'Male', 'shadabakhund14@gmail.com', 'Neurology', 'Dr. Aliyan Qureshi', 'Select', 'Select Timeslot', 'unpaid', '04 Sep 2023, 01:05 AM', 'waiting');

-- --------------------------------------------------------

--
-- Table structure for table `records`
--

CREATE TABLE `records` (
  `RecordNumber` int(255) NOT NULL,
  `FirstName` text NOT NULL,
  `LastName` text NOT NULL,
  `age` int(255) NOT NULL,
  `gender` text NOT NULL,
  `email` text NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `records`
--

INSERT INTO `records` (`RecordNumber`, `FirstName`, `LastName`, `age`, `gender`, `email`, `date`) VALUES
(129, 'Shadab', 'Ahmed', 21, 'Male', 'shadabakhund14@gmail.com', '04 Sep 2023, 01:05 AM');

-- --------------------------------------------------------

--
-- Table structure for table `timeslots`
--

CREATE TABLE `timeslots` (
  `id` int(255) NOT NULL,
  `DoctorName` text NOT NULL,
  `day` text NOT NULL,
  `timeslot` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `timeslots`
--

INSERT INTO `timeslots` (`id`, `DoctorName`, `day`, `timeslot`) VALUES
(1, 'Shadab', '', '12 sy 3'),
(2, 'Shadab', '', '12 sy 5'),
(3, 'Shadab', '', '12 sy 9'),
(4, 'Faiza Adnan', '', 'hello world'),
(5, 'Faiza Adnan', '', 'ujujuj'),
(6, 'Dr. Shadab Aijaz', '', 'ggrg'),
(7, 'Dr. njncjx', '', '8 sy 10'),
(8, 'Dr. njncjx', '', '10 sy 12'),
(9, 'Dr. njncjx', '', '12 sy 3'),
(10, 'Dr. Ali Khan', '', 'Mon (7:00 - 8:00)'),
(11, 'Dr. Ali Khan', '', 'Tue (7:00 - 8:00)'),
(12, 'Dr. Ali Khan', '', 'Sun (7:00 - 8:00)'),
(13, 'Dr. Dr. zubaida', '', 'Monday'),
(14, 'Dr. Dr. zubaida', '', 'tuesday'),
(15, 'Dr. Dr. zubaida', '', 'saturday'),
(16, 'Dr. Ali Khan', 'Wednesday', '2'),
(17, 'Dr Shadab Ahmed', 'Monday', '4:00PM'),
(18, 'Dr Shadab Ahmed', 'Saturday', '9:00PM');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(255) NOT NULL,
  `SenderNo` int(255) NOT NULL,
  `SenderName` text NOT NULL,
  `ReceiverNo` int(255) NOT NULL,
  `ReceiverName` text NOT NULL,
  `Amount` int(255) NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `SenderNo`, `SenderName`, `ReceiverNo`, `ReceiverName`, `Amount`, `date`) VALUES
(1, 54326, 'Shadab Ahmed', 54326, 'Shadab Ahmed', 125, 'abc'),
(2, 54326, 'Shadab Ahmed', 54326, 'Shadab Ahmed', 3652, '03 Sep 2023, 10:07 PM'),
(3, 54326, 'Shadab Ahmed', 54325, 'Sharjeel Ahmed', 250, '03 Sep 2023, 10:16 PM'),
(5, 54325, 'Sharjeel Ahmed', 147147, 'IQRA HOSPITAL', 6300, '04 Sep 2023, 01:00 AM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bankaccount`
--
ALTER TABLE `bankaccount`
  ADD PRIMARY KEY (`AccountNumber`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patientdata`
--
ALTER TABLE `patientdata`
  ADD PRIMARY KEY (`MrNumber`);

--
-- Indexes for table `records`
--
ALTER TABLE `records`
  ADD PRIMARY KEY (`RecordNumber`);

--
-- Indexes for table `timeslots`
--
ALTER TABLE `timeslots`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bankaccount`
--
ALTER TABLE `bankaccount`
  MODIFY `AccountNumber` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54327;

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `patientdata`
--
ALTER TABLE `patientdata`
  MODIFY `MrNumber` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1215;

--
-- AUTO_INCREMENT for table `records`
--
ALTER TABLE `records`
  MODIFY `RecordNumber` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;

--
-- AUTO_INCREMENT for table `timeslots`
--
ALTER TABLE `timeslots`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
