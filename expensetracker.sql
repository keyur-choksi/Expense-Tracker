-- phpMyAdmin SQL Dump
-- version 2.6.2-pl1
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Apr 06, 2019 at 03:11 PM
-- Server version: 4.1.12
-- PHP Version: 5.0.4
-- 
-- Database: `expensetracker`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `balance`
-- 

CREATE TABLE `balance` (
  `uid` int(5) NOT NULL default '0',
  `cur_bal` int(10) NOT NULL default '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- 
-- Dumping data for table `balance`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `log`
-- 

CREATE TABLE `log` (
  `logid` int(5) NOT NULL auto_increment,
  `uid` int(5) NOT NULL default '0',
  `category` varchar(10) collate latin1_general_ci NOT NULL default '',
  `description` varchar(100) collate latin1_general_ci NOT NULL default '',
  `timestamp` timestamp NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`logid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `log`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `login`
-- 

CREATE TABLE `login` (
  `uid` int(5) NOT NULL auto_increment,
  `email` varchar(50) collate latin1_general_ci NOT NULL default '',
  `password` varchar(20) collate latin1_general_ci NOT NULL default '',
  PRIMARY KEY  (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=3 ;

-- 
-- Dumping data for table `login`
-- 

INSERT INTO `login` VALUES (1, 'keyur', 'keyur');
INSERT INTO `login` VALUES (2, 'piyush', 'piyush');

-- --------------------------------------------------------

-- 
-- Table structure for table `user_details`
-- 

CREATE TABLE `user_details` (
  `no` int(5) NOT NULL default '0',
  `uid` int(5) NOT NULL default '0',
  `name` varchar(30) collate latin1_general_ci NOT NULL default '',
  `mobile` int(10) NOT NULL default '0',
  `city` varchar(30) collate latin1_general_ci NOT NULL default '',
  `dob` date NOT NULL default '0000-00-00'
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- 
-- Dumping data for table `user_details`
-- 

INSERT INTO `user_details` VALUES (0, 1, 'keyur', 73597, 'jam', '0000-00-00');
INSERT INTO `user_details` VALUES (0, 2, 'piyush', 32164, 'jam', '0000-00-00');
