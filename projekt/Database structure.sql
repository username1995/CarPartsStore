-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Wersja serwera:               10.1.10-MariaDB - mariadb.org binary distribution
-- Serwer OS:                    Win32
-- HeidiSQL Wersja:              9.3.0.5067
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Zrzut struktury bazy danych sklep
CREATE DATABASE IF NOT EXISTS `sklep` /*!40100 DEFAULT CHARACTER SET utf32 COLLATE utf32_polish_ci */;
USE `sklep`;

-- Zrzut struktury tabela sklep.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(50) DEFAULT NULL,
  `nazwisko` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Zrzut struktury tabela sklep.czesc
CREATE TABLE IF NOT EXISTS `czesc` (
  `id` int(11) NOT NULL,
  `kategoria` int(11) DEFAULT NULL,
  `nazwa` varchar(50) DEFAULT NULL,
  `cena` varchar(50) DEFAULT NULL,
  `opis` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `kategoria` (`kategoria`),
  CONSTRAINT `FK__kategoria` FOREIGN KEY (`kategoria`) REFERENCES `kategoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Zrzut struktury tabela sklep.kategoria
CREATE TABLE IF NOT EXISTS `kategoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` char(50) CHARACTER SET utf32 COLLATE utf32_polish_ci NOT NULL,
  `model` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `model` (`model`),
  CONSTRAINT `FK_kategoria_model` FOREIGN KEY (`model`) REFERENCES `model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Zrzut struktury tabela sklep.klient
CREATE TABLE IF NOT EXISTS `klient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(50) DEFAULT NULL,
  `nazwisko` varchar(50) DEFAULT NULL,
  `zakup` int(11),
  `ulica` varchar(50) DEFAULT NULL,
  `miejscowosc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `zakup` (`zakup`),
  CONSTRAINT `FK_klient_zakup` FOREIGN KEY (`zakup`) REFERENCES `zakup` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Zrzut struktury tabela sklep.marka
CREATE TABLE IF NOT EXISTS `marka` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Zrzut struktury tabela sklep.model
CREATE TABLE IF NOT EXISTS `model` (
  `id` int(2) NOT NULL,
  `marka` int(2) NOT NULL,
  `nazwa` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `model` (`marka`),
  CONSTRAINT `FK_model_marka` FOREIGN KEY (`marka`) REFERENCES `marka` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Zrzut struktury tabela sklep.zakup
CREATE TABLE IF NOT EXISTS `zakup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `klient` int(11) NOT NULL,
  `akceptacja` int(11) NOT NULL,
  `czesc` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `czesc` (`czesc`),
  KEY `klient` (`klient`),
  CONSTRAINT `FK_zakup_czesc` FOREIGN KEY (`czesc`) REFERENCES `czesc` (`id`),
  CONSTRAINT `FK_zakup_klient` FOREIGN KEY (`klient`) REFERENCES `klient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
