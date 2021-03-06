DROP TABLE IF EXISTS Policy_Details;

CREATE TABLE Policy_Details (
  policy_number INT AUTO_INCREMENT(1000000000)  PRIMARY KEY,
  first_name VARCHAR(200) NOT NULL,
  last_name VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL,
  phone_number INT(10) NOT NULL
);

INSERT INTO Policy_Details (first_name, last_name, email, phone_number) VALUES
('Mahendra', 'kunku', 'mahendra@gmail.com',1234567890),
('Bill', 'Gates', 'billgates@gamil.com',01234567890);