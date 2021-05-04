DROP TABLE IF EXISTS `tigers`;
DROP TABLE IF EXISTS `tiger_sightings`;

CREATE TABLE `tigers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `last_seen` datetime(6) DEFAULT NULL,
  `last_seen_coordinates` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tiger_sightings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `coordinates` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `seen` datetime(6) DEFAULT NULL,
  `tiger_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TIGER` (`tiger_id`),
  CONSTRAINT `FK_TIGER` FOREIGN KEY (`tiger_id`) REFERENCES `tigers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;