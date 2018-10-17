CREATE SCHEMA IF NOT EXISTS `finals` DEFAULT CHARACTER SET utf8 ;
USE `finals` ;

CREATE TABLE IF NOT EXISTS `finals`.`Subject` (
  `idSubject` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) CHARACTER SET 'utf8' NOT NULL,
  `year` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idSubject`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `finals`.`Student` (
  `dniStudent` INT UNSIGNED NOT NULL,
  `name` VARCHAR(50) CHARACTER SET 'utf8' NOT NULL,
  `surname` VARCHAR(50) CHARACTER SET 'utf8' NOT NULL,
  `email` VARCHAR(255) CHARACTER SET 'utf8',
  PRIMARY KEY(`dniStudent`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `finals`.`Final` (
  `idFinal` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `subjectIdSubject` INT UNSIGNED NOT NULL,
  `studentDniStudent` INT UNSIGNED NOT NULL,
  `qualification` INT UNSIGNED NOT NULL,
  `dateFinal` DATE NOT NULL,
  PRIMARY KEY(`idFinal`) ,
  FOREIGN KEY (`subjectIdSubject`) 
  REFERENCES `finals`.`Subject`(`idSubject`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION,
  FOREIGN KEY (`studentDniStudent`) 
  REFERENCES `finals`.`Student`(`dniStudent`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION)
ENGINE = InnoDB;
