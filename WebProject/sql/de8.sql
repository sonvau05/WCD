
-- Create tables
CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO categories (name, description)
VALUES
('Category 1','Description 1'),
('Category 2','Description 2'),
('Category 3','Description 3'),
('Category 4','Description 4'),
('Category 5','Description 5'),
('Category 6','Description 6'),
('Category 7','Description 7'),
('Category 8','Description 8'),
('Category 9','Description 9'),
('Category 10','Description 10');
