CREATE TABLE food_type (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),

    PRIMARY KEY (id)
);

-- dummy data
INSERT INTO food_type (name)
VALUES
('Pizza'),
('Chinese');



CREATE TABLE food_item (
    id INT NOT NULL AUTO_INCREMENT,
    food_type_id INT,
    restaurant_id INT,
    name VARCHAR(100),
    price DOUBLE,
    is_vegetarian BOOLEAN,
    image_path TEXT,

    PRIMARY KEY (id),
    FOREIGN KEY (food_type_id) REFERENCES food_type(id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id)
);

-- dummy data
INSERT INTO food_item (food_type_id, restaurant_id, name, price, is_vegetarian, image_path)
VALUES
(1, 1, 'Paneer Pizza', 120, FALSE, 'https://images.unsplash.com/photo-1546069901-ba9599a7e63c'),
(2, 1, 'Manchurian', 80,  TRUE, 'https://images.unsplash.com/photo-1546069901-ba9599a7e63c'),
(1, 2, 'Pepper Pizza', 150, FALSE, 'https://images.unsplash.com/photo-1546069901-ba9599a7e63c'),
(2, 2, 'Noodles', 100, TRUE, 'https://images.unsplash.com/photo-1546069901-ba9599a7e63c');