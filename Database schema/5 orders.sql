CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    restaurant_id INT,
    status VARCHAR(20),
    assigned_to_delivery_person_id INT,
    

    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id),
    FOREIGN KEY (assigned_to_delivery_person_id) REFERENCES delivery_person(id)
);

-- dummy data
INSERT INTO orders (customer_id, restaurant_id, status, assigned_to_delivery_person_id)
VALUES
(1, 1, 'preparing', 1),
(2, 1, 'out for delivery', 2),
(3, 2, 'preparing', 1),
(3, 2, 'out for delivery', 2);


CREATE TABLE order_item (
    id INT NOT NULL AUTO_INCREMENT,
    order_id INT,
    food_item_id INT,
    food_item_name VARCHAR(100),
    food_item_price DOUBLE,
    quantity INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (food_item_id) REFERENCES food_item(id)

);

-- dummy data
INSERT INTO order_item (order_id, food_item_id, food_item_name, food_item_price, quantity)
VALUES
(1, 1, 'Paneer Pizza', 120, 1),
(1, 2, 'Manchurian', 80, 1),
(2, 3, 'Pepper Pizza', 150, 2),
(3, 4, 'Noodles', 100, 1),
(4, 1, 'Paneer Pizza', 120, 2);