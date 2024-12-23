CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    role VARCHAR(50),
    salary DECIMAL(10, 2)
);

INSERT INTO employee (name, role, salary) VALUES ('John Doe', 'Developer', 5000.00);
INSERT INTO employee (name, role, salary) VALUES ('Jane Smith', 'Manager', 7500.00);