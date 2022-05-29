-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2022 at 05:27 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trungtamngoaingu`
--

-- --------------------------------------------------------

--
-- Table structure for table `danhsachphongthi`
--

CREATE TABLE `danhsachphongthi` (
  `IDPhongThi` int(11) NOT NULL,
  `IDThiSinh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `danhsachphongthi`
--

INSERT INTO `danhsachphongthi` (`IDPhongThi`, `IDThiSinh`) VALUES
(51, 7),
(51, 9),
(51, 6),
(52, 13),
(52, 14),
(52, 8),
(53, 15),
(53, 10),
(53, 1),
(54, 12),
(54, 17),
(54, 16),
(55, 11),
(55, 2),
(55, 5);

-- --------------------------------------------------------

--
-- Table structure for table `ketquathi`
--

CREATE TABLE `ketquathi` (
  `IDThiSinh` int(11) NOT NULL,
  `IDKhoaThi` int(11) NOT NULL,
  `Nghe` float NOT NULL,
  `Noi` float NOT NULL,
  `Doc` float NOT NULL,
  `Viet` float NOT NULL,
  `TrungBinh` float NOT NULL,
  `XepLoai` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ketquathi`
--

INSERT INTO `ketquathi` (`IDThiSinh`, `IDKhoaThi`, `Nghe`, `Noi`, `Doc`, `Viet`, `TrungBinh`, `XepLoai`) VALUES
(7, 15, 10, 0, 0, 0, 2.5, 'F'),
(9, 15, 0, 9, 0, 0, 2.3, 'F'),
(6, 15, 0, 0, 8, 0, 2, 'F'),
(13, 15, 0, 0, 0, 0, 0, 'F'),
(14, 15, 0, 0, 0, 0, 0, 'F'),
(8, 15, 0, 0, 0, 0, 0, 'F'),
(15, 15, 0, 0, 0, 0, 0, 'F'),
(10, 15, 0, 0, 0, 0, 0, 'F'),
(1, 15, 10, 9, 8, 7, 8.5, 'A'),
(12, 15, 0, 0, 0, 0, 0, 'F'),
(17, 15, 0, 0, 0, 0, 0, 'F'),
(16, 15, 0, 0, 0, 0, 0, 'F'),
(11, 15, 0, 0, 0, 0, 0, 'F'),
(2, 15, 0, 0, 0, 0, 0, 'F'),
(5, 15, 0, 0, 0, 0, 0, 'F');

-- --------------------------------------------------------

--
-- Table structure for table `khoathi`
--

CREATE TABLE `khoathi` (
  `IDKhoaThi` int(11) NOT NULL,
  `TenKhoaThi` varchar(30) NOT NULL,
  `NgayThi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khoathi`
--

INSERT INTO `khoathi` (`IDKhoaThi`, `TenKhoaThi`, `NgayThi`) VALUES
(1, 'Khoa 18 - 2020', '2021-12-15'),
(2, 'Khoa 19 - 2021', '2021-12-24'),
(15, 'TA vao', '2022-01-18');

-- --------------------------------------------------------

--
-- Table structure for table `phongthi`
--

CREATE TABLE `phongthi` (
  `IDPhongThi` int(11) NOT NULL,
  `TenPhongThi` varchar(30) NOT NULL,
  `IDKhoaThi` int(11) NOT NULL,
  `TrinhDo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phongthi`
--

INSERT INTO `phongthi` (`IDPhongThi`, `TenPhongThi`, `IDKhoaThi`, `TrinhDo`) VALUES
(4, 'A2_P3', 1, 'A2'),
(6, 'A2_P5', 1, 'A2'),
(7, 'A2_P6', 1, 'A2'),
(8, 'A2_P7', 1, 'A2'),
(9, 'A2_P8', 1, 'A2'),
(10, 'A2_P9', 1, 'A2'),
(20, 'A2_P3', 2, 'A2'),
(21, 'B1_P1', 2, 'B1'),
(22, 'B1_P2', 2, 'B1'),
(23, 'B1_P4', 2, 'B1'),
(24, 'B1_P5', 2, 'B1'),
(25, 'B1_P6', 2, 'B1'),
(51, 'A2_P1', 15, 'A2'),
(52, 'A2_P2', 15, 'A2'),
(53, 'A2_P3', 15, 'A2'),
(54, 'B1_P4', 15, 'B1'),
(55, 'B1_P5', 15, 'B1'),
(56, 'B1_P6', 15, 'B1'),
(57, 'A2_P7', 15, 'A2'),
(58, 'A2_P8', 15, 'A2'),
(59, 'A2_P9', 15, 'A2');

-- --------------------------------------------------------

--
-- Table structure for table `sobaodanh`
--

CREATE TABLE `sobaodanh` (
  `IDThiSinh` int(11) NOT NULL,
  `IDKhoaThi` int(11) NOT NULL,
  `SoBaoDanh` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sobaodanh`
--

INSERT INTO `sobaodanh` (`IDThiSinh`, `IDKhoaThi`, `SoBaoDanh`) VALUES
(7, 15, 'A2_7'),
(9, 15, 'A2_9'),
(6, 15, 'A2_6'),
(13, 15, 'A2_13'),
(14, 15, 'A2_14'),
(8, 15, 'A2_8'),
(15, 15, 'A2_15'),
(10, 15, 'A2_10'),
(1, 15, 'A2_1'),
(12, 15, 'B1_12'),
(17, 15, 'B1_17'),
(16, 15, 'B1_16'),
(11, 15, 'B1_11'),
(2, 15, 'B1_2'),
(5, 15, 'B1_5');

-- --------------------------------------------------------

--
-- Table structure for table `thisinh`
--

CREATE TABLE `thisinh` (
  `IDThiSinh` int(11) NOT NULL,
  `Ho` varchar(30) NOT NULL,
  `Ten` varchar(10) NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` varchar(10) NOT NULL,
  `CMND` varchar(12) NOT NULL,
  `SDT` varchar(12) NOT NULL,
  `TrinhDo` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thisinh`
--

INSERT INTO `thisinh` (`IDThiSinh`, `Ho`, `Ten`, `NgaySinh`, `GioiTinh`, `CMND`, `SDT`, `TrinhDo`) VALUES
(1, 'Truong Minh', 'Tuan', '2021-12-01', 'Nam', '083278123', '0934045700', 'A2'),
(2, 'Hua Minh', 'Trieu', '2021-12-09', 'Nữ', '083718231', '0981728122', 'B1'),
(5, 'Nguyen Huy', 'Truong', '2022-01-07', 'Nam', '03215487945', '09345874611', 'B1'),
(6, 'Nguyen Van', 'Linh', '2000-01-05', 'Nam', '098754125', '0987431570', 'A2'),
(7, 'Tran Ngoc', 'An', '1998-01-13', 'Nữ', '022745135', '0987424577', 'A2'),
(8, 'Le Van', 'Thinh', '2002-01-12', 'Nam', '024875157', '0987457122', 'A2'),
(9, 'Huynh Quang', 'Hieu', '2003-01-03', 'Nam', '024871578', '0987512332', 'A2'),
(10, 'Lai Van', 'Trung', '1995-01-12', 'Nam', '024157841', '0987245665', 'A2'),
(11, 'Bui Quoc', 'Toan', '2000-01-11', 'Nam', '024871574', '0787957800', 'B1'),
(12, 'Le Thanh', 'Hang', '1998-01-12', 'Nữ', '023587458', '0978412577', 'B1'),
(13, 'Nguyen Thi', 'Minh', '2000-01-05', 'Nữ', '024876517', '0982157466', 'A2'),
(14, 'Duong Van', 'Thai', '2001-01-11', 'Nam', '024587415', '0784521344', 'A2'),
(15, 'Tran Thi', 'Thu Lan', '2005-01-18', 'Nữ', '024868745', '0933658744', 'A2'),
(16, 'Hoang Thi', 'Ngoc Anh', '2000-01-05', 'Nữ', '023568744', '0784556984', 'B1'),
(17, 'Le Ngoc', 'Hoa', '1997-01-18', 'Nữ', '057848757', '0974254677', 'B1'),
(19, 'Nguyen Thi', 'Lan', '1995-01-05', 'Nữ', '0548741354', '0987451755', 'A2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `khoathi`
--
ALTER TABLE `khoathi`
  ADD PRIMARY KEY (`IDKhoaThi`);

--
-- Indexes for table `phongthi`
--
ALTER TABLE `phongthi`
  ADD PRIMARY KEY (`IDPhongThi`);

--
-- Indexes for table `thisinh`
--
ALTER TABLE `thisinh`
  ADD PRIMARY KEY (`IDThiSinh`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `khoathi`
--
ALTER TABLE `khoathi`
  MODIFY `IDKhoaThi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `phongthi`
--
ALTER TABLE `phongthi`
  MODIFY `IDPhongThi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `thisinh`
--
ALTER TABLE `thisinh`
  MODIFY `IDThiSinh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
