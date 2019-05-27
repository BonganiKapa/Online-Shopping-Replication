--------PRODUCTS TABLE----------
create table PRODUCTS
(
id IDENTITY,
product_name VARCHAR(50)not null,
description VARCHAR(255)not null,
price FLOAT not null,
is_active BOOLEAN,
code VARCHAR(50) not null,
image_url VARCHAR(50),

CONSTRAINT pk_product_id PRIMARY KEY(id)
);


-----------CUSTOMER TABLE------------
create table CUSTOMER
(
id IDENTITY,
customer_name VARCHAR(50) not null,
last_name VARCHAR(50) not null,
DOB VARCHAR(10) not null,
street_address VARCHAR(50) not null,
post_address VARCHAR(50) not null,
email VARCHAR(50) not null,
phone_number VARCHAR(20) not null,

CONSTRAINT pk_customer_id PRIMARY KEY(id)
);


-------ORDERS TABLE--------
create table ORDERS
(
id IDENTITY,
amount DECIMAL not null,
order_date DATE(12) not null,
order_number INT not null,
customer_name VARCHAR(50) not null,
email VARCHAR(50) not null,
phone_number VARCHAR(20) not null,

CONSTRAINT pk_orders_id PRIMARY KEY(id)
);



-------ACCOUNTS TABLE (ADMIN)------
create table ACCOUNTS
(
user_name VARCHAR (20) not null,
password VARCHAR (20) not null,
user_role VARCHAR (20) not null,
active BOOLEAN,
);



------ORDER_DETAILS TABLE------
create table ORDER_DETAILS
(
id  IDENTITY,
amount DECIMAL not null,
order_number INT not null,
quantity INT not null,
product_id INT not null,

CONSTRAINT pk_orderDeatails_id PRIMARY KEY (id)
);

---------ADDRESS TABLE-------
create table ADDRESS
{

};