  CREATE TABLE USER (
    user_id integer identity primary key,
    LOGIN varchar(50) not null,
    PASSWORD varchar(50) not null,
    dateReg timestamp,
    dateLastVizit timestamp,

  );
  CREATE TABLE content (
    content_id integer identity primary key,
    title varchar(50) ,
    description varchar(255),
    );
  CREATE TABLE comments (
    comment_id integer identity primary key,
    description varchar(255) null,
    user_id integer ,
    content_id integer,
  );
  CREATE TABLE content_user (
    user_id integer ,
    content_id integer,
  );
  insert into user (user_id, password, login, dateReg, dateLastVizit) values (null, 'login', 'password', NULL , NULL );
--   -- -----------------------------------------------------

--   -- -----------------------------------------------------
--   -- Table `test`.`comments`
--   -- -----------------------------------------------------
--   CREATE  TABLE IF NOT EXISTS `test`.`comments` (
--   `comment_id` INT(11) NOT NULL AUTO_INCREMENT ,
--   `description` VARCHAR(255) NULL DEFAULT NULL ,
--   `user_id` INT(11) NULL DEFAULT NULL ,
--   `content_id` INT(11) NULL DEFAULT NULL ,
--   PRIMARY KEY (`comment_id`) ,
--   INDEX `FKDC17DDF440DF9925` (`user_id` ASC) ,
--   INDEX `FKDC17DDF442E3EBEF` (`content_id` ASC) ,
--   INDEX `FKDC17DDF4397111FA` (`user_id` ASC) ,
--   INDEX `FKDC17DDF46BA046FA` (`content_id` ASC) ,
--   CONSTRAINT `FKDC17DDF4397111FA`
--   FOREIGN KEY (`user_id` )
--   REFERENCES `test`.`user` (`user_id` ),
--   CONSTRAINT `FKDC17DDF440DF9925`
--   FOREIGN KEY (`user_id` )
--   REFERENCES `test`.`user` (`user_id` ),
--   CONSTRAINT `FKDC17DDF442E3EBEF`
--   FOREIGN KEY (`content_id` )
--   REFERENCES `test`.`content` (`content_id` ),
--   CONSTRAINT `FKDC17DDF46BA046FA`
--   FOREIGN KEY (`content_id` )
--   REFERENCES `test`.`content` (`content_id` ))
--     ENGINE = InnoDB
--     AUTO_INCREMENT = 2
--   DEFAULT CHARACTER SET = utf8;


--   -- -----------------------------------------------------
--   -- Table `test`.`content_user`
--   -- -----------------------------------------------------
--   CREATE  TABLE IF NOT EXISTS `test`.`content_user` (
--   `content_id` INT(11) NOT NULL ,
--   `user_id` INT(11) NOT NULL ,
--   INDEX `FK319553D140DF9925` (`user_id` ASC) ,
--   INDEX `FK319553D142E3EBEF` (`content_id` ASC) ,
--   INDEX `FK319553D1397111FA` (`user_id` ASC) ,
--   INDEX `FK319553D16BA046FA` (`content_id` ASC) ,
--   CONSTRAINT `FK319553D1397111FA`
--   FOREIGN KEY (`user_id` )
--   REFERENCES `test`.`user` (`user_id` ),
--   CONSTRAINT `FK319553D140DF9925`
--   FOREIGN KEY (`user_id` )
--   REFERENCES `test`.`user` (`user_id` ),
--   CONSTRAINT `FK319553D142E3EBEF`
--   FOREIGN KEY (`content_id` )
--   REFERENCES `test`.`content` (`content_id` ),
--   CONSTRAINT `FK319553D16BA046FA`
--   FOREIGN KEY (`content_id` )
--   REFERENCES `test`.`content` (`content_id` ))
--     ENGINE = InnoDB
--   DEFAULT CHARACTER SET = utf8;
--
