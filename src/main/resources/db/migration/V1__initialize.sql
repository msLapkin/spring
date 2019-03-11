

DROP TABLE IF EXISTS products;

CREATE TABLE products (
id          INT(11) NOT NULL AUTO_INCREMENT,
title       VARCHAR(50) NOT NULL,
price       DECIMAL (8,2) NOT NULL,
PRIMARY KEY(id) )
ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;



INSERT INTO products (title,price)
VALUES
('iPhone S500',	      50500),
('Honor U10',	        15600),
('ZenPhone X960',	    23900),
('Samsung A100',	    18600),
('Xiaomi E850',	      16500),
('TV Samsung',	      89000),
('TV Phillips', 	    75000),
('TV Acer',	          60000),
('Monitor Samsung',	  24000),
('Monitor Phillips',  26000),
('Monitor Acer',	    18000),
('Monitor Asus',	    19500),
('Monitor Dell',	    24900),
('Monitor HP',	      15600),
('Monitor AOC',	      16800),
('Mouse Razer',	      5500),
('Mouse Logitech',	  600),
('Keyboard Genius',	  1000),
('Keyboard Logitech',	1500),
('Keyboard Razer',    6000);