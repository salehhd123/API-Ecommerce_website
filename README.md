# E-commerce_website
Project Description<br>
E-commerce website using spting boot where users can add, get, update, delete and buy products<br>
(amazon clone)<br>

1-  Product Class:<br>
• id (must not be empty).
<br>• name (must not be empty, have to be more than 3 length long).
<br>• price (must not be empty, must be positive number).
<br>• categoryID (must not be empty).
<br>2-  Category Class:
<br>• id (must not be empty).
<br>• name (must not be empty, have to be more than 3 length long).
<br>3-  Merchant Class:
<br>• id (must not be empty).
<br>• name (must not be empty, have to be more than 3 length long).
<br>4-  MerchantStock Class:
<br>• id (must not be empty).
<br>• productid (must not be empty).
<br>• merchantid (must not be empty).
<br>• stock (must not be empty, have to be more than 10 at start).
<br>5-  User Class:
<br>• id (must not be empty).
<br>• username (must not be empty, have to be more than 5 length long).
<br>• password (must not be empty, have to be more than 6 length long, must have
<br>characters and digits).
<br>• email (must not be empty, must be valid email).
<br>• role (must not be empty, have to be in ( “Admin”,”Customer”)).
<br>• balance (must not be empty, have to be positive).
<br>6-  endpoint for getting and adding and deleting updating a Product.
<br>7-  endpoint for getting and adding and deleting updating a Category.
<br>8-  endpoint for getting and adding and deleting updating a Merchant.
<br>9-  endpoint for getting and adding and deleting updating a MerchantStock.
<br>10-  endpoint for getting and adding and deleting updating a User.
<br>11- endpoint where user can add more stocks of product to a merchant
<br>Stock
<br>• This endpoint should accept a product id and merchant id and the amount of
<br>additional stock.
<br>12-  endpoint where user can buy a product directly
<br>• This endpoint should accept user id, product id, merchant id.
<br>• check if all the given ids are valid or not
<br>• check if the merchant has the product in stock or return bad request.
<br>• reduce the stock from the MerchantStock.
<br>• deducted the price of the product from the user balance.
• if balance is less than the product price return bad request.
