  CREATE TABLE USER (
    user_id integer identity primary key,
    LOGIN varchar(50) not null,
    PASSWORD varchar(50) not null,
    dateReg timestamp,
    dateLastVizit timestamp,

  );
  insert into user (user_id, password, login, dateReg, dateLastVizit) values (null, 'login', 'password', NULL , NULL );

