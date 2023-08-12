# E-commerce_website
Project Description
E-commerce website using spting boot where users can add, get, update, delete and buy products
(amazon clone)

1-  Product Class:
• id (must not be empty).
• name (must not be empty, have to be more than 3 length long).
• price (must not be empty, must be positive number).
• categoryID (must not be empty).
2-  Category Class:
• id (must not be empty).
• name (must not be empty, have to be more than 3 length long).
3-  Merchant Class:
• id (must not be empty).
• name (must not be empty, have to be more than 3 length long).
4-  MerchantStock Class:
• id (must not be empty).
• productid (must not be empty).
• merchantid (must not be empty).
• stock (must not be empty, have to be more than 10 at start).
5-  User Class:
• id (must not be empty).
• username (must not be empty, have to be more than 5 length long).
• password (must not be empty, have to be more than 6 length long, must have
characters and digits).
• email (must not be empty, must be valid email).
• role (must not be empty, have to be in ( “Admin”,”Customer”)).
• balance (must not be empty, have to be positive).
6-  endpoint for getting and adding and deleting updating a Product.
7-  endpoint for getting and adding and deleting updating a Category.
8-  endpoint for getting and adding and deleting updating a Merchant.
9-  endpoint for getting and adding and deleting updating a MerchantStock.
10-  endpoint for getting and adding and deleting updating a User.
11- endpoint where user can add more stocks of product to a merchant
Stock
• This endpoint should accept a product id and merchant id and the amount of
additional stock.
12-  endpoint where user can buy a product directly
• This endpoint should accept user id, product id, merchant id.
• check if all the given ids are valid or not
• check if the merchant has the product in stock or return bad request.
• reduce the stock from the MerchantStock.
• deducted the price of the product from the user balance.
• if balance is less than the product price return bad request.
