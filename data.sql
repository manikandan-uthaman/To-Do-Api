CREATE TABLE `status` (
	`id` INT(11) NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`)
);

INSERT INTO `status` VALUES(1, `NOT_STARTED`);
INSERT INTO `status` VALUES(2, `IN_PROGRESS`);
INSERT INTO `status` VALUES(3, `COMPLETED`);
COMMIT;

CREATE TABLE `tasks` (
	`id` INT(11) NOT NULL,
	`task_name` VARCHAR(50) NOT NULL DEFAULT '',
	`task_desc` VARCHAR(1000) NOT NULL DEFAULT '',
	`target_date` DATE NULL DEFAULT NULL,
	`task_status` VARCHAR(50) NOT NULL DEFAULT '',
	PRIMARY KEY (`id`),
	INDEX `FK_STATUS` (`task_status`),
	CONSTRAINT `FK_STATUS` FOREIGN KEY (`task_status`) REFERENCES `status` (`name`)
);
