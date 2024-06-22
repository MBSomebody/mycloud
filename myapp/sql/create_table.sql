CREATE TABLE `goods` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `goodName` varchar(255) DEFAULT NULL,
  `remain` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ;


CREATE TABLE `orders` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `goodId` int DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `orderNo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14227 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci