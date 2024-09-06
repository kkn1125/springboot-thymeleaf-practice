create schema chatting_app;

use chatting_app;

#alter table `user` add column created_at datetime not null default now() after memo;
#alter table `user` add column updated_at datetime not null default now() on update now() after created_at;
#desc user;
select * from user;
CREATE TABLE `user` (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(150) NOT NULL,
    email VARCHAR(50) NULL,
    address1 VARCHAR(500) NULL,
    address2 VARCHAR(500) NULL,
    zip_number INT NULL,
    memo VARCHAR(100),
	created_at DATETIME NOT NULL DEFAULT NOW(),
    updated_at DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (id)
)  DEFAULT CHARSET=UTF8;

CREATE TABLE `board` (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    title VARCHAR(50) NOT NULL,
    contents TEXT NOT NULL,
    memo VARCHAR(500) NOT NULL DEFAULT '',
    created_at DATETIME NOT NULL DEFAULT NOW(),
    updated_at DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES `user` (id)
)  DEFAULT CHARSET=UTF8;

CREATE TABLE chatting_room (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    `description` TEXT NOT NULL,
    user_id INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    updated_at DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES user (id)
)  DEFAULT CHARSET=UTF8;

CREATE TABLE chatting (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    chatting_room_id INT NOT NULL,
    message TEXT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES user (id),
    FOREIGN KEY (chatting_room_id)
        REFERENCES chatting_room (id)
)  DEFAULT CHARSET=UTF8;


DESC `user`;
DESC board;

SELECT 
    *
FROM
    `user`;
SELECT 
    *
FROM
    board;

DELETE FROM `user`;
DELETE FROM board;

alter table `user` auto_increment=1;
alter table board auto_increment=1;
alter table board modify title varchar(50) not null;

