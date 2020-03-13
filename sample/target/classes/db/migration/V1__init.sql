CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_name varchar(100) NOT NULL,
  password varchar(250) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;