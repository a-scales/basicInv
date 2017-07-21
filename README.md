Basicinv Cloud Inventory
==================
The basicinv cloud inventory application provides a backend platform and api for inventory management.
It is designed to run on Google's App Engine and take advantage of the NoSql Datastore.


## Maven
This file is made for the google app engine. In order to delpoy or run the application, use the following.
### Running locally

    mvn appengine:run

### Deploying

    mvn appengine:deploy

## Getting Started ##
Once the application is running on the Cloud Platform, the API options currently are as follows:

### Creating Items ###
To create an item, you must make a POST request to /api/item/create with a properly formatted JSON string.
    curl -H "Content-Type: application/json" -X POST -d '{"sku":"12344","upc":"12344","name":"testMfr","color":"BLK","size":"","desc":"Test","location":"1","bin":"5","quantityOnHand":100,"purchasePrice":2.99,"salePrice":5.99,"msrp":5.99}' http://host:8080/api/item/create

### Getting Items ###
To get all Items you must make a GET request to /api/item/all
    curl -x GET http://host:8080/api/item/all

To get an item by SKU make a GET request to /api/item/sku
    curl -x GET http://host:8080/api/item/sku/12345
Replace 12345 with the SKU

To get an item by UPC make a GET request to /api/item/upc
    curl -x GET http://host:8080/api/item/upc/12345
Replace 12345 with the UPC

### Updating Items ###
To Update quantity on hand make a PUT request to /api/item/qty with a properly formatted inventory JSON string
    curl -H "Content-Type: application/json" -X PUT -d '{"sku":"12344","upc":"12344","name":"testMfr","color":"BLK","size":"","desc":"Test","location":"1","bin":"5","quantityOnHand":100,"purchasePrice":2.99,"salePrice":5.99,"msrp":5.99}' http://host:8080/api/item/qty
This method will be replaced with a better key/value update method soon.

## Testing
Unit tests coming soon.


