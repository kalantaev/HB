CREATE TABLE IF NOT EXISTS USER (
  user_id integer AUTO_INCREMENT,
  LOGIN varchar(50) not null,
  PASSWORD varchar(50) not null,
  dateReg timestamp,
  dateLastVizit timestamp,
  PRIMARY KEY (user_id)
);
CREATE TABLE IF NOT EXISTS content (
  content_id integer AUTO_INCREMENT,
  title varchar(50) ,
  description varchar(255),
  PRIMARY KEY (content_id)
);
CREATE TABLE IF NOT EXISTS comments (
  comment_id integer AUTO_INCREMENT,
  description varchar(255) null,
  user_id integer ,
  content_id integer,
  PRIMARY KEY (content_id)
);

insert into user (password, login, dateReg, dateLastVizit) values ('password', 'login', NULL , NULL );
INSERT INTO content(title, description) VALUES ('This sample content','There is provided a sample of the content , to access the site , you can use a test account with the login "login" and password "password"');
INSERT INTO comments(description, content_id, user_id) VALUES ('This sample coment', 1, 1);
