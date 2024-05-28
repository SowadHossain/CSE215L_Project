# CSE215L_Project



MD MAHMUDUR RAHMAN TONOY
ID : 2322988642SOWAD HOSSAIN
ID : 2323614042MD . ABU ZAWAD
ID : 2322739642Project Topic : Inventory Management and Billing Software
Due date : 24 / 05 / 2024
Course  name : CSE215L
Inventory Management and Billing software        24.05.2024
Goals
Develop an Inventory Management and Billing software for a CD & VINYL SHOP. They have categorized their products into three main segments: movies, games and music. As a startup they are also offering different discounts on their products to attract customers and may vary from product to product, and they are calling it product discount. They have a special discount named full house which is if someone buys at least two products from each category, he/she will get a discount of 50% on the total price. When billing an invoice if both of the discounts are eligible, the company wants to compare them. The discount that is larger of the two will be applied. The company wants you to keep a functionality which will show them the inventory. They also want to be able to sort their inventory according to: price and available stocks. 


Overview
This is basically a user-friendly program of a CD & Vinyl shop that sells movies , games and songs . Users can login to the program and ask for the thing they need .  
Uml Diagram

Class Descriptions

Product Class

The "Product" class serves as an abstract blueprint for various types of products within a retail system. Here"s a breakdown of its features:

-Fields: The class encapsulates essential attributes such as "name", "productId", "price", "genre", "yearPublished", and "discount", providing a comprehensive representation of product data.

- Constructor: The constructor initializes these fields when a new "Product" instance is created, allowing for instantiation with specific attribute values.
-Getter and Setter Methods: Accessor methods like "getName()", "getProductId()", "getPrice()", etc., enable retrieval and modification of individual field values, ensuring controlled access to the object"s state.

-Abstract Method: The "getInfo()" method is declared as abstract, indicating that concrete subclasses must implement this method to provide specific information about each product type.

-Utility Method: The "calculateFinalPrice()" method computes the final price of a product after applying a discount, facilitating price calculation functionality across different product types.
  
This class lays the foundation for implementing various product types with specialized behavior and information, promoting code reuse and extensibility within the retail system architecture.

Stockable Product Class


The "StockableProduct" class extends the "Product" class and implements the "Stockable" interface, introducing functionality related to stock management for retail products. Here"s an overview of its features:


- Fields: It introduces an additional field "numberOfItemsStocked" to represent the quantity of items available in stock for the product.


-Constructor: The constructor initializes the "StockableProduct" with attributes inherited from the "Product" class and sets the initial stock quantity.


- Interface Implementation: It implements the "Stockable" interface, requiring methods for adding, removing, and editing stock quantities.


- Stock Management Methods: Methods like "addStock(int num)", "removeStock(int num)", and "editStock(int num)" enable manipulation of the stock quantity, handling scenarios such as adding, removing, or editing stock levels while managing exceptions like "InsufficientStockException".
- Exception Handling: It defines a custom exception "InsufficientStockException" to handle situations where the requested stock removal exceeds the available quantity.


- Overridden Method: The "getInfo()" method is overridden from the "Product" class, although its implementation is not provided in this snippet.


- Accessor Method: "getNumberOfItemsInStock()" provides access to the current stock quantity of the product.


This class extends the functionality of the "Product" class to incorporate stock management capabilities, crucial for maintaining accurate inventory levels within a retail system.


This is a class which extends the Product class and implements the Stockable interface and where it can add and remove new stocks and follow the instructions  
Game Class


The "Game" class extends the "StockableProduct" class and implements the "Serializable" interface, defining a specialized type of product tailored for games within a retail system. Here"s an overview of its features:


- Fields: In addition to inheriting fields from "StockableProduct", it introduces a new field "developer" to store the name of the game's developer.
- Constructor: The constructor initializes a "Game" object with attributes inherited from "StockableProduct", along with the specific developer information.
- Accessor and Mutator Methods: "getDeveloper()" and "setDeveloper()" enable access to and modification of the game's developer information.
- "toString()" Method: Overrides the "toString()" method to provide a string representation of the "Game" object, including its ID, name, price, year of publication, genre, discount, stock quantity, and developer name.
- "getInfo()" Method: Overrides the "getInfo()" method inherited from "StockableProduct" to return detailed information about the game, including its name, ID, year of publication, genre, discount, price, and developer name.
- Serialization: Implements the "Serializable" interface to allow instances of the "Game" class to be serialized and deserialized, facilitating data persistence and transfer.


This class encapsulates the attributes and behavior specific to games, enhancing the flexibility and functionality of the retail system's product management capabilities.
Music Class
As we have a type of product named Music, we have created a class called “Music” which is a specialized class of the StockableProduct class and it has the  almost same getters, setters and constructors as the Game class.
Movie Class
Movie is also a specialized class of Stockable Product class which has a String director variable and basic getters and setters to generate the information like the other Game and Music classes.


Inventory Class


The "Inventory" class represents the stock inventory of a retail system, managing a collection of "StockableProduct" items. Here"s an overview of its functionalities:


- Fields: It contains a private field "items", an ArrayList of "StockableProduct" objects, to store the inventory items.


- Constructor: Initializes the "Inventory" object with an ArrayList of "StockableProduct" items passed as a parameter.


