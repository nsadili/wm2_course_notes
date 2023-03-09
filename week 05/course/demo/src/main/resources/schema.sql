CREATE TABLE IF NOT EXISTS `course` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `course_name` VARCHAR(45) NOT NULL,
    `department_name` VARCHAR(45) NOT NULL,
    `credits` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));