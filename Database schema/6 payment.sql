CREATE TABLE payment (
    id INT NOT NULL AUTO_INCREMENT,
    order_id INT,
    customer_id INT,
    status VARCHAR(30),

    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- dummy data
INSERT INTO payment (order_id, customer_id, status)
VALUES
(1, 1, 'paid'),
(2, 2, 'paid'),
(3, 3, 'paid'),
(4, 3, 'paid');