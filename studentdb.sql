CREATE DATABASE `studentdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- studentdb.course definition

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO studentdb.course (name) VALUES('Information Technology (IT)');
INSERT INTO studentdb.course (name) VALUES('Cyber Security');
INSERT INTO studentdb.course (name) VALUES('Artificial Intelligence (Ai)');
INSERT INTO studentdb.course (name) VALUES('Cloud Computing');
INSERT INTO studentdb.course (name) VALUES('Network Computing');
INSERT INTO studentdb.course (name) VALUES('Internet of Things (IoT)');

-- studentdb.info definition

CREATE TABLE `info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `age` int NOT NULL,
  `matric_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `info_FK` (`course_id`),
  CONSTRAINT `info_FK` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

