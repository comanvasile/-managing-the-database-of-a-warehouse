SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `tema` ;
CREATE SCHEMA IF NOT EXISTS `tema` DEFAULT CHARACTER SET utf8 ;
USE `tema` ;

-- -----------------------------------------------------
-- Table `tema`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tema`.`client` ;

CREATE TABLE IF NOT EXISTS `tema`.`client` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nume` VARCHAR(45) NULL DEFAULT NULL,
  `adresa` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tema`.`comanda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tema`.`comanda` ;

CREATE TABLE IF NOT EXISTS `tema`.`comanda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATE NULL DEFAULT NULL,
  `idClient` INT(11) NULL DEFAULT NULL,
  `pretTotal` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `id_client_idx` (`idClient` ASC),
  CONSTRAINT `id_client`
    FOREIGN KEY (`idClient`)
    REFERENCES `tema`.`client` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tema`.`produs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tema`.`produs` ;

CREATE TABLE IF NOT EXISTS `tema`.`produs` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nume` VARCHAR(45) NULL DEFAULT NULL,
  `pret` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tema`.`comandaprodus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tema`.`comandaprodus` ;

CREATE TABLE IF NOT EXISTS `tema`.`comandaprodus` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idComanda` INT(11) NULL DEFAULT NULL,
  `idProdus` INT(11) NULL DEFAULT NULL,
  `cantitateComandata` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `id_produs_idx` (`idProdus` ASC),
  INDEX `id_comanda_idx` (`idComanda` ASC),
  CONSTRAINT `id_comanda`
    FOREIGN KEY (`idComanda`)
    REFERENCES `tema`.`comanda` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_produs`
    FOREIGN KEY (`idProdus`)
    REFERENCES `tema`.`produs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tema`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tema`.`factura` ;

CREATE TABLE IF NOT EXISTS `tema`.`factura` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `numeClient` VARCHAR(45) NULL DEFAULT NULL,
  `numeProdus` VARCHAR(45) NULL DEFAULT NULL,
  `cantitateComandata` INT(11) NULL DEFAULT NULL,
  `pretProdus` INT(11) NULL DEFAULT NULL,
  `pretTotal` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tema`.`stoc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tema`.`stoc` ;

CREATE TABLE IF NOT EXISTS `tema`.`stoc` (
  `id` INT(11) NOT NULL,
  `cantitate` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `id_idx` (`id` ASC),
  CONSTRAINT `id`
    FOREIGN KEY (`id`)
    REFERENCES `tema`.`produs` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
