CREATE TABLE IF NOT EXISTS `library` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `title` VARCHAR(45) NOT NULL,
    `description` VARCHAR(45) NOT NULL,
    "year" VARCHAR(45) NOT NULL,
    `author` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));