CREATE  DATABASE  mybatis_database;
SHOW DATABASES ;

USE mybatis_database;
SELECT * FROM authors;
CREATE TABLE authors(
  author_id  SERIAL PRIMARY KEY,
  name VARCHAR(50),
  gender VARCHAR(20)

);