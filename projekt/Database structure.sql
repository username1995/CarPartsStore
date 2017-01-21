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

-- Zrzut struktury tabela sklep.czesc
CREATE TABLE IF NOT EXISTS `czesc` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(50) DEFAULT NULL,
  `cena` varchar(50) DEFAULT NULL,
  `ilosc` varchar(50) DEFAULT NULL,
  `opis` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Zrzut struktury tabela sklep.klient
CREATE TABLE IF NOT EXISTS `klient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `haslo` varchar(50) NOT NULL,
  `imie` varchar(50) NOT NULL,
  `nazwisko` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `miejscowosc` varchar(50) DEFAULT NULL,
  `ulica` varchar(50) DEFAULT NULL,
  `nr mieszakania` varchar(50) DEFAULT NULL,
  `telefon` varchar(50) NOT NULL,
  `zamowienie` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `zamowienie` (`zamowienie`),
  CONSTRAINT `FK_klient_zamowienie` FOREIGN KEY (`zamowienie`) REFERENCES `zamowienie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Zrzut struktury tabela sklep.zamowienie
CREATE TABLE IF NOT EXISTS `zamowienie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `klient` int(11) NOT NULL,
  `akceptacja` varchar(50) DEFAULT 'niepotwierdzone',
  `czesc1` int(11) NOT NULL DEFAULT '0',
  `ilosc1` int(11) NOT NULL DEFAULT '0',
  `czesc2` int(11) DEFAULT '0',
  `ilosc2` int(11) DEFAULT '0',
  `czesc3` int(11) DEFAULT '0',
  `ilosc3` int(11) DEFAULT '0',
  `wartosc` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `klient` (`klient`),
  KEY `FK_zamowienie_czesc` (`czesc1`),
  KEY `FK_zamowienie_czesc_2` (`czesc2`),
  KEY `FK_zamowienie_czesc_3` (`czesc3`),
  CONSTRAINT `FK_zakup_klient` FOREIGN KEY (`klient`) REFERENCES `klient` (`id`),
  CONSTRAINT `FK_zamowienie_czesc` FOREIGN KEY (`czesc1`) REFERENCES `czesc` (`id`),
  CONSTRAINT `FK_zamowienie_czesc_2` FOREIGN KEY (`czesc2`) REFERENCES `czesc` (`id`),
  CONSTRAINT `FK_zamowienie_czesc_3` FOREIGN KEY (`czesc3`) REFERENCES `czesc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
