CREATE DATABASE IF NOT EXISTS foodcitydb;
USE foodcitydb;

-- customer table 
CREATE TABLE IF NOT EXISTS customer (
	cus_id INT AUTO_INCREMENT PRIMARY KEY,
    cus_nic VARCHAR(15) NOT NULL UNIQUE,
    cus_name VARCHAR(50),
    dob DATE,
    phone VARCHAR(20) DEFAULT NULL,
    email VARCHAR(100) DEFAULT NULL
);

-- product table 
CREATE TABLE IF NOT EXISTS product (
	product_code VARCHAR(15) NOT NULL,
    product_name VARCHAR(70) NOT NULL,
    product_desc TEXT NOT NULL,
    qty INT(10) NOT NULL,
    buy_price DECIMAL(10, 2) NOT NULL,
    msrp DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (product_code)
);

-- order table
CREATE TABLE IF NOT EXISTS orders (
	order_number VARCHAR(20) NOT NULL,
    cus_id INT NOT NULL,
    order_date DATE NOT NULL,
    status VARCHAR(15) NOT NULL,
    comment TEXT,
    PRIMARY KEY(order_number),
    FOREIGN KEY (cus_id) REFERENCES customer (cus_id)
);

-- supplier table
CREATE TABLE IF NOT EXISTS supplier (
	sup_id INT AUTO_INCREMENT PRIMARY KEY,
    sup_name VARCHAR(50) NOT NULL,
    sup_category VARCHAR(20) NOT NULL
);

-- supplier_product join table
CREATE TABLE IF NOT EXISTS sup_product (
	sup_id INT NOT NULL,
    product_code VARCHAR(15) NOT NULL,
    PRIMARY KEY (sup_id, product_code),
    FOREIGN KEY (product_code) REFERENCES product (product_code),
    FOREIGN KEY (sup_id) REFERENCES supplier (sup_id)
);

-- order_product join table
CREATE TABLE IF NOT EXISTS orderdetail (
	order_number VARCHAR(20) NOT NULL,
    product_code VARCHAR(15) NOT NULL,
    qty_ordered INT(11) NOT NULL,
    price_each DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (order_number, product_code),
    FOREIGN KEY (product_code) REFERENCES product (product_code),
    FOREIGN KEY (order_number) REFERENCES orders (order_number)
);

-- payment table
CREATE TABLE IF NOT EXISTS payment (
	cus_id INT NOT NULL,
    payment_id INT(11) NOT NULL,
    payment_date DATE NOT NULL,
    payment_type VARCHAR(15) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
	PRIMARY KEY (cus_id, payment_id),
    FOREIGN KEY (cus_id) REFERENCES customer (cus_id)
);







