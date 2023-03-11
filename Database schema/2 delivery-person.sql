CREATE TABLE delivery_person (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(255),
    is_available BOOLEAN,

    PRIMARY KEY (id)
);


-- dummy data
INSERT INTO delivery_person (name, email, password, is_available)
VALUES
('Olivia', 'olivia@test.com', 'password1', TRUE),
('Emma', 'emma@test.com', 'password2', TRUE);
