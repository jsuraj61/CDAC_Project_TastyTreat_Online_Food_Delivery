-- create db on root
CREATE DATABASE tastytreat;

-- create user root to handle db txns on tastytreat db
CREATE USER 'root'@'localhost' IDENTIFIED BY 'tastytreat';
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'tastytreat';
GRANT ALL PRIVILEGES ON tastytreat.* to root@localhost;

-- mysql -uhbadmin -ptastytreat tastytreat