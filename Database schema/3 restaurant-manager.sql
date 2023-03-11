CREATE TABLE restaurant (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    address_text TEXT,
    pin_code INT,

    PRIMARY KEY (id)
);

-- dummy data
INSERT INTO restaurant (name, address_text, pin_code)
VALUES
('Blue Orchid', 'address seven', 433003),
('Red Rose', 'address eight', 433004);


CREATE TABLE restaurant_manager (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(255),
    restaurant_id INT,

    PRIMARY KEY (id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id)
);

-- dummy data
INSERT INTO restaurant_manager (name, email, password, restaurant_id)
VALUES
('Ava', 'ava@gmail.com', 'password1', 1),
('Charlotte', 'charlotte@gmail.com', 'password2', 2);