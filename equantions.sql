/* SQL Manager Lite for MySQL                              5.7.2.52112 */
/* ------------------------------------------------------------------- */
/* Host     : localhost                                                */
/* Port     : 3306                                                     */
/* Database : equantions                                               */


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES 'utf8mb4' */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `equantions`;

CREATE DATABASE `equantions`
    CHARACTER SET 'utf8mb4'
    COLLATE 'utf8mb4_general_ci';

USE `equantions`;

/* Dropping database objects */

DROP TABLE IF EXISTS `equantions`;

/* Structure for the `equantions` table : */

CREATE TABLE `equantions` (
  `id` INTEGER(10) UNSIGNED ZEROFILL NOT NULL,
  `param_a` DOUBLE NOT NULL DEFAULT 0,
  `param_b` DOUBLE NOT NULL DEFAULT 0,
  `param_c` DOUBLE NOT NULL DEFAULT 0,
  `discriminant` DOUBLE NOT NULL DEFAULT 0,
  `first_result` DOUBLE DEFAULT NULL,
  `second_result` DOUBLE DEFAULT NULL,
  `success_result` DOUBLE NOT NULL DEFAULT 0,
  PRIMARY KEY USING BTREE (`id`),
  UNIQUE KEY `id` USING BTREE (`id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci'
;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;