-- MySQL Script generated by MySQL Workbench
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema estatistica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema estatistica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `estatistica` DEFAULT CHARACTER SET utf8 ;
USE `estatistica` ;

-- -----------------------------------------------------
-- Table `estatistica`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estatistica`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `senha` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estatistica`.`contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estatistica`.`contato` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `eu_sou` INT(11) NULL DEFAULT NULL,
  `mensagem` VARCHAR(200) NULL DEFAULT NULL,
  `usuarios_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contato_usuarios1_idx` (`usuarios_id` ASC),
  CONSTRAINT `fk_contato_usuarios1`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `estatistica`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estatistica`.`projetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estatistica`.`projetos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `quantidade_repeticoes` INT(11) NULL DEFAULT NULL,
  `significancia` DECIMAL(10,2) NULL DEFAULT NULL,
  `teste` INT(11) NULL DEFAULT NULL,
  `usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_projetos_usuarios1_idx` (`usuario` ASC),
  CONSTRAINT `fk_projetos_usuarios1`
    FOREIGN KEY (`usuario`)
    REFERENCES `estatistica`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estatistica`.`tratamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estatistica`.`tratamentos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NULL DEFAULT NULL,
  `projeto` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tratamentos_projetos1_idx` (`projeto` ASC),
  CONSTRAINT `fk_tratamentos_projetos1`
    FOREIGN KEY (`projeto`)
    REFERENCES `estatistica`.`projetos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estatistica`.`variaveis_respostas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estatistica`.`variaveis_respostas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `projeto` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_variaveis_respostas_projetos1_idx` (`projeto` ASC),
  CONSTRAINT `fk_variaveis_respostas_projetos1`
    FOREIGN KEY (`projeto`)
    REFERENCES `estatistica`.`projetos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estatistica`.`dados_dic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estatistica`.`dados_dic` (
  `variavel_resposta` INT(11) NOT NULL,
  `tratamento` INT(11) NOT NULL,
  `repeticao` INT(11) NOT NULL,
  `valor` DECIMAL(10,2) NULL DEFAULT NULL,
  `x` INT(11) NULL DEFAULT NULL,
  `y` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`variavel_resposta`, `tratamento`, `repeticao`),
  INDEX `fk_variaveis_respostas_has_tratamentos_tratamentos1_idx` (`tratamento` ASC),
  INDEX `fk_variaveis_respostas_has_tratamentos_variaveis_respostas1_idx` (`variavel_resposta` ASC),
  CONSTRAINT `fk_variaveis_respostas_has_tratamentos_tratamentos1`
    FOREIGN KEY (`tratamento`)
    REFERENCES `estatistica`.`tratamentos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_variaveis_respostas_has_tratamentos_variaveis_respostas1`
    FOREIGN KEY (`variavel_resposta`)
    REFERENCES `estatistica`.`variaveis_respostas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estatistica`.`dados_simples`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estatistica`.`dados_simples` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `valor` DECIMAL(10,2) NOT NULL,
  `projeto` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dados_simples_projetos1_idx` (`projeto` ASC),
  CONSTRAINT `fk_dados_simples_projetos1`
    FOREIGN KEY (`projeto`)
    REFERENCES `estatistica`.`projetos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
