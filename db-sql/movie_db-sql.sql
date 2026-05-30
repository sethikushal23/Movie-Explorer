CREATE DATABASE  IF NOT EXISTS `movie_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `movie_app`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: movie_app
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `description` text,
  `release_date` varchar(20) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (3,'Dhurandhar','Dhurandhar is a 2025 Indian Hindi-language spy action thriller film written and directed by Aditya Dhar. It was produced by Jyoti Deshpande, Aditya Dhar, and Lokesh Dhar, under Jio Studios and B62 Studios. The film features an ensemble cast consisting of Ranveer Singh, Akshaye Khanna, Sanjay Dutt, Arjun Rampal, R. Madhavan, Sara Arjun, Rakesh Bedi, Gaurav Gera, and Danish Pandor alongside several supporting actors.The first instalment of a duology, it centres on a high-stakes covert counter-terrorism operation.The film follows an undercover Indian intelligence agent who infiltrates Karachi\'s criminal syndicates and political power structures in Pakistan in an effort to dismantle a terror network targeting India.','2025','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\src\\imgss\\dhurandhar1.jpeg'),(4,'Dhurandhar2','Dhurandhar: The Revenge is a 2026 Indian Hindi-language spy action-thriller film written and directed by Aditya Dhar. It is produced by Dhar, Lokesh Dhar, and Jyoti Deshpande under Jio Studios and B62 Studios. It is a sequel to the 2025 film Dhurandhar and the final installment of the duology. The film stars Ranveer Singh, Arjun Rampal, Sanjay Dutt, R. Madhavan, Sara Arjun, Rakesh Bedi, Gaurav Gera, Danish Pandor, and Manav Gohil, with several actors reprising their roles from the first part. It follows an undercover Indian intelligence agent who continues to infiltrate Karachi\'s criminal syndicates and Pakistani politics while avenging the 26/11 attacks and confronting bigger threats.','2026','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\src\\imgss\\dhurandhar2.jpeg'),(6,'Toilet: Ek Prem Katha','Toilet: Ek Prem Katha, is a 2017 Indian Hindi-language comedy-drama film directed by Shree Narayan Singh. Co-produced by Akshay Kumar and Neeraj Pandey, the film stars Akshay Kumar and Bhumi Pednekar, with campaigns to improve sanitation conditions in India, with an emphasis on the eradication of open defecation, which is still a problem, especially in rural areas.','2017','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\build\\classes\\imgss\\toilet.jpeg'),(7,'Jab We Met','Jab We Met is a 2007 Indian Hindi-language Romantic Comedy film written and directed by Imtiaz Ali and produced by Dhilin Mehta under his banner Shree Ashtavinayak Cine Vision. The film stars Shahid Kapoor and Kareena Kapoor with Tarun Arora, Saumya Tandon and Dara Singh in supporting roles.','2007','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\build\\classes\\imgss\\jabwemet.jpeg'),(8,'Muqaddar Ka Sikandar','Muqaddar Ka Sikandar is a 1978 Indian action crime drama film produced and directed by Prakash Mehra, and written by Kader Khan, Vijay Kaul and Laxmikant Sharma.It stars Amitabh Bachchan, in his fifth of nine films with Prakash Mehra, along with Vinod Khanna, Raakhee, Rekha, Ranjeet, and Amjad Khan in pivotal roles, while Nirupa Roy, and Kader Khan gave special appearances. The film tells of the story of Sikandar (played by Amitabh Bachchan), an orphan raised in the slums of Bombay.','1978','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\build\\classes\\imgss\\muqaddarkasikandar.jpeg'),(10,'Uri: The Surgical Strike ','Uri: The Surgical Strike is a 2019 Indian Hindi-language war action film written and directed by debutant Aditya Dhar and produced by Ronnie Screwvala under the RSVP Movies banner.An account based on the real story of the retaliation to the 2016 Uri attack, the film stars Vicky Kaushal along with Yami Gautam, Paresh Rawal, Kirti Kulhari, and Mohit Raina in pivotal roles, and tells the story of Major Vihaan Shergill (Kaushal) of the Para (Special Forces), who played a leading role in the events.','2019','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\build\\classes\\imgss\\uri.jpg'),(11,'Airlift','Airlift is a 2016 Indian Hindi-language political thriller film directed by Raja Krishna Menon starring Akshay Kumar and Nimrat Kaur, that follows Ranjit Katyal (played by Kumar), a Kuwait-based businessman as he carries out the evacuation of Indians based in Kuwait during the Invasion of Kuwait by Saddam Hussein\'s Iraq which led to the beginning of the Gulf War.','2016','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\build\\classes\\imgss\\airlift.jpg'),(18,'Dangal','Dangal is a 2016 Indian Hindi-language biographical sports drama film directed by Nitesh Tiwari and produced by Aamir Khan, Kiran Rao, and Siddharth Roy Kapur under Aamir Khan Productions and The Walt Disney Company India. The film stars Khan as Mahavir Singh Phogat, a pehlwani amateur wrestler who trains his daughters Geeta Phogat and Babita Kumari to become India\'s first world-class female wrestlers.Fatima Sana Shaikh and Sanya Malhotra portray the adult versions of the two Phogat sisters, Zaira Wasim and Suhani Bhatnagar their younger versions, Sakshi Tanwar their mother, and Aparshakti Khurana adult version of their cousin, Ritvik Sahore his younger version, all of them except Shaikh, Tanwar and Sahore in their film debuts.','2016','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\build\\classes\\imgss\\Dangal_Poster.jpg'),(19,'Dabangg','Dabangg is a 2010 Indian Hindi-language action comedy film directed by Abhinav Singh Kashyap and produced by Malaika Arora and Arbaaz Khan under Arbaaz Khan Productions with Dhilin Mehta under Shree Ashtavinayak Cine Vision. The film stars Salman Khan, Sonakshi Sinha, Arbaaz Khan and Sonu Sood in the lead roles, while Om Puri, Dimple Kapadia, Vinod Khanna, Anupam Kher, Mahesh Manjrekar and Mahie Gill feature in supporting roles. The film marks the debut of Sinha as an actress, Arbaaz Khan as a producer and Kashyap as a director. Arora makes a special appearance in the song \"Munni Badnaam Hui\".','2010','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\build\\classes\\imgss\\Dabangg_poster.jpg'),(20,'Ready','Ready is a 2011 Indian Hindi-language action comedy film directed by Anees Bazmee.Produced by T-Series Films, Rawail Grandsons Entertainment and Software Pvt. Ltd., and Sohail Khan Productions, the film is the official remake of the 2008 Telugu film of the same name directed by Srinu Vaitla.The film stars Salman Khan and Asin in their second film together after London Dreams. Ready was distributed by Wave Cinemas and One Up Entertainment.Khan also narrated the film, while the story was written by Gopimohan and Kona Venkat.','2011','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\build\\classes\\imgss\\Salman-Asin-Ready.jpg'),(21,'Ajab Prem Ki Ghazab Kahani','Ajab Prem Ki Ghazab Kahani is a 2009 Indian Hindi-language slapstick romantic comedy film written and directed by Rajkumar Santoshi and produced by Ramesh Taurani under Tips Industries. The film stars Ranbir Kapoor and Katrina Kaif in the lead roles.','2009','C:\\Users\\Hp\\Documents\\NetBeansProjects\\MovieExplorer\\build\\classes\\imgss\\Ajab_Prem_Ki_Ghazab_Kahani.jpg');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(20) DEFAULT 'user',
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'kushal12','admin123','admin','ks123@gmail.com','9988776655'),(8,'suman123','suman@123','user','sumanbalaedu@gmail.com','1234567890'),(9,'vishalguru','vishwas33','user','vishal@gmail.com','9988290645');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-31  0:09:23
