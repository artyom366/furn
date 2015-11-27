#####This test project consists of:

* HSQL in-memory data base
* REST service
* Embedded TomCat server
* Runs on Java 1.8

#####Compile and run

To compile the project run the following command:
>mnv: clean install

The compiled jar should be located in the target directory
To run the app, start jar file from the console:
>java -jar [/path/to/jar]/*.jar

Then use the following url:
>localhost:8080/[rest api resource]

There are some test data predefined in the database. 
In order to get and manipulate the data use api:

######Clients
* /api/clients - get all clients [GET]    
* /api/clients/get/{id} - get client by id [GET]
* /api/clients/put - save client [PUT]

######Products
* api/products - get all products [GET]
* api/products/get/{id} - get product by id [GET]
* api/products/put - save product [PUT]

######Rebates
* /api/rebates - get all rebates [GET]
* /api/rebates/get/{id} - get rebate by id [GET]
* /api/rebates/put - save rebate [PUT]

######Documents
* /api/documents - get all documents [GET]
* /api/documents/get/{id} - get document by id [GET]
* /api/documents/put - save document [PUT]

#####Examples
Use example json files from project example directory to add new entries into data base. 

Use document_import.json and document_export.json as a raw request data to test the software.