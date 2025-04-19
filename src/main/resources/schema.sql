CREATE TABLE IF NOT EXISTS `Users` (
    `id` int AUTO_INCREMENT NOT NULL,
    `login` VARCHAR(32) NOT NULL,
    `password` VARCHAR(32) NOT NULL,
    `privileges` int NOT NULL,
    PRIMARY KEY (`id`)
);
