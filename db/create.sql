CREATE DATABASE example CHARACTER SET utf8mb4
;

CREATE TABLE `T_USERR` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` VARCHAR(16) NOT NULL,
	`password` VARCHAR(16) NOT NULL,
	`mail_addr` VARCHAR(160) NOT NULL,
	`del_flg` CHAR(1) NOT NULL,
	`reg_id` VARCHAR(50) NOT NULL,
	`reg_dt` DATETIME NOT NULL,
	`upd_id` VARCHAR(50) NOT NULL,
	`upd_dt` DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `user_id` (`user_id`)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