- Add and Remove Methods: Includes methods like "addItems(StockableProduct product)" to add new products to the inventory and "removeItem(int productId)" to remove a product based on its ID.


- Get Item Method: The "getItem(int productId)" method retrieves a product from the inventory based on its ID and reduces its stock quantity by one.


- Stock Management Methods: Provides methods like "addProductStock(int productId, int numberOfNewStock)" to increase the stock quantity of a product by a specified amount.


- Sorting Methods: Implements sorting functionalities with methods like "sortByPrice()" and "sortByAvailableStock()" to sort the inventory items based on their price and available stock quantity, respectively.


- Accessor Method: Provides a getter method "getItems()" to retrieve the ArrayList of inventory items.


The "Inventory" class serves as a central component for managing and organizing the stock inventory of the retail system, offering essential operations such as adding, removing, retrieving, and sorting inventory items.


Invoice class

The "Invoice" class manages invoices for retail transactions within the system, providing functionalities related to cart management, price calculation, and invoice generation. Here"s an overview of its features:

- Fields: It maintains an ArrayList "cart" to store the products added to the invoice and a "date" field representing the invoice creation date.

- Constructors: Includes an empty constructor and a parameterized constructor to initialize the invoice with a list of products.

- Date Retrieval Method: The "getLocalDateTime()" method retrieves the current date and time in the format "yyyy-MM-dd HH:mm:ss".

- Cart Management Methods: Provides methods like "addProduct(Product product)" and "removeProduct(Product product)" to add and remove products from the invoice cart, respectively. Upon removal, the stock quantity of the corresponding product is updated in the inventory.

- Price Calculation Methods: Utilizes methods like "calculatePriceWithoutDiscount()" and "calculateDiscountedPrice()" to compute the total price of items in the cart before and after applying discounts, respectively.

- Discount Application: Checks for the availability of a full-house discount through the "isFullHouseDiscountAvailable()" method and applies it if applicable.

- Stock Information Method: The "numberOfItemsStockOfEachSoldProduct()" method retrieves and displays the available stock quantity for each sold product in the inventory.

- Invoice Generation: The "getInvoice()" method generates an invoice string containing details such as the date, product names, prices, total price before discount, and discounted price.

Overall, the "Invoice" class plays a crucial role in facilitating retail transactions, managing cart contents, applying discounts, and generating invoices for customers.

Customer Class
This class updates all the information about customers such as their name , mail address , their id , number of their total check-ins , total money they spent on this etc
Employee Class
 This class contains all the information about the employees who work on this company like their name , id , positions , password etc
LoadDataSaveData Class
The "LoadDataSaveData" class facilitates the management of employee, customer, and inventory data through reading from and writing to text files. It includes:


- Static fields such as "employeeLoginData", "customerData", "employeeData", and "inventoryData" to store login credentials, customer records, employee records, and inventory items, respectively.


- Methods like "loadCustomerData()", "loadEmployeeData()", and "loadInventoryData()" to load data from corresponding text files into the appropriate data structures.


- Methods like "saveCustomerData()", "saveEmployeeData()", and "saveInventoryData()" to write data from memory back to text files.


- Getter methods ("getEmployeeLoginData()", "getCustomerData()", 
"getEmployeeData()", "getInventoryData()") to access the stored data.


- Basic error handling for IO exceptions, although it could be improved for better error reporting.
- Data parsing using "String.split(",")" to extract fields from lines in the text files.


- Conditional logic to handle different product categories when loading inventory data.


- File writing using "BufferedWriter" and "FileWriter", though there"s a serialization discrepancy labeling "Music" and "Game" products as "Movie" in the inventory data file.
 
Custom Exceptions
There are many customer exceptions used in this program to run it more smoothly
1.CustomerNotFoundException
2.EmployeeAlreadyExistsException
3.LoginFailedException
4.ProductNotFoundException
GUI
A Java GUI, or Graphical User Interface, is a way to create graphical interfaces for applications written in Java. It allows users to interact with the program through visual elements like buttons, menus, text fields, and more.
 
Java GUI is used in this project to make this project more user friendly  . The effect will be noticed in the login screen and then after login , some buttons will pop up and the user can select their desired options
APPLICATION
This code has a simple application system which takes orders from the customers and generates a bill . It can also save the customer details including the total money they spent on this . It can give discounts to customers on various products .
Limitations
This program has some limitations like
1.It does not take any feedback from the client
2. It is a user friendly program but not as user friendly as some other programs
3.Database is not used in this program
Future works
This program have a lots of potentials if some changes are made in the future like
Adding database system into this program
Keeping a feedback form for the customers
Updating the customers about our new offers and stocks through this program
Contributions
Zawad  -


Class:
Product
StockableProduct
Stockable
Custom Exceptions

Methods:
addNewProduct()
deleteProduct()
getProductDetails()
customerInfo()
Tonoy -

Class:
Game 
Movie 
Music
Driver
SignIn

Methods:
addCustomer()
customerInfo()
deleteCustomerData
Sowad -

Class:
Invoice
Inventory
LoadDataSaveData
LoginForm
HomePage
Billing

Methods:
updateProductInfo()
updateCustomerInfo()
