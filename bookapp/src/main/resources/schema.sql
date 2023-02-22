CREATE TABLE IF NOT EXISTS `book` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(45) NOT NULL,
    `description` TEXT,
    `year` INT NOT NULL ,
    `author` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));