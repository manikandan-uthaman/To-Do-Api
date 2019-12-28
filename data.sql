CREATE TABLE `users` (
	`id` INT(11) NOT NULL,
	`name` VARCHAR(50) NOT NULL DEFAULT '',
	`username` VARCHAR(50) NOT NULL DEFAULT '',
	`email` VARCHAR(50) NOT NULL DEFAULT '',
	`password` VARCHAR(500) NOT NULL DEFAULT '',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `UKr43af9ap4edm43mmtq01oddj6` (`username`),
	UNIQUE INDEX `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
);

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

CREATE TABLE `files` (
	`id` VARCHAR(50) NOT NULL,
	`data` BLOB NULL,
	`file_name` VARCHAR(255) NULL DEFAULT NULL,
	`file_type` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tasks` (
	`id` INT(11) NOT NULL,
	`task_name` VARCHAR(50) NOT NULL DEFAULT '',
	`task_desc` VARCHAR(1000) NOT NULL DEFAULT '',
	`target_date` DATE NULL DEFAULT NULL,
	`task_status` VARCHAR(50) NOT NULL DEFAULT '',
	`file_id` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_STATUS` (`task_status`),
	INDEX `FK_FILE_ID` (`file_id`),
	CONSTRAINT `FK_FILE_ID` FOREIGN KEY (`file_id`) REFERENCES `files` (`id`),
	CONSTRAINT `FK_STATUS` FOREIGN KEY (`task_status`) REFERENCES `status` (`name`)
);


CREATE TABLE `users_tasks` (
	`user_id` INT(11) NOT NULL,
	`task_id` INT(11) NOT NULL,
	PRIMARY KEY (`user_id`, `task_id`),
	INDEX `TASKS_FK` (`task_id`),
	CONSTRAINT `TASKS_FK` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`),
	CONSTRAINT `USER_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);
