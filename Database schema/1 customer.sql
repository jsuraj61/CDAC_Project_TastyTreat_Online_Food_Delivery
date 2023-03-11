CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(255),
    address_text TEXT,
    pin_code INT,

    PRIMARY KEY (id)
);

-- Dummy Data
INSERT INTO customer (name, email, password, address_text, pin_code)
VALUES
('Liam', 'liam@test.com', 'password', 'address one', 433001),
('Noah', 'noah@test.com', 'password', 'address two', 433002),
('Oliver', 'oliver@test.com', 'password', 'address three', 433003),
('Elijah', 'elijah@test.com', 'password', 'address four', 433004);